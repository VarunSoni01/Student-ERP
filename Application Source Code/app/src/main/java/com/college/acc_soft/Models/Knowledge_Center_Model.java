package com.college.acc_soft.Models;

public class Knowledge_Center_Model {
    String sub,detail,date;

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Knowledge_Center_Model(String sub, String detail, String date) {
        this.sub = sub;
        this.detail = detail;
        this.date = date;
    }
}
