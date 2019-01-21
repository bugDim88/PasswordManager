package com.litrud.passwordmanager;


public class Category {
    private int iconID;
    private String name;

    public static final Category[] categories = {
            new Category(),
            new Category(R.drawable.test_icon, "test_1"),
            new Category(R.drawable.test_icon, "test_2"),
            new Category(R.drawable.test_icon, "test_3")
    };


    // category by default
    public Category() {
        this.iconID = R.drawable.arrows;
        this.name = "No category";
    }

    public Category(int iconID, String name) {
        this.iconID = iconID;
        this.name = name;
    }

    public int getIconID() {
        return iconID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
