package com.zzyy.dev.allin.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class DepositMoney extends BaseMoney {

    private String context;

    private String getDate;//收款日期

    private String getMoney;//收款金额

    private String payDate;//付款日期

    private String payMoney;//付款金额

    private String backDate;//回款日期

    private String backMoney;//回款金额

    private String returnDate;//退款日期

    private String returnMoney;//退款金额

    private String balance;//余额

    private String remark;//备注

    public DepositMoney() {
    }

    public DepositMoney(String context, String getDate, String getMoney, String payDate, String payMoney, String backDate, String backMoney, String returnDate, String returnMoney, String balance, String remark) {
        this.context = context;
        this.getDate = getDate;
        this.getMoney = getMoney;
        this.payDate = payDate;
        this.payMoney = payMoney;
        this.backDate = backDate;
        this.backMoney = backMoney;
        this.returnDate = returnDate;
        this.returnMoney = returnMoney;
        this.balance = balance;
        this.remark = remark;
    }
}
