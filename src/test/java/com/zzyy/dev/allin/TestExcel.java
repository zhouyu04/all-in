package com.zzyy.dev.allin;

import com.alibaba.fastjson.JSON;
import com.zzyy.dev.allin.entity.DepositMoney;
import com.zzyy.dev.allin.entity.LvYueMoney;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestExcel {

    DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", LocaleUtil.getUserLocale());

    DateFormat yearMonth = new SimpleDateFormat("yyyy-MM", LocaleUtil.getUserLocale());


    private Date maxDate = null;

    public Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }


    @Test
    public void testRead() throws Exception {

        String lvYueFile = "I:\\脚本\\全部履约.xlsx";
        List<LvYueMoney> lvYueMonies = readLvYueExcelToBean(lvYueFile);//获取履约EXCEL信息

        //按月份转换成map
        Map<String, List<LvYueMoney>> lvYueMap = convertLvYueMap(lvYueMonies);

        System.out.println(JSON.toJSONString(lvYueMap));

        //获取最大月份 并获取最大月份的数据
        String format = yearMonth.format(maxDate);
        List<LvYueMoney> maxList = lvYueMap.get(format);
        System.out.println(JSON.toJSONString(maxList));


        String depositFile = "I:\\脚本\\履约保证金登记表20210430 - 副本.xlsx";
        List<DepositMoney> depositMonies = readDepositExcelToBean(depositFile);
        Map<String, List<DepositMoney>> depositMap = convertDepositMap(depositMonies);

        System.out.println(JSON.toJSONString(depositMap));

        System.out.println("excel读取完成");


    }

    private Map<String, List<DepositMoney>> convertDepositMap(List<DepositMoney> depositMonies) {

        Map<String, List<DepositMoney>> map = new HashMap<>();
        if (CollectionUtils.isEmpty(depositMonies)) {
            return map;
        }

        for (DepositMoney depositMoney : depositMonies) {

            String Date

            depositMoney.getPayDate();



        }

        depositMonies.clear();

        return map;
    }

    private Map<String, List<LvYueMoney>> convertLvYueMap(List<LvYueMoney> lvYueMonies) throws ParseException {

        Map<String, List<LvYueMoney>> map = new HashMap<>();
        if (CollectionUtils.isEmpty(lvYueMonies)) {
            return map;
        }


        for (LvYueMoney lvYueMoney : lvYueMonies) {

            String openDate = lvYueMoney.getOpenDate();
            Date parse = sdf.parse(openDate);
            lvYueMoney.setSortDate(parse);
        }

        lvYueMonies.sort(((o1, o2) -> o1.getSortDate().before(o2.getSortDate() )));

        for (LvYueMoney lvYueMoney : lvYueMonies) {

            String openDate = lvYueMoney.getOpenDate();
            Date parse = sdf.parse(openDate);
            if (maxDate == null) {
                setMaxDate(parse);
            } else {
                maxDate = parse.after(maxDate) ? parse : maxDate;
                setMaxDate(maxDate);
            }

            String format = yearMonth.format(parse);

            if (map.containsKey(format)) {
                map.get(format).add(lvYueMoney);
            } else {
                List<LvYueMoney> list = new ArrayList<>();
                list.add(lvYueMoney);
                map.put(format, list);
            }
        }

        lvYueMonies.clear();
        return map;
    }

    private List<DepositMoney> readDepositExcelToBean(String fileName) {
        List<DepositMoney> depositMoneyList = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(fileName);) {
            //new一个输入流

            //new一个workbook
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            //创建一个sheet对象，参数为sheet的索引
            XSSFSheet sheet = workbook.getSheetAt(0);

            int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
            System.out.println(String.format("excel共[%s]行", physicalNumberOfRows));

            for (int i = 3; i < physicalNumberOfRows; i++) {

                XSSFRow row = sheet.getRow(i);

                String context = getCellValue(row, 0);//内容
                String getDate = getCellValue(row, 1);//收款日期
                String getMoney = getCellValue(row, 2);//收款金额
                String payDate = getCellValue(row, 3);//付款日期
                String payMoney = getCellValue(row, 4);//付款金额
                String backDate = getCellValue(row, 5);//回款日期
                String backMoney = getCellValue(row, 6);//回款金额
                String returnDate = getCellValue(row, 7);//退款日期
                String returnMoney = getCellValue(row, 8);
                String balance = getCellValue(row, 18);
                String remark = getCellValue(row, 13);

                DepositMoney depositMoney = new DepositMoney(context, getDate, getMoney, payDate, payMoney, backDate, backMoney, returnDate, returnMoney, balance, remark);
                depositMoney.setIndex(i + 1 + "");
                depositMoneyList.add(depositMoney);
            }

            System.out.println(JSON.toJSONString(depositMoneyList));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return depositMoneyList;

    }


    private List<LvYueMoney> readLvYueExcelToBean(String fileName) {
//        String fileName = "I:\\脚本\\全部履约.xlsx";
        List<LvYueMoney> lvYueMoneyList = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(fileName);) {
            //new一个输入流

            //new一个workbook
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            //创建一个sheet对象，参数为sheet的索引
            XSSFSheet sheet = workbook.getSheetAt(0);


            int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
            System.out.println(String.format("excel共[%s]行", physicalNumberOfRows));

            for (int i = 1; i < physicalNumberOfRows; i++) {

                XSSFRow row = sheet.getRow(i);
                String subJectCode = getCellValue(row, 0);//科目代码
                String subjectName = getCellValue(row, 1);//科目名称
                String openDate = getCellValue(row, 2);//日期
                String empDate = getCellValue(row, 3);//业务日期
                String proof = getCellValue(row, 4);//凭证字号
                String info = getCellValue(row, 5);
                String remark = getCellValue(row, 6);
                String debitMoney = getCellValue(row, 13);
                String creditMoney = getCellValue(row, 14);
                String money = getCellValue(row, 16);

                LvYueMoney lvYueMoney = new LvYueMoney(subJectCode, subjectName, openDate, empDate, proof, info, remark, debitMoney, creditMoney, money);
                lvYueMoney.setIndex(i + 1 + "");
                lvYueMoneyList.add(lvYueMoney);
            }

            System.out.println(JSON.toJSONString(lvYueMoneyList));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lvYueMoneyList;

    }


    private String getCellValue(XSSFRow row, int index) {
        XSSFCell cell = row.getCell(index);
        if (cell == null) {
            return null;
        }
        String value = "";

        switch (cell.getCellTypeEnum()) {
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", LocaleUtil.getUserLocale());
                    sdf.setTimeZone(LocaleUtil.getUserTimeZone());
                    value = sdf.format(cell.getDateCellValue());
                    break;
                }

                double numericCellValue = cell.getNumericCellValue();

                BigDecimal bigDecimal = BigDecimal.valueOf(numericCellValue);

                value = bigDecimal.toString();
                break;
            case STRING:
                value = cell.getRichStringCellValue().toString();
                break;
            case FORMULA:
                value = cell.getCellFormula();
                break;
            case BLANK:
                value = "";
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue() ? "TRUE" : "FALSE";
                break;
            case ERROR:
                value = ErrorEval.getText(cell.getErrorCellValue());
                break;
            default:
                value = "Unknown Cell Type: " + cell.getCellTypeEnum();
                break;
        }

        return value;
    }

}
