package com.world.jasonloh95.relaxhome.data;

/**
 * Created by JasonLoh95 on 6/10/2017.
 */

public class companyDetail {
    private String name;
    private String website;
    private  String email;
    private String address;
    private String phoneNumber;
    private int photo;
    public companyDetail(){


    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getwebsite(){
        return website;
    }

    public void setwebsite(String website){
        this.website = website;
    }

    public String getemail(){
        return email;
    }

    public void setemail(String email){
        this.email = email;
    }

    public String getaddress(){
        return address;
    }

    public void setaddress(String address){
        this.address = address;
    }

    public String getphoneNumber(){
        return phoneNumber;
    }

    public void setphoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public int getPhoto(){return photo;}

    public void setPhoto(int image){this.photo= image;}
}
