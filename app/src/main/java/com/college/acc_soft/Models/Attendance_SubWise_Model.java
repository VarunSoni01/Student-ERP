package com.college.acc_soft.Models;

public class Attendance_SubWise_Model {
    String pre,abs,na,lea,sub;

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getNa() {
        return na;
    }

    public void setNa(String na) {
        this.na = na;
    }

    public String getLea() {
        return lea;
    }

    public void setLea(String lea) {
        this.lea = lea;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public Attendance_SubWise_Model(String pre, String abs, String na, String lea, String sub) {
        this.pre = pre;
        this.abs = abs;
        this.na = na;
        this.lea = lea;
        this.sub = sub;
    }
}
