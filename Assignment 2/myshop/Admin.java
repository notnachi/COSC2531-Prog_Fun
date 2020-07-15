//package myshop;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author Notnachi
 */

/*
    Admin is a subclass of User
    Objects of variable
*/

public class Admin extends User {
    
    private String password;
    private int level;
    
    public Admin(String id, String username, String password, int level)
    {
        
        //call constructor from parent class to set id and username
        super(id,username);
        this.password = password;
        this.level = level;
    }
    
    //allow an admin to login for admin specifc function such as bulk price reduction
    public boolean login()
    {
        System.out.println("Please enter your password");
        Scanner scan = new Scanner(System.in);
        String passIp = scan.next();
        
        //return value of string comparison
        return passIp.equals(password); 
    }
    
    //return the level of admin
    public int getLevel()
    {
        return level;
    }
    
     //override showDetails method to display details specific to a book object
   //Object of book type will use the method definition written here
    @Override
    public void showDetails()
    {
        System.out.printf("User Type: Admin\nAdmin id: %s\nAdmin username: %s\nAdmin Level: %d\n"
                + "\n",this.getId(),this.getName(),this.level);
    }
   
    
}
