//package myshop;
// My name:

import java.util.Scanner;

// My student ID:
// The highest level I've completed is: PASS/CR/DI/HD (select ONLY one)

//Add the packages that you need

public class MyShopMain {
    public static void main(String[] args) {
        
        MyShop shop = new MyShop();
        
        Scanner scanObj = new Scanner(System.in);
        
        int carryOn = 1;

        // ************************ Menu ***************************         
        //  Write a menu driven part to allow keyboard input
        //  Input validation is a must
        //  You may define method(s) for menu handling
        // ********************************************************** 
        
        
        do
        {
            System.out.println("Pass Level Functionality -\n1. Run Default Test Cases\n2. Add Custom Content\n3. Show Content");
            try
            {
                 int choice = scanObj.nextInt();

                    switch(choice)
                {
                    case 1: //run default test cases
                        carryOn =0;
                        break;
                    case 2: //add user content
                        int goBack;   

                        do
                        {

                            System.out.println("Choose type of content - \n1. Application\n2.Book\n3.Magazine");
                            int contentType = scanObj.nextInt();
                            scanObj.nextLine();
                            if(contentType == 1)
                            {
                                System.out.println("Enter App ID");
                                String appID = scanObj.nextLine();
                                System.out.println("Please enter appname");
                                String appName = scanObj.nextLine();
                                System.out.println("Please enter app price");
                                double appPrice = scanObj.nextDouble();
                                scanObj.nextLine();
                                System.out.println("Please enter app OS");
                                String appOS = scanObj.nextLine();
                                shop.addContent(new Application(appID,appName,appPrice,appOS));
                            }
                            else if(contentType == 2)
                            {
                                System.out.println("Enter list of authors separated by comma");
                                String authors = scanObj.nextLine();
                                String authorArray [] = authors.split(",");

                                System.out.println("Enter book ID");
                                String bookID = scanObj.nextLine();

                                System.out.println("Enter book name");
                                String bookName = scanObj.nextLine();

                                System.out.println("Enter book Price");
                                double bookPrice = scanObj.nextDouble();
                                scanObj.nextLine();

                                System.out.println("Enter book publisher");
                                String bookPublisher = scanObj.nextLine();

                                System.out.println("Enter book page count");
                                int bookPageCount = scanObj.nextInt();

                                shop.addContent(new Book(bookID,bookName,bookPrice,bookPublisher,bookPageCount,authorArray));
                            }
                            else if(contentType == 3)
                            {
                                System.out.println("Enter magazine ID");
                                String magID = scanObj.nextLine();

                                System.out.println("Enter magazine name");
                                String magName = scanObj.nextLine();

                                System.out.println("Enter magazine price");
                                double magPrice = scanObj.nextDouble();
                                scanObj.nextLine();

                                System.out.println("Enter magazine publisher");
                                String magPublisher = scanObj.nextLine();

                                System.out.println("Enter magazine page count");
                                int magPageCount = scanObj.nextInt();

                                System.out.println("Enter magazine volume");
                                int magVol = scanObj.nextInt();
                                //Application app = new Application(appID,appName,appPrice,appOS);

                                shop.addContent(new Magazine(magID,magName,magPrice,magPublisher,magPageCount,magVol));
                            }
                            else
                            {
                                System.out.println("Invalid Choice");
                            }

                          System.out.println("Do you wish to Continue adding - press 1");
                          goBack = scanObj.nextInt();

                        }while(goBack == 1);

                        break;
                    case 3: //show content
                        shop.showContent();
                        break;
                }
                    
                if(choice != 1)
                {
                    System.out.println("Do you wish to continue or run default test cases? Press 1 to continue");
                    carryOn = scanObj.nextInt();
                }
                

            }
            catch(Exception e)
            {
                System.out.println("Wrong input. Try again");
                scanObj.nextLine();
            }
        }while(carryOn == 1);
        
        // ***************   PASS LEVEL  ***************
        // *********************************************
        ///*
            
        // create new publications
        String[] authors1 = {"L. Tolstoy"};
        Book b1 = new Book ("b1", "War and Peace", 12.55, "The Russian Messenger", 1225, authors1);
                
        String[] authors2 = {"F. Scott Fitzgerald"};
        Book b2 = new Book ("b2", "The great gatsby", 10, "Charles Scribner's Sons", 180, authors2);
                
        String[] authors3 = {"Thomas H. Cormen", "Charles E. Leiserson", "Ronald L. Rivest", "Clifford Stein"};
        Book b3 = new Book ("b3", "Introduction to algorithms", 100, "MIT Press", 1312, authors3);
                
        Magazine m1 = new Magazine("m1", "Forbes", 8.99, "Forbes Media", 50, 201904);
                
        // add new publications to the shop      
        shop.addContent(b1);
        shop.addContent(b2);
        shop.addContent(b3);
        shop.addContent(m1);
                
        // create new applications        
        Application g1 = new Application("g1", "Pokemon", 5.3, "androidV4");    
        Application g2 = new Application("g2", "Pokemon", 5, "iOSV10");
        //a free app
        Application app1 = new Application("app1", "Calendar", "androidV3"); 

        // add new applications to the shop         
        shop.addContent(g1);
        shop.addContent(g2);
        shop.addContent(app1);
        
        shop.showContent();

//        //*/
//        // ***************  CREDIT LEVEL ***************
//        // ******** disable me if not completed ********
//        ///*
//                
         //Adding new customers
         
        Customer c1 = new Customer("c1", "coolguy", "0412000", 200);
        Customer c2 = new Customer("c2", "neversaynever", "0433191");  
        Customer c3 = new Customer("c3", "Hello 123", "0413456", 1000);
        Customer c4 = new Customer("c4", "Jackie Chan", "0417654");
                
        shop.addUser(c1);
        shop.addUser(c2);
        shop.addUser(c3);
        shop.addUser(c4);
        
        // Adding new admins
        Admin a1 = new Admin("a1", "SuperBlack", "opensesame", 10);
        Admin a2 = new Admin("a2", "Adele", "kitty123", 3);  
                
        shop.addUser(a1);
        shop.addUser(a2);
            
        //shop.showUser();
        
        c2.changeName("neversaybye");  // change the user name
        a1.changeName("superblack");   // make the user name in lowercase
        
        //shop.showUser();
//        
//        //*/
//        // ************* DISTINCTION LEVEL *************
//        // ******** disable me if not completed ********
//        ///*
        
        
        Comment comment1 = new Comment(c1, "This is a fantastic game!");
        g1.addReview(comment1);
                
        Comment comment2 = new Comment(c2, 5);
        g1.addReview(comment2);
        
        Comment comment3 = new Comment(c3, 3, "This is an average game!"); 
        g1.addReview(comment3);
        
        Comment comment4 = new Comment(c4, "I quite like this game!", 4); 
        g1.addReview(comment4);
                
        g1.addReview(new Comment(c3, "The game crashes frequently"));
 
        b1.addReview(new Comment(c2, "I love Tolstoy!"));
        
        System.out.println("************COMMENTS FOR APP G1****************");
        g1.showReviews();  //show comments for g1
        System.out.println("************COMMENTS FOR BOOK B1****************");
        b1.showReviews();  //show comments for b1
        
        System.out.println("************SHOWING ALL COMMENTS****************");
        shop.showAllReviews();   //show all comments ever made

                                
//         Simulating transactions, showing content etc etc.  
//         They can be driven by menu input as well.
        if (c1.download(b1)) 
            System.out.println(c1.getName() + " bought " + b1.getName());
        else 
            System.out.println("Not enough fund"); 
           
        c1.download(b3);
        c1.download(m1);
        
        c1.showDownloads();  // show c1's downloads
        
        c2.download(m1);
        c3.download(m1);
        
        m1.showDownloads();    //show number of downloads of m1
        
        shop.showDownloads();  //show all comments ever made

        

////        //*/
////        // **************   HD  LEVEL   **************
////        // ******** disable me if not completed ********
////        ///*
        

        c3.becomePremium();
        c3.download(b1);
        c3.download(g1);
        shop.showDownloads(); 
        
        c4.download(g1);
        c4.becomePremium();
        c4.download(m1);
        shop.showDownloads(); 
        

        Customer c5 = new Customer("c5", "neverenough", "0486734", 2000);
        Content[] list = {b1, b2, b3, m1, g1, g2, app1};
        
        // download many items in one go
        c5.download(list); 
        shop.showDownloads();
        
        // an admin can reset the price for an item
        b1.setPrice(a2.login(), 14.25);  
        
        // an admin with level > 5 bulk reduces all prices by 10% 
        shop.setPrice(a1.login(), a1.getLevel(), -0.10);
//    
//        //*/   
//                    
//        // other necessary code to test the required functionalities. 

                
   
        }
}