import java.util.Scanner;

/**
 *
 * @author Notnachi
 */
public class ProgFunAssignment1 {

    public static void main(String[] args) {
        
        Scanner getIp = new Scanner(System.in);

        int rowSize,colSize;
        
        //loop until user enters row and column size within the given bounds
        do{

            //get area parameters of the block from user
            System.out.println("Enter row size of Block");
            rowSize = getIp.nextInt();

            System.out.println("Enter column size of Block");
            colSize = getIp.nextInt();

              //check constraints of the parameters according to the rules
            if((rowSize<=2 || rowSize>10) || (colSize<=2 || colSize>10))
            {
                System.out.println("Invalid entry. Try again");
            }

        }while((rowSize<=2 || rowSize>10) || (colSize<=2 || colSize>10));
         /*create the block by making an object of MyBlock class
        and passing the parameters to the constructor
        */
        MyBlock test = new MyBlock(rowSize,colSize);
            
        //this will store menu option
        int userChoice; 
            
        do{               
            //display menu options
            System.out.println("Please enter the operation number");
            System.out.println("1.Add a house\n2.Display the Block\n3.Clear the block\n4.Quit");
        
            userChoice = getIp.nextInt(); 
            
            switch(userChoice)
            {
                case 1: 
                    //call the add house method
                    System.out.println("Enter the starting row of the house");
                    int startRowCod = getIp.nextInt();

                    System.out.println("Enter the starting column of the house");
                    int startColCod = getIp.nextInt();

                    
                    System.out.println("Enter number of rows to be occupied");
                    int rowVal = getIp.nextInt();

                    System.out.println("Enter number of columns to be occupied");
                    int colVal = getIp.nextInt();
                        
                    if(!test.addHouse(startRowCod, startColCod, rowVal, colVal))
                        System.out.println("House not added due to violation of constaints as shown above");
                        
                    break;
                        
                case 2: 
                    //call the display block method
                    test.displayBlock();
                    break;

                case 3: 
                    //call the clear block method
                    test.clearBlock();

                    System.out.println("Block has been cleared");
                    test.displayBlock();
                    break;

                case 4:
                    System.out.println("Thank you for playing");
                    break;

                default:
                    System.out.println("Invalid Entry");
                    break;
                }
                
            if(userChoice == 4)
                break;

        }while(userChoice!=4);
        
        
    }
    
}

final class MyBlock{
    private int[][] block;

    //value set to true if block has no houses
    private boolean vacant;

    //keep track of the number of houses added
    private int houseNum; 
    /* 
        Task A - constructor will accept the block size parameters
                entered by user and initialize an empty block
    */
    public MyBlock(int maxRows, int maxColumns){
            block = new int[maxRows][maxColumns];
            this.clearBlock();
            System.out.println("Block created successfully");
            this.displayBlock();
    }
    /*
        Task B - Display block method
    */
    public void displayBlock()
    {
        for(int row=0;row<block.length;row++){
                for(int col=0;col<block[row].length;col++){
                    //display the block
                    System.out.print(block[row][col] + " "); 
            }
                //add line break
                System.out.println();
            }
    }
    /*
        Task C - Clear block method
    */
    public void clearBlock()
    {
        for(int row=0;row<block.length;row++){
                for(int col=0;col<block[row].length;col++){
                    block[row][col] = 0; 
            }
            }
        vacant = true;
        houseNum = 1;
    }
    
    //addHouse method returns false if any error; true if successful
    public boolean addHouse(int rowPos, int colPos, int rowSize, int colSize)
    {
        //check if the starting position lies on the edge sides of the block
        if((rowPos == 0 || rowPos == block.length-1) || (colPos == 0 || colPos == block[0].length-1))
        {
            System.out.println("Invalid location. House is touching the edge");
            return false;
        }
        
        //check if length and breadth are less than 1
        else if(rowSize < 1 || colSize < 1)
        {
            System.out.println("Area parameter is less than 1");
            return false;
        }
        
        //check if the area of the block goes outside the block or the fence
        else if (rowSize > block.length-rowPos-1 || colSize > block[0].length-colPos-1)
        {
            System.out.println("Area of the block is exceeding the bounds");
            return false;
        }
        else
        {
            /*
                creating temporary variables to store the orignal
                value of the initial row and column position since
                the values will change while iterating over the loop
            */
            int rowTemp = rowPos;
            int colTemp = colPos;
            //flag variable to exit out of loops in case house is occupied
            boolean occupied = false; 
            
            //check if there is already a house allocated on the index
            for(int row=0;row<rowSize;row++){
                for(int col=0;col<colSize;col++){
                    /*
                        if the index contains a number other than 0
                        house already present. Exit the loop.
                    */
                    if(block[rowPos][colPos] != 0)
                    {
                        System.out.println("House already present");
                        occupied = true;
                        break;
                    }
                    
                    /*logic for Task F - Rule 2
                       - check if the house is surrounded by zeroes
                       - this is done by checking the elements on the
                        top, bottom, left and right from the borders of
                        the house
                    */
                    
                    //for the first row, check if the elements above are 0
                    
                    if(row==0)
                    {
                        if(col == 0 && block[rowPos-1][colPos-1]!=0)
                        {
                            System.out.println("House area is not seperated by a row fence");
                            occupied = true;
                            break;
                        }

                        else if(col == colSize-1 && block[rowPos-1][colPos+1]!=0)
                        {
                            System.out.println("House area is not seperated by a row fence");
                            occupied = true;
                            break;
                        }

                        if(block[rowPos-1][colPos]!=0)
                        {
                            System.out.println("House area is not seperated by a row fence");
                            occupied = true;
                            break;
                        }
                    }
                    
                    //for the last row, check if the elements below are 0
                    if(row==rowSize-1)
                    {
                        if(col == 0 && block[rowPos+1][colPos-1]!=0)
                        { 
                            System.out.println("House area is not seperated by a row fence");
                            occupied = true;
                            break;
                        }
                        
                        if(col == colSize-1 && block[rowPos+1][colPos+1]!=0)
                        { 
                            System.out.println("House area is not seperated by a row fence");
                            occupied = true;
                            break;
                        }
                        
                        if(block[rowPos+1][colPos]!=0)
                        {
                            System.out.println("House area is not seperated by a row fence");
                            occupied = true;
                            break;
                        }
                    }
                    
                    //for the last column check if the elements on the right are 0
                    if(col==colSize-1)
                    {
                        if(block[rowPos][colPos+1]!=0)
                        {
                            System.out.println("House area is not seperated by a column fence");
                            occupied = true;
                            break;
                        }
                    }

                    colPos++;
                }

                //break out of the loop if the occipued variable is true
                if(occupied)
                {
                    break;
                }

                colPos=colTemp;
                
                //for first column check if the elements on the left are 0
                if(row==0)
                {
                    if(block[rowPos][colPos-1]!=0)
                    {
                        System.out.println("House is not seperated by a row fence");
                    }
                }
               rowPos++;
            }
            
            if(!occupied)
            {
                /*
                    restoring the orignal starting position using the temp variables
                    created earlier
                */
                rowPos=rowTemp;
                colPos=colTemp;

                for(int row=0;row<rowSize;row++){
                    for(int col=0;col<colSize;col++){                   
                        block[rowPos][colPos]=houseNum;
                        colPos++;
                    }
                colPos=colTemp;
                rowPos++;
            }

                this.displayBlock();

                //increment only if the house is successfully occupied
                houseNum+=1; 

                //block is no longer vacant
                vacant = false; 
                return true;
            }
            
            else
            {
                return false;
            }
        }
    }
}
