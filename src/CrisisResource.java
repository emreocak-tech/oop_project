package com.mycompany.mentalproject;

public class CrisisResource {
    private String name;
    private String phoneNumber;
    private String description;
    private boolean is24hours;
    public CrisisResource(String name, String phoneNumber, String description, boolean is24Hours){
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.description=description;
        this.is24hours=is24Hours;
    }
    public String getName(){
        return name;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getDescription(){
        return description;
    }
    public boolean getIs24Hours(){
        return is24hours;
    }
    public void getHelp(){
        System.out.println("Name :" + " " + getName() + " " + "Phone Number :" + " " + getPhoneNumber() + " " + "Description :" + " " + getDescription() + " " + "Status :" + getIs24Hours());
    }
    public void oneTapCall(){
        System.out.println("The phone number is being calling :" + " " + getPhoneNumber());
    }
    public String toString(){
        return getName() + " " + getDescription();
    }
}
