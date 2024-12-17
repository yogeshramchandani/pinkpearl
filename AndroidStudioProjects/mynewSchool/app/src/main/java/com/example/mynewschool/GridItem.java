package com.example.mynewschool;

public class GridItem {
    private final int imageResId; // Resource ID for the image
    private final String text;   // Text description

    // Constructor
    public GridItem(int imageResId, String text) {
        this.imageResId = imageResId;
        this.text = text;
    }

    // Getter for image resource ID
    public int getImageResId() {
        return imageResId;
    }

    // Getter for text
    public String getText() {
        return text;
    }
}
