package com.college.acc_soft.Notification;

public class PushNotification {
    String to;
    NoitficationData data;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public NoitficationData getData() {
        return data;
    }

    public void setData(NoitficationData data) {
        this.data = data;
    }

    public PushNotification(NoitficationData data, String to) {
        this.to = to;
        this.data = data;
    }
}
