package com.example.hamzasaleem.hci_new;

public class CategoryObject {

    int categoryPhoto;
    String  cateogyName;

    public CategoryObject(int categoryPhoto, String cateogyName) {
        this.categoryPhoto = categoryPhoto;
        this.cateogyName = cateogyName;
    }

    public int getCategoryPhoto() {
        return categoryPhoto;
    }

    public void setCategoryPhoto(int categoryPhoto) {
        this.categoryPhoto = categoryPhoto;
    }

    public String getCateogyName() {
        return cateogyName;
    }

    public void setCateogyName(String cateogyName) {
        this.cateogyName = cateogyName;
    }
}
