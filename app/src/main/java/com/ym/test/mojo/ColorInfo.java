package com.ym.test.mojo;

import android.graphics.Color;

public class ColorInfo {
    private int id;
    private String name;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    int color;
    public ColorInfo(int id,String name,int color){
        this.id=id;
        this.name=name;
        this.color=color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
