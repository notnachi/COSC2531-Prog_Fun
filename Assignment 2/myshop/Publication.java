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
    Subclass of content and contains variables 
    common to objects of publication subtype.
*/

public abstract class Publication extends Content {
    
    private String publisher;
    private int pageCount; 

    public Publication(String content_id, String content_name, double content_price, String publisher, int pageCount) {
        //call constructor forn content to set id and name and price (assuming books and magazines are never free)
        super(content_id, content_name, content_price);
        this.pageCount = pageCount;
        this.publisher = publisher;
    }
    
    //return publisher of content
    public String getPublisher()
    {
        return this.publisher;
    }

    //return number of pages in content
    public int getPageCount()
    {
        return this.pageCount;
    }
}
