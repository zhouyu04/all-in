package com.zzyy.dev.allin.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class LvYueMoney extends BaseMoney{

    //科目代码
    private String subjectCode;

    private String subjectName;

    private String openDate;

    private String empDate;

    //凭证
    private String proof;

    //参考信息
    private String info;

    //摘要
    private String remark;

    //借方金额
    private String debitMoney;

    //贷方金额
    private String creditMoney;

    private String money;


    public LvYueMoney() {
    }

    public LvYueMoney(String subjectCode, String subjectName, String openDate, String empDate, String proof, String info, String remark, String debitMoney, String creditMoney, String money) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.openDate = openDate;
        this.empDate = empDate;
        this.proof = proof;
        this.info = info;
        this.remark = remark;
        this.debitMoney = debitMoney;
        this.creditMoney = creditMoney;
        this.money = money;
    }
}
