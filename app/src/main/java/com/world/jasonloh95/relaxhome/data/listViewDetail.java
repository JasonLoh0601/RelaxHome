package com.world.jasonloh95.relaxhome.data;

/**
 * Created by JasonLoh95 on 10/10/2017.
 */

public class listViewDetail {
    private String name;
    private int photo;
    public listViewDetail (String name, int photo){
        this.name = name;
        this.photo = photo;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public int getPhoto(){
        return photo;
    }

    public void setPhoto(int image){
        this.photo= image;
    }
}
