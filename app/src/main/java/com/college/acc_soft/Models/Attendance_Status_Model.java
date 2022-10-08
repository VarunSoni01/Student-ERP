package com.college.acc_soft.Models;

public class Attendance_Status_Model {
    String sub,status,lec,date;

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLec() {
        return lec;
    }

    public void setLec(String lec) {
        this.lec = lec;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Attendance_Status_Model(String sub, String status, String lec, String date) {
        this.sub = sub;
        this.status = status;
        this.lec = lec;
        this.date = date;
    }
}
