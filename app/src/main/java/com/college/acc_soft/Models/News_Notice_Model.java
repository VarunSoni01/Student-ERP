package com.college.acc_soft.Models;

public class News_Notice_Model {
    String date,sub,desc;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public News_Notice_Model(String sub, String desc, String date) {
        this.date = date;
        this.sub = sub;
        this.desc = desc;
    }
}
