package com.mycompany.mentalproject;

public abstract class Person {
    protected String name;
    protected String id;
    public Person(String name,String id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public String toString(){
        return "Name :" + " " + getName() + " " + "ID :" + " " + getId() ;
    }
    public abstract String getRole();
}
