package com.company.enums;

public enum ImageAlbum {
    Background("/green.jpg"),
    Rabbit("/rabbit.png");

    private String path;

    ImageAlbum(String path) {
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
