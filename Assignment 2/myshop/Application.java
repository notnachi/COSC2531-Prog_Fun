//package myshop;
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
    Application is a subclass of Content
    
    Methods specific to application objects
    are overriden here

    Specific variables and methods for any application present here
*/
public class Application extends Content  {
    
    private String app_OS;
    
    
    //call this constructor if price of app is specified
    public Application(String app_id, String app_name, double app_price, String app_OS)
    {
        //call constructor from content class to set id and name and price
        super(app_id,app_name, app_price);
        this.app_OS = app_OS;
    }
    
    //call this constructor if app is free
    public Application(String app_id, String app_name, String app_OS)
    {
        //call constructor from content class to set id and name
        super(app_id,app_name);
        this.app_OS = app_OS;
    }
    
    //override showDetails method to display application specifc data
    //objects of type Application will use the this showDetails method
    @Override
    public void showDetails()
    {
        System.out.printf("App ID: %s \nApp Name: %s\nApp Price: %f\n App OS: %s\n\n"
                ,this.getId(),this.getName(),this.getPrice(),this.app_OS);
    }
    
  
    
}
