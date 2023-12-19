package com.college.acc_soft.Models;

public class Nav_list_Model {

    int image;
    String name;

    public Nav_list_Model(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public Nav_list_Model() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
