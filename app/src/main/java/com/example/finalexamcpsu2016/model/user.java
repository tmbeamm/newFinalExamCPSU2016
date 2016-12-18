package com.example.finalexamcpsu2016.model;

/**
 * Created by tmbeamm on 12/18/2016 AD.
 */

public class user {
    private String mName;
    private String mImage;
    public user(String name,String image){
        this.mImage = image;
        this.mName = name;
    }

    public String getmImage() {
        return mImage;
    }

    public String getmName() {
        return mName;
    }
}
