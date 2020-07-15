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

/*
    Superclass for content class. Contains variables and methods to
    store comments for content objects entered by user 
*/
public class Comment {
    
    private ArrayList <Comment> review = new ArrayList<Comment>();
    
    private String userComment;
    private int rating;
    private User obj;
    
    //default constructor to avoid undefined implicit super constructor error
    public Comment(){};
    
    //call this constructor if only user and comment passed as arguments
    public Comment (User obj, String userComment)
    {
        this.obj = obj;
        this.userComment = userComment;
    }
    
    //call this constructor if only user and rating passed as arguments
    public Comment (User obj, int rating)
    {
        this.obj = obj;
        this.rating = rating;
    }
    
    //call this constructor if user enters comment AND THEN rating
    public Comment (User obj, String userComment, int rating)
    {
        this.obj = obj;
        this.userComment = userComment;
        this.rating = rating;
    }
    
    //call this constructor if user enters rating AND THEN comment
    public Comment (User obj, int rating, String userComment)
    {
        this.obj = obj;
        this.userComment = userComment;
        this.rating = rating;
    }
    
    //add comment to the arraylist
    public void addReview(Comment comObj)
    {
        review.add(comObj);
    }
    
    //Display all the reviews stored in the arrayList
    public void showReviews()
    { 
        for(Comment com : this.review)
        {
            System.out.printf("Userid: %s\nComment: %s\nRating: %d\n\n",com.obj.getName(),com.userComment,com.rating);
        }
    }
    
}
