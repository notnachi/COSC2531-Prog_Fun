//package myshop;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static java.lang.Math.abs;

/**
 *
 * @author Notnachi
 */

/*
    This clas provides the basic blueprint for any type of content
    
    Content class is a subclass of comments and inherits all variables
    and menthods defined in content
    
    All common variables and methods for any content present here
*/

public abstract class Content extends Comment {
    
    private String id;
    private String name;
    private int downloadCount = 0;
    private double price;
    
    //constructor of content created to set default content variables - id and content name
    public Content(String content_id, String content_name)
    {
        this.id = content_id;
        this.name = content_name;
        this.price = 0;
    }

    public Content(String content_id, String content_name, double content_price)
    {
        this.id = content_id;
        this.name = content_name;
        this.price = content_price;
    }
    
    
    //return content it
    public String getId()
    {
        return this.id;
    }
    
    //return content name
    public String getName()
    {
        return this.name;
    }
    
    //return content price
    public double getPrice()
    {
        return this.price;
    }
    
    //return number of times content has been downloaded
    public int getDownloadCount()
    {
        return this.downloadCount;
    }
    
    
    //set download count of content
    public void setDownloadCount(int downloadCount)
    {
        this.downloadCount = downloadCount;
    }
    
    //abstract method declaration for displaying details of any content object
    //implemented in the subclasses of content
    public abstract void showDetails();
    
    //this function is used to update the price of a content if accessed by an admin
    public void setPrice(boolean isAdmin, double newPrice)
    {
        //check if user is admin. If yes go ahead
        if(isAdmin)
        {
            System.out.print("Price updated from " + this.price + " to ");
            this.price = newPrice;
            System.out.println(this.price);
        }
        //unauthorized user
        else
        {
            System.out.println("Unauthorized to perform this operation");
        }
    }


    
    /*
        Calls showReview method from comment class to display 
        reviews for the content object
        Common for all content type objects.
    */
    public void showAllContentReviews()
    {
        System.out.println("\t***COMMENTS FOR "+ this.name +"***");
        this.showReviews();
    }
    
    /*
        Displays the number of times the content object has been downloaded
        Common for all content type objects.
    */
    public void showDownloads()
    {
        System.out.printf("Download count for %s = %d\n",this.name,this.downloadCount);
    }
    
//    /*
//        Reduces price of all content objects by the reduction percentage entered by user
//        Common for all content type objects.
//    */
//   // @Override
//    public void bulkReduction(double reduction)
//    {
//        this.price *= (1 - abs(reduction));
//    }
    
            
}
