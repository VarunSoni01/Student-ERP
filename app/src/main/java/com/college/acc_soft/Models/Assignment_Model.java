package com.college.acc_soft.Models;

public class Assignment_Model {

    String subject;
    String link;

    public Assignment_Model() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Assignment_Model(String subject, String link, String ass_no, String by, String pub_date, String up_date) {
        this.subject = subject;
        this.link = link;
        this.ass_no = ass_no;
        this.by = by;
        this.pub_date = pub_date;
        this.up_date = up_date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAss_no() {
        return ass_no;
    }

    public void setAss_no(String ass_no) {
        this.ass_no = ass_no;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getPub_date() {
        return pub_date;
    }

    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }

    public String getUp_date() {
        return up_date;
    }

    public void setUp_date(String up_date) {
        this.up_date = up_date;
    }

    String ass_no;
    String by;
    String pub_date;
    String up_date;

}
