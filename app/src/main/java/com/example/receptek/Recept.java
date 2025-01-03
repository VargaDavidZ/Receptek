package com.example.receptek;

public class Recept {
    private String title;
    private String  quality;
    private String  difficulity;

    public Recept(String title, String quality, String difficulity) {
        this.title = title;
        this.quality = quality;
        this.difficulity = difficulity;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getDifficulity() {
        return difficulity;
    }

    public void setDifficulity(String difficulity) {
        this.difficulity = difficulity;
    }

    @Override
    public String toString() {
        return "Recept{" +
                "title='" + title + '\'' +
                ", quality=" + quality +
                ", difficulity=" + difficulity +
                '}';
    }
}
