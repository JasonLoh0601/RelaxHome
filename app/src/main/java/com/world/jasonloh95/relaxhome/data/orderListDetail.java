package com.world.jasonloh95.relaxhome.data;

/**
 * Created by JasonLoh95 on 14/10/2017.
 */

public class orderListDetail {
    private String company;
    private String date;

    public orderListDetail(){

    }

    public orderListDetail(String company,String date){
        this.company = company;
        this.date = date;
    }

    public String getcompany() {
        return company;
    }

    public String getdate() {
        return date;
    }
}
