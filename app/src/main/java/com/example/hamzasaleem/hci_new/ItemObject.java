package com.example.hamzasaleem.hci_new;

/**
 * Created by hamzasaleem on 19/04/2016.
 */
public class ItemObject {

    private int image;
    private String objName;

    public ItemObject(int image, String objName) {
        this.image = image;
        this.objName = objName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }
}
