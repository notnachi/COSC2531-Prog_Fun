import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
    s3827657 - Nachiket Rao
    Performed HD Level

    Object oriented design contains 3 classes
    1. School - This is an abstract class and serves to find out student and course count
                and stores the student marks in a 2D integer Array
    2. Course - Child class inheriting properties from School, generates course report
    3. Student - Child Class inheriting School, has functions to find out
                    max average and generates advanced student report as mentioned on the HD level


    Program Assumptions :
    1. First elment of scores.txt will contain the number that stores student and course count
    2. Three files will be given as input on command line. Else program will quit.
*/

public class MySchool {

    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("Please supply all files in CLI");
        } 
        else 
        {
            try 
            {
                Student s1 = new Student(args[0], args[1], args[2]);
                Course c1 = new Course(args[0],args[1]);
                s1.getMaxAverage();
                c1.generateCourseReport();
                s1.generateStudentReport();

             } 
            catch (IOException e) 
            {
                System.out.println(e.getMessage());
                System.out.println("Please enter correct file names");
            }
        }
        
    }
    
}