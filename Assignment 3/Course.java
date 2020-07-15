import java.io.*;
import java.util.Scanner;

public class Course extends School {

    private Scanner courseScan;

    public Course(String sourceFilename, String courseFilename) throws FileNotFoundException {
        //call constructor of parent class School
        super(sourceFilename);
        //initialize scanner when constructor is invoked
        courseScan = new Scanner(new File(courseFilename));

    }

    /*
        Function generates course report based on the course details
        contained in the course file. Function uses the values extracted
        by the methods of School parent class
    */
    public void generateCourseReport() throws IOException
    {
        int[][] transpose = new int[getCourseCount()][getStudentCount()];

        /*
            transpose the student scores matrix to get 
            scores for each courses
        */
        for(int i= 0; i< getStudentCount(); i++)
        {
            for(int j=0; j< getCourseCount(); j++)
            {
                transpose[j][i] = getStudentScores()[i][j];
            }
        }

        //stores number of students in each course
        int [] numberOfStudents = new int[getCourseCount()];
        //stores the average score for each course
        int[] courseAvgScore = new int[getCourseCount()];

        //find number of students and average score for all courses
        for(int i=0; i< getCourseCount(); i++)
        {
            int totalScore = 0;
            int countOfStudents = 0;
            for(int j=0; j< getStudentCount(); j++)
            {
                //check if student is enrolled in the course
                if(transpose[i][j] != -1)
                {
                    //add scores of students
                    totalScore+=transpose[i][j];
                    countOfStudents+=1;
                }
                
            }

            //store the number of students for the course
            numberOfStudents[i] = countOfStudents;
            //calculate average score for the course
            courseAvgScore[i] = totalScore/countOfStudents;
            
        }

        String edit = "";

        int count = 0;
        while(courseScan.hasNextLine())
        {
                
            //generate string to be written into course_report file    
            edit = edit.concat(courseScan.nextLine().trim() + " " + numberOfStudents[count] + " " + courseAvgScore[count] + "\n");
                //System.out.println(edit);
                count+=1;
        }

        FileWriter editCourse = new FileWriter("course_report.txt");
        //write details into course files
        editCourse.write(edit);
        editCourse.close();
        System.out.println("course_report.txt generated!");

    }


    
}