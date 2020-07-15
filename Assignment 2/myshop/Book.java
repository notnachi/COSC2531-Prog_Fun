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
    Book is a subclass of Publication. 
*/

public class Book extends Publication {
    
    private String [] author;
    
   public Book(String book_id, String book_name, double book_price, String publisher, int pageCount, String [] book_author)
   {
       //call constructor from publication class to set id, name, price, publisher and pageCount
       super(book_id,book_name,book_price,publisher,pageCount);
       author = book_author;       
   }
   
   //override showDetails method to display details specific to a book object
   //Object of book type will use the method definition written here
   @Override
    public void showDetails()
    {
        System.out.printf("Book ID: %s \nBook Name: %s\n"
                + "Book Price: %f\nBook Publisher: %s\nNumber of pages: %d\nList of Authors: \n"
                ,this.getId(),this.getName(),this.getPrice(),this.getPublisher(),this.getPageCount());
        
        //iterate through elements in author array
        for(String author_names : author)
        {
            System.out.println(author_names);
        }
        System.out.println("\n\n");
    }
    
   
}
