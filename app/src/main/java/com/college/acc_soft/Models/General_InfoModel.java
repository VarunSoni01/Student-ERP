package com.college.acc_soft.Models;

import android.media.Image;
import android.widget.ImageView;

public class General_InfoModel {
    String scholar,enroll,course,collage;
    String text;
    int image;

    public int getImage() {
        return image;
    }

    public void


    setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public General_InfoModel(String text, int image) {
        this.text = text;
        this.image = image;
    }

    public String getScholar() {
        return scholar;
    }

    public void setScholar(String scholar) {
        this.scholar = scholar;
    }

    public String getEnroll() {
        return enroll;
    }

    public void setEnroll(String enroll) {
        this.enroll = enroll;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public General_InfoModel(String scholar, String enroll, String course, String collage) {
        this.scholar = scholar;
        this.enroll = enroll;
        this.course = course;
        this.collage = collage;
    }
}
