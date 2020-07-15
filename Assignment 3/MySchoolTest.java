import java.util.*;

import jdk.jfr.events.FileWriteEvent;

import java.io.*;

public class MySchoolTest
{
    public static void main(String[] args) throws IOException {
        
        /***********PASS LEVEL************* */
        Scanner scan = new Scanner(new File(args[0]));

        int arrayParam = scan.nextInt();

        System.out.println(arrayParam);

        int courseCount = arrayParam %10;
        int studentCount = (arrayParam - courseCount)/10;

        System.out.println("Number of Courses = " + courseCount + " Number of students = " + studentCount);

        int count = 0;
        int sum;
        int enrollCount;
        int maxAvg = 0;
        String topper = "0";
        int rowMarker = 0;
        int[][] studentScores = new int[studentCount][courseCount];
        while(scan.hasNextLine())
        {
            if(count == 0)
            {
                scan.nextLine();
                count+=1;
                continue;
            }

           //System.out.println(scan.nextLine());

            sum = 0;
            enrollCount = 0;
            String studentId = scan.next();

           for(int i=0; i< courseCount; i++)
           {
                studentScores[rowMarker][i] = (int) Double.parseDouble(scan.next()) ;

                if(studentScores[rowMarker][i] != -1)
                {
                    sum += studentScores[rowMarker][i];
                    enrollCount += 1;
                }
              
           }

           int avg = sum/enrollCount;

           if(avg > maxAvg)
           {
               maxAvg = avg;
               topper = studentId;
           }
           
            rowMarker+=1;
            count+=1;
        }

        System.out.printf(" The top student is %s with an average %d \n",topper,maxAvg);

        /***********Credit Level*************** */

        int [][] transpose = new int[courseCount][studentCount];

        for(int i= 0; i< studentCount; i++)
        {
            for(int j=0; j< courseCount; j++)
            {
                transpose[j][i] = studentScores[i][j];
            }
        }

        // for(int i=0; i< studentCount; i++)
        // {
        //     for(int j=0; j< courseCount; j++)
        //     {
        //         System.out.print(studentScores[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // for(int i=0; i< courseCount; i++)
        // {
        //     for(int j=0; j< studentCount; j++)
        //     {
        //         System.out.print(transpose[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int [] numberOfStudents = new int[courseCount];
        int[] courseAvgScore = new int[courseCount];
        for(int i=0; i< courseCount; i++)
        {
            int totalScore = 0;
            int countOfStudents = 0;
            for(int j=0; j< studentCount; j++)
            {
                if(transpose[i][j] != -1)
                {
                    totalScore+=transpose[i][j];
                    countOfStudents+=1;
                }
                
            }

            numberOfStudents[i] = countOfStudents;
            courseAvgScore[i] = totalScore/countOfStudents;
            
        }

        //System.out.println(args[1]);
        

       Scanner courseFile = new Scanner(new File(args[1]));

       String edit = "";

       count = 0;
       while(courseFile.hasNextLine())
       {
            
            edit = edit.concat(courseFile.nextLine() + " " + numberOfStudents[count] + " " + courseAvgScore[count] + "\n");
            //System.out.println(edit);
            count+=1;
       }

       FileWriter editCourse = new FileWriter("course_report.txt");
       editCourse.write(edit);
       editCourse.close();



       /***********DI Level*************** */

       
       Scanner student = new Scanner(new File(args[2]));
       edit = "";

       while(student.hasNextLine())
       {
           String studentInfo = student.nextLine();

           

           Scanner obj = new Scanner(new File(args[0]));

           while(obj.hasNextLine())
           {
               if(studentInfo.startsWith(obj.next()))
               {
                    int totalScore = 0;
                    enrollCount = 0;
                    for(int i=0; i< courseCount; i++)
                    {
                        int score = (int)Double.parseDouble(obj.next()) ;

                        if(score != -1)
                        {
                            if(score >= 80)
                                score = 4;
                            else if(score < 80 && score >= 70)
                                score = 3;
                            else if(score < 70 && score >= 60)
                                score = 2;
                            else if(score < 60 && score >= 50)
                                score = 1;
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

                    double gpa = totalScore/(double)enrollCount;
                
                
                
                    edit = edit.concat(studentInfo + " " + enrollCount + " " + gpa + "\n");
               }
           }
       }

       FileWriter editStudentInfo = new FileWriter("student_report.txt");
       editStudentInfo.write(edit);
       editStudentInfo.close();


       


    
    }
}