//package myshop;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author Notnachi
 */

public abstract class User  {
    
    private String id;
    private String username;
    //set default account balance for any user
    //value overriden if custom balance is entered
    //private double accBalance = 50;
    
    
    
    
    //default empty constructor to prevent undefined implicit super constructor error
    public User(String id, String username)
    {
        this.id = id;
        this.username = username;
    }
    
    //change username of any user
    public void changeName(String newName)
    {
        username = newName;
    }
    
    //returns the name of the user
    public String getName()
    {
        return this.username;
    }
    
    //return user id
    public String getId()
    {
        return this.id;
    }

    //display details of generic user object
    public abstract void showDetails();
//    {
//        System.out.printf("User Type: Default\nuserid: %s\nusername: %s\n"
//                + "phone no: %s\nbalance: %f\n\n",this.id,this.username,this.phone_no,this.accBalance);
//    }
    
    //method overridden in Customer class to display content downloaded by the user
    public void showDownloads(){};
    
    
    
}
