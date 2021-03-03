package edu.temple.selectanddisplay;

public class Dino {

    // data
    private String name;
    private int imageRes;

    // constructor
    public Dino(String name, int imageRes) {
        this.name = name;
        this.imageRes = imageRes;
    }

    // getters
    public String getName() {
        return name;
    }

    public int getImageRes() {
        return imageRes;
    }

}
