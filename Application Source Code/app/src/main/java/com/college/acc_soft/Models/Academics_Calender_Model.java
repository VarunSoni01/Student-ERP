package com.college.acc_soft.Models;

public class Academics_Calender_Model {
    String data,sub;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public Academics_Calender_Model(String data, String sub) {
        this.data = data;
        this.sub = sub;
    }
}
