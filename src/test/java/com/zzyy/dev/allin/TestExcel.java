package com.zzyy.dev.allin;

import com.zzyy.dev.allin.entity.LvYueMoney;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestExcel {


    @Test
    public void testRead() {

        String fileName = "C:\\Users\\zzyy\\Desktop\\全部履约.xlsx";

        try (FileInputStream inputStream = new FileInputStream(fileName);) {
            //new一个输入流

            //new一个workbook
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            //创建一个sheet对象，参数为sheet的索引
            XSSFSheet sheet = workbook.getSheetAt(0);

            int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
            System.out.println(String.format("excel共[%s]行", physicalNumberOfRows));

            List<LvYueMoney> lvYueMoneyList = new ArrayList<>();
            for (int i = 1; i < physicalNumberOfRows; i++) {

                XSSFRow row = sheet.getRow(i);
                String subJectCode = (String) getCellValue(row, 0);//科目代码
                String subjectName = (String) getCellValue(row, 1);//科目名称
                Date openDate = (Date) getCellValue(row, 2);//日期
                Date empDate = (Date) getCellValue(row, 3);//业务日期
                String proof = (String) getCellValue(row, 4);//凭证字号
                String info = (String) getCellValue(row, 5);
                String remark = (String) getCellValue(row, 6);
                BigDecimal debitMoney = (BigDecimal) getCellValue(row, 13);
                BigDecimal creditMoney = (BigDecimal) getCellValue(row, 14);
                BigDecimal money = (BigDecimal) getCellValue(row, 16);

                LvYueMoney lvYueMoney = new LvYueMoney(subJectCode, subjectName, openDate, empDate, proof, info, remark, debitMoney, creditMoney, money);
                lvYueMoneyList.add(lvYueMoney);
            }

            System.out.println(lvYueMoneyList);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Object getCellValue(XSSFRow row, int index) {
        XSSFCell cell = row.getCell(index);
        if (cell == null) {
            return null;
        }

        switch (cell.getCellTypeEnum()) {
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", LocaleUtil.getUserLocale());
                    sdf.setTimeZone(LocaleUtil.getUserTimeZone());
                    return cell.getDateCellValue();
                }

                return BigDecimal.valueOf(cell.getNumericCellValue());
            case STRING:
                return cell.getRichStringCellValue().toString();
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            case BOOLEAN:
                return cell.getBooleanCellValue() ? "TRUE" : "FALSE";
            case ERROR:
                return ErrorEval.getText(cell.getErrorCellValue());
            default:
                return "Unknown Cell Type: " + cell.getCellTypeEnum();
        }

    }

}
