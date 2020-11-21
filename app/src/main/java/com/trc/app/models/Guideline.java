package com.trc.app.models;

public class Guideline {

    private int id;
    private String guideTitle;
    private String guideText;
    private String imageName;

    public Guideline(String guideTitle, String guideText) {
        this.guideTitle = guideTitle;
        this.guideText = guideText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuideTitle() {
        return guideTitle;
    }

    public void setGuideTitle(String guideTitle) {
        this.guideTitle = guideTitle;
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
