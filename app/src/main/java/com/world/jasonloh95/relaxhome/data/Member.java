package com.world.jasonloh95.relaxhome.data;

/**
 * Created by JasonLoh95 on 28/9/2017.
 */

public class Member {
    private String name;
    private String Email;
    private String Password;
    private String contactNumber;

    public  Member (){

    }
    public Member (String name, String Email, String contactNumber ){
        this.name = name;
        this.Email =Email;
        this.contactNumber = contactNumber;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return Email;
    }

    public String getPassword(){
        return Password;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }

    public void setPassword (String Password){
        this.Password = Password;
    }

    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }

    public boolean authenticateUser (String Email, String password){
            if (this.Email.equals(Email)){
                if(getPassword() == password){
                    return true;
                }else {
                    return false;
                }
            }else {
                return false;
        }

    }
}
