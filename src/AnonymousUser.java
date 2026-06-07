package com.mycompany.mentalproject;

public class AnonymousUser extends User{
    private boolean active;
    public AnonymousUser(boolean active,String username,String password,String name,String id){
        super(username, password, name, id);
        this.active=active;
    }
    public boolean getActive(){
        return active;
    }
    @Override
    public boolean authenticate(String password){
        return true;
    }
    @Override
    public String getRole(){
        return "Anonymous User";
    }
    public String toString(){
        return super.toString() + " " + "Status :" + " " + "Anonymous User";
    }
}
