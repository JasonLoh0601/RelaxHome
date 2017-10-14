package com.world.jasonloh95.relaxhome.data;

import java.util.Date;

/**
 * Created by JasonLoh95 on 4/10/2017.
 */

public class orders {
   private int orderId =0;
    private String orderDate;
    private String companyName;
    private String phone;
    private  String requirement;
    private String performDate;
    private String address;
    private String email;

    public orders(){

    }

    public orders( String companyName, String orderDate,String PerformDate,String phone, String requirement , String address,String email){
        this.companyName = companyName;
        this.orderDate = orderDate;
        this.performDate = PerformDate;
        this.phone = phone;
        this.requirement=requirement;
        this.address=address;
        this.email = email;

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }



    public String getPerformDate() {
        return performDate;
    }

    public void setPerformDate(String performDate) {
        this.performDate = performDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
