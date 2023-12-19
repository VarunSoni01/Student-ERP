package com.college.acc_soft.Notification;

public class NoitficationData {
    String title,message;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NoitficationData(String title, String message) {
        this.title = title;
        this.message = message;
    }
}
