//package myshop;

//Add the packages that you need, e.g.

import static java.lang.Math.abs;
import java.util.ArrayList;

//import java.util.Hashtable;
//import java.util.ArrayList;

public class MyShop {
	
	// Instance variables that you need.
	// They must all be marked as private
	
	// Declare a private variable (array or similar) to store your Content objects here
    
        /*
            Stores objects of content type
        */
        private ArrayList <Content> content_list = new ArrayList<Content>();
	
	// Declare a private variable (array or similar) to store your User objects here
        
        /*
            Stores objects of user type
        */
        private ArrayList <User> user_list = new ArrayList <User>();
	
	
	public MyShop() {
		// any code you need here
	}
	
    //stores new content by adding them to the arraylist
    public void addContent(Content obj) {
            
            //store list of all contents in an arraylist
            content_list.add(obj);
		
	}

    //displays info on all content
    public void showContent() {
		// add your code here
                
                for(Content obj : content_list)
                {
                    //based on content type use the overriden showDetails method of respective class
                    obj.showDetails();
                }
	}
		
    //stores new users by adding them to arraylist
    public void addUser(User obj) {
		
           //store list of users in arraylist
            user_list.add(obj);
            
	}	
	
    //dislays info on all users
    public void showUser() {
		// add your code here
                
                for(User obj : user_list)
                {
                    //display the details of user object
                    obj.showDetails();
                }
	}
        //displays details of all reviews for all the content
        public void showAllReviews()
        {
            for(Content obj : content_list)
            {
                //dislplay all the reviews for all the contents
                obj.showAllContentReviews();
            }
        }
        
        //displays details of all purchases made by all users
        public void showDownloads()
        {
            for(User obj : user_list)
            {
                //show all pruchases made by all users
                obj.showDownloads();
                System.out.println();
            }
        }
	
	// possible methods here
        
        //change price of a content if the user is an admin and has level above 5
        public void setPrice(boolean isAdmin, int level, double reduction)
        {
            //check if user is an admin and has level more than 5
            if(isAdmin && level > 5)
            {
                //reduce price of all content objects
                for(Content obj : content_list)
                {
                    //set newprice equal to the discounted amount
                    double newPrice = obj.getPrice() * (1 - abs(reduction));
                    //call setPrice method to update content price with the discounted amount
                    obj.setPrice(isAdmin, newPrice);
                }
                System.out.println("All prices updated");
            }
            //if user is not admin, bulkreduction is not allowed
            else
            {
                System.out.println("Not authorized to perform this operarion");
            }
        }
	
}