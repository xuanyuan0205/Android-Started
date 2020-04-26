package com.ym.test.mojo;

public class User {
    private int imgId;
    private String content;
    public User(){}
    public User(int imgId, String content) {
        this.imgId = imgId;
        this.content = content;
    }
    public int getImgId() {
        return imgId;
    }

    public String getContent() {
        return content;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
