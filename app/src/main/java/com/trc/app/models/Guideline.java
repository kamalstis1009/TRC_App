package com.trc.app.models;

public class Guideline {

    private int id;
    private String guideText;
    private String imageName;

    public Guideline(String guideText, String imageName) {
        this.guideText = guideText;
        this.imageName = imageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuideText() {
        return guideText;
    }

    public void setGuideText(String guideText) {
        this.guideText = guideText;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
