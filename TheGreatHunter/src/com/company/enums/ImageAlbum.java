package com.company.enums;

public enum ImageAlbum {
    Background("/green.jpg"),
    Button("/button.png"),
    Rabbit("/rabbit.png"),
    Duck("/duck.png"),
    Fox("/fox.png"),
    Wolf("/wolf.png"),
    Deer("/deer.png"),
    Boar("/boar.png"),
    Eagle("/eagle.png");
	
    private String path;

    ImageAlbum(String path) {
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
