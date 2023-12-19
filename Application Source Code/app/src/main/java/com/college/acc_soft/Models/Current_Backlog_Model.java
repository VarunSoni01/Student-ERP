package com.college.acc_soft.Models;

public class Current_Backlog_Model {
    String subject,sem;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public Current_Backlog_Model(String subject, String sem) {
        this.subject = subject;
        this.sem = sem;
    }
}
