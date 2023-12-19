package com.college.acc_soft.Models;

public class Student_Ledger_Model {
    String amount,status,remark,date;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Student_Ledger_Model(String amount, String status, String remark, String date) {
        this.amount = amount;
        this.status = status;
        this.remark = remark;
        this.date = date;
    }
}
