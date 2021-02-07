package com.example.placetovisitinistanbul;

import android.graphics.Bitmap;

public class Singleton {
    private Bitmap bitmap;
    private String name;
    private static Singleton singleton;
    private Singleton(){

    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static Singleton getInstance(){
        if(singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }

}
