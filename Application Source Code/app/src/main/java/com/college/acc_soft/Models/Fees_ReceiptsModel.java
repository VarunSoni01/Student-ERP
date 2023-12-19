package com.college.acc_soft.Models;

public class Fees_ReceiptsModel {
    String amount,status,vouchernum,voucherdate;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVouchernum() {
        return vouchernum;
    }

    public void setVouchernum(String vouchernum) {
        this.vouchernum = vouchernum;
    }

    public String getVoucherdate() {
        return voucherdate;
    }

    public void setVoucherdate(String voucherdate) {
        this.voucherdate = voucherdate;
    }

    public Fees_ReceiptsModel(String amount, String status, String vouchernum, String voucherdate) {
        this.amount = amount;
        this.status = status;
        this.vouchernum = vouchernum;
        this.voucherdate = voucherdate;
    }
}
