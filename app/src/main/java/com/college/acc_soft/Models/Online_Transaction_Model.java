package com.college.acc_soft.Models;

public class Online_Transaction_Model {
    String amount,status,date;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Online_Transaction_Model(String amount, String status, String date) {
        this.amount = amount;
        this.status = status;
        this.date = date;
    }
}
