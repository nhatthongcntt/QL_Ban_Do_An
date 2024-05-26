package com.example.ql_ban_do_an.Model;

public class Category {
    private int id;
    private String imagePath;
    private String Name;

    public Category() {

    }

    public Category(int id, String imagePath, String name) {
        this.id = id;
        this.imagePath = imagePath;
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
