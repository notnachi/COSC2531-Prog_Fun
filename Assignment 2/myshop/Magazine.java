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
    Magazine is a subclass of Publication 
*/

public class Magazine extends Publication  {
    
    private int volume;
    
    public Magazine(String mag_id, String mag_name, double mag_price, String publisher, int pageCount, int mag_volume)
   {
       //call constructor from publication toset id, name , price, publisher and pagecount
       super(mag_id,mag_name, mag_price,publisher,pageCount);
       
       volume = mag_volume;
       
   }
    
     //override showDetails method to display details specific to a magazine object
   //Object of magazine type will use the method definition written here
    @Override
    public void showDetails()
    {
        System.out.printf("Mag ID: %s \nMag Name: %s\n"
                + "Mag Price: %f\nMag Publisher: %s\nNumber of pages: %d\nVolumne No: %d\n\n"
                ,this.getId(),this.getName(),this.getPrice(),this.getPublisher(),this.getPageCount(),this.volume);        
    }
    

}
