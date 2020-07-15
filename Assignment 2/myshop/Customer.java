//package myshop;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Notnachi
 */

/*
    Customer is a subclass of User
    
*/

public class Customer extends User {
    
    //private String phone_no;
    //private double accBalance;
    
    private String phone_no;
    //defualt accBalance set to 50
    private double accBalance = 50;
    //by default any new user will not be premium. Value overriden if user becomes premium
    private boolean isPremium = false;
    
    private ArrayList <Content> myDownloads = new ArrayList<Content>();
    
    //use this constructor if accBalance is entered by user
    public Customer(String id, String username, String phone_no, double accBalance)
    {   
        super(id,username);
        this.phone_no = phone_no;
        this.accBalance = accBalance;
        //this.isPremium = false;
    }
    
    //use this construtor if accBalance not specifed. Default balance set is User Class
    public Customer(String id, String username, String phone_no)
    {
        super(id,username);
        this.phone_no = phone_no;
        //this.isPremium = false;
    }
    
    //method to change customer to premium customer
    public void becomePremium()
    {
        //check if customer has sufficient balance
        if(this.accBalance > 100)
        {
            //deduct amount from account balance
            this.accBalance -= 100;
            //set preimum variable to true (this will be used while purchasing content)
            this.isPremium = true;
            System.out.println(super.getName() + " has been upgraded to premium customer");
        }
        //insufficient balance
        else
        {
            System.out.println("Hi " + super.getName() + " your account balance = " + this.accBalance);
            System.out.println("Cannot upgrade to premium due to insufficient balance");
        } 
    }
    
     //override showDetails method to display details specific to a Customer object
    //Object of customer type will use the method definition written here
    @Override
    public void showDetails()
    {
        System.out.printf("User Type: Customer\nCustomer id: %s\nCustomer username: %s\nphone no: %s\n"
                + "balance: %f\n\n",this.getId(),this.getName(),this.phone_no,this.accBalance);
    }
    
    
    //this method will show all downloaded content of a particular user
    @Override
    public void showDownloads()
    {
        
        if(myDownloads.size() == 0)
        {
            System.out.println("No items purchased by " + super.getName());
        }
        else
        {
            
            System.out.println("******Content downloaded by " + super.getName() + "******");
            
            //display name and price for all objects in myDownloads arraylist
            myDownloads.forEach((obj) -> {
                System.out.printf("%s\t%f\n",obj.getName(),obj.getPrice());
            });
        }
        
    }
    
    
    //Use this download function for single content downloads
    public boolean download(Content obj)
    {
        double contentPrice = obj.getPrice();
        
        //check if user is premium
        if(isPremium)
        {
            System.out.println("You are a premium customer\nMarket Price = " + contentPrice);
            //update content price. 20% discount
            contentPrice *= 0.8;
            System.out.println("Premium User price = " + contentPrice);
        }
        
        //if user has enough balance buy item
        if(this.accBalance >= contentPrice)
        {
            //deduct purchase amount from account balance
            this.accBalance -= contentPrice;
            //increment the download count of the purchased content
            int downloadCount = obj.getDownloadCount();
            downloadCount += 1;
            obj.setDownloadCount(downloadCount);
            //store the purchase information to myDownloads list
            myDownloads.add(obj);
            return true;
        }
        //download failed, insufficient balance
        else
        {
           return false; 
        }
            
    }
    
    //use this download function for bulk downloads
    public boolean download(Content[] list)
    {
        double totalAmount = 0;
        
        //get the total price of all content to be downloaded
        for(Content obj : list)
        {
            totalAmount += obj.getPrice();
        }
        
        //check if user is premium
        if(isPremium)
        {
            System.out.println("You are a premium customer.\nTotal purchase amount = " + totalAmount);
            //20% discount on the total price
            totalAmount *= 0.8;
            System.out.println("Premium discounted price = " + totalAmount);

        }
        
        //check if user has enough balance for the purchase
        if(this.accBalance >= totalAmount)
        {
            //deduct the total purchase amount from account balance
            this.accBalance -= totalAmount;
            for(Content obj : list)
            {
                //increment download count of all purchased content by 1
                int downloadCount = obj.getDownloadCount();
                downloadCount += 1;
                obj.setDownloadCount(downloadCount);
                //store the purchase information for the user
                myDownloads.add(obj);
            }
            //content purchased successfully
            return true;
        }
        else
        {
           //purchase failed, insufficient balance
            return false; 
        }
        
    }
    
    
    
}
