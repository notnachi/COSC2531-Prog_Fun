import java.util.*;
import java.io.*;

public abstract class School {

    private Scanner scanReport;
    private String sourceFilename;
    private int courseCount;
    private int studentCount;
    private int[][] studentScores;

    /*
        Constructor accepts string as argument which contains the source
        file name.

        Upon initialization, School constructor extracts the following
        details -
            1. Number of courses
            2. Number of students
            3. Student marks (stored in a private 2D array)
    */
    public School(String sourceFilename) throws FileNotFoundException
    {
        this.sourceFilename = sourceFilename;
        scanReport = new Scanner(new File(this.sourceFilename));
        //call to function for extracting student and course count
        extractDetails();
        //call to function for extrcting and storing student marks in 2D array
        extractStudentMarks();
    }

    /*
        This function reads the first number in the source file
        and finds out the total count of students and courses.
    */
    public void extractDetails()
    {
        //read the first element in the source file which is an integer
        int arrayParam = scanReport.nextInt();

        //pop the last digit which contains the number of courses
        courseCount = arrayParam%10;

        //subtract the last digit and divide by 10 to get number of students
        studentCount = (arrayParam - courseCount)/10;

        //initialize size of array once we get number of students and courses
        studentScores = new int[studentCount][courseCount];

    }

    /*
        Extracts the marks for each student in the enrolled courses
        and stores the result in a 2D array
    */
    public void extractStudentMarks()
    {
        int count = 0;
        //keeps track of which line of file is scanned
        int rowMarker = 0;
        while(scanReport.hasNextLine())
        {
            //skip first row containig course ID
            if(count == 0)
            {
                scanReport.nextLine();
                count+=1;
                continue;
            }
            
            //skip the student ID
            scanReport.next();
            //run loop to extract marks for all courses
            for(int i=0; i< courseCount; i++)
            {
                //if text contains numbers
                if(scanReport.hasNextDouble())
                {
                    studentScores[rowMarker][i] = (int) Double.parseDouble(scanReport.next());
                }
                
                //assume not enrolled if not a number
                else
                {
                    scanReport.next();
                    studentScores[rowMarker][i]= -1;
                }
                      
                   
            }

            rowMarker+=1;
            count+=1;
        }


    }

    //return 2D array which contains the marks
    public int[][] getStudentScores()
    {
        return studentScores;
    }

    //return number of courses
    public int getCourseCount()
    {
        return courseCount;
    }

    //return number of students
    public int getStudentCount()
    {
        return studentCount;
    }

    //return name of source file
    public String getSourceFileName()
    {
        return sourceFilename;
    }
    
}