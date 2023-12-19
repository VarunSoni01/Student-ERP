package com.college.acc_soft.Models;

public class E_Online_Teaching_Model {
    String subject,timing,date;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public E_Online_Teaching_Model(String subject, String timing, String date) {
        this.subject = subject;
        this.timing = timing;
        this.date = date;
    }
}
