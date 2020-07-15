import java.util.*;
import java.io.*;

public class Student extends School {

    private Scanner studentScan;
    private String courseFileName;

    public Student(String sourceFileName,String courseFileName, String studentFileName) throws FileNotFoundException {
        //call constructor of parent class
        super(sourceFileName);
        //initialize scanner when constructor in invoked
        studentScan = new Scanner(new File(studentFileName));
        this.courseFileName = courseFileName;
    }

    /*
        Function prints out the studentID and avg marks
        of student with with maximum average. 
    */
    public void getMaxAverage() throws FileNotFoundException
    {
        //read source file to retrieve student ID
        Scanner classScan = new Scanner(new File(getSourceFileName()));
        //count keeps track of iteration in source file
        int count = 0;
        int sum;
        //keeps track of the enrolled subjects
        int enrollCount;
        int maxAvg =0;
        String topper ="0";
        //rowMarker keeps track of the student score array row index
        int rowMarker = 0;
        //loop as long as file contains lines of text
        while(classScan.hasNextLine())
        {
            //skip first line containing course codes
            if(count == 0)
            {
                //consume the first row
                classScan.nextLine();
                count+=1;
                continue;
            }

            sum = 0;
            enrollCount = 0;
            //get the student ID whose marks is to be checked
            String studentId = classScan.next();
            classScan.nextLine();
           for(int i=0; i< getCourseCount(); i++)
           {
               //check if student is enrolled in the course
                if(getStudentScores()[rowMarker][i] != -1)
                {
                    sum += getStudentScores()[rowMarker][i];
                    enrollCount += 1;
                }
              
           }

           //calculate average marks
           int avg = sum/enrollCount;

           //compare averages to get maximum average
           if(avg > maxAvg)
           {
               maxAvg = avg;
               topper = studentId;
           }
           
            rowMarker+=1;
            count+=1;
        }

        System.out.printf("The top student is %s with an average %d \n",topper,maxAvg);

    }

    /*
        Generates advanced student report by calculating total course
        credits and precise GPA using the total course credits.

        Requires the course file as input to get the course credits
    */
    public void generateStudentReport() throws IOException
    {
        //stores the final string to be written to file
        String edit = "";

        //initialize file writer which will store the student report
        FileWriter editStudentInfo = new FileWriter("student_report.txt");

        while(studentScan.hasNextLine())
        {
            String studentInfo = studentScan.nextLine();
 
            Scanner sourceScan = new Scanner(new File(getSourceFileName()));

            
            while(sourceScan.hasNextLine())
            {
                /*
                    check if the string in source file starts with   
                    the same studentID in the student file string
                */
                if(studentInfo.startsWith(sourceScan.next()))
                {
                    int totalScore = 0;
                    int totalCreditPoints = 0;
                    int creditPoint = 0;
                    int enrollCount = 0;
                    
                    for(int i=0; i< getCourseCount(); i++)
                    {
                        //initialize new scanner object to scan course file to get course credit
                        Scanner courseScan = new Scanner(new File(courseFileName));
                        int courseIterator = 0;
                        //this code snippet retrieves the credit point of the course
                        while(courseScan.hasNextLine())
                        {
                            
                            if(courseIterator == i)
                            {
                                //consume the first two strings 
                                courseScan.next();
                                courseScan.next();
                                //store the credit of the course and exit from loop
                                creditPoint = courseScan.nextInt();
                                break;
                            }
                            //skip to scan next course
                            else
                            {
                                courseScan.nextLine();
                                courseIterator++;
                            }
                        }
                        int score = 0;
                        //check if marks is a number
                         if(sourceScan.hasNextDouble())
                         {
                             //convert into integer
                            score = (int) Double.parseDouble(sourceScan.next());

                         }
                         //assume no enrollment and take marks as -1  
                         else
                         {
                            sourceScan.next();
                            score = -1;
                         }
                         
                         //run code snippet only for enrolled courses
                         if(score != -1)
                         {
                             totalCreditPoints +=creditPoint;
                             if(score >= 80)
                                 score = 4*creditPoint;
                             else if(score < 80 && score >= 70)
                                 score = 3*creditPoint;
                             else if(score < 70 && score >= 60)
                                 score = 2*creditPoint;
                             else if(score < 60 && score >= 50)
                                 score = 1*creditPoint;
                             else
                                 score = 0;
                            
                             enrollCount+=1;
                         }
                         else
                         {
                             score = 0;
                         }


                         totalScore += score;
                     
                    }
 
                     double gpa = totalScore/(double)totalCreditPoints;

                     //round the gpa to 2 decimal places for writing to file
                    String roundGPA = String.format("%.2f", gpa);
                     
                    //create the final string to be written to file
                     edit = edit.concat(studentInfo.trim() + " " + totalCreditPoints + " " + roundGPA + "\n");
                     
                }
            }
        }
        //write string to file
        editStudentInfo.write(edit);
        //close file writer
        editStudentInfo.close();
        System.out.println("student_report.txt generated!");
    }
}