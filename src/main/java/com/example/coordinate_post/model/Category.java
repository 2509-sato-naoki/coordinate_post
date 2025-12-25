package com.example.coordinate_post.model;

public enum Category {
    COAT("コート"),
    LOAFERS("ローファー");
    private final String label;

    Category(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static String getLabel(String name) {
        for (Category c : values()) {
            if (c.name().equals(name)) {
                return c.getLabel();
            }
        }
        return "";
    }
}
