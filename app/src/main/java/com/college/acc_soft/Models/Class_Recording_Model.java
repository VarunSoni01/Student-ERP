package com.college.acc_soft.Models;

public class Class_Recording_Model {
    String sub,topic,date;

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Class_Recording_Model(String sub, String topic, String date) {
        this.sub = sub;
        this.topic = topic;
        this.date = date;
    }
}
