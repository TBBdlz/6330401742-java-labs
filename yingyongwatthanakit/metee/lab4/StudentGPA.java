/*
  StudentGPA is grading program
  program takes input as course information
  and program let user input data
  until they enter 0 program will continue next function
  input format:
  <year> <term> <course name> <credit> <grade>
  next program will ask user if they
  want to see <all the courses> or <GPA> or <specific GPA>
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 22 January 2021
*/
package yingyongwatthanakit.metee.lab4;

import java.util.Scanner;

public class StudentGPA {
    static final int MAX_NUMBER_OF_CORUSE = 150;
    static int[] year = new int[MAX_NUMBER_OF_CORUSE];
    static int[] term = new int[MAX_NUMBER_OF_CORUSE];
    static String[] courseName = new String[MAX_NUMBER_OF_CORUSE];
    static int[] courseCredit = new int[MAX_NUMBER_OF_CORUSE];
    static String[] grades = new String[MAX_NUMBER_OF_CORUSE];
    static int numberOfCourses = 0;
    public static void main(String[] args) {
        inputGrades();
        showGPA();
    }

    static void inputGrades() {
        System.out.println("Enter grades of student (year term name_course credit grade).");
        System.out.println("Finish when enter year with 0");
        int inputYear = 1, inputTerm, inputCredit;
        String inputCourseName, inputGrades;
        while (true) {
            Scanner input = new Scanner(System.in);
            inputYear = input.nextInt();
            if (inputYear <= 0) {
                break;
            }
            inputTerm = input.nextInt();
            inputCourseName = input.next();
            inputCredit = input.nextInt();
            inputGrades = input.next();
            year[numberOfCourses] = inputYear;
            term[numberOfCourses] = inputTerm;
            courseName[numberOfCourses] = inputCourseName;
            courseCredit[numberOfCourses] = inputCredit;
            grades[numberOfCourses] = inputGrades;
            numberOfCourses++;
        }
    }

    static void showGPA() {
        while (true) {
            System.out.println("Type in 'o' to see all courses, 'a' for acumulated GPA, 't' for GPA for specific term or 'q' to exit");
            Scanner user = new Scanner(System.in);
            String command = user.next();
            switch (command.toLowerCase()) {
                case "o":
                    System.out.println("year  term  course_number  credit  grade");
                    for (int i = 0; i < numberOfCourses; i++) {
                    System.out.println(year[i] + "  " + term[i] + "  " + courseName[i] + "  " + courseCredit[i] + "  " + grades[i]);
                    }
                    break;
                case "a":
                    double gpa;
                    int creditAttemp = 0;
                    double gradePoint = 0;
                    for (int i = 0; i < numberOfCourses; i++) { 
                        creditAttemp += courseCredit[i];
                        switch (grades[i]) {
                            case "A":
                                gradePoint += 4 * courseCredit[i];
                                continue;
                            case "B+":
                                gradePoint += 3.5 * courseCredit[i];
                                continue;
                            case "B":
                                gradePoint += 3 * courseCredit[i];
                                continue;
                            case "C+":
                                gradePoint += 2.5 * courseCredit[i];
                                continue;
                            case "C":
                                gradePoint += 2 * courseCredit[i];
                                continue;
                            case "D+":
                                gradePoint += 1.5 * courseCredit[i];
                                continue;
                            case "D":
                                gradePoint += 1 * courseCredit[i];
                                continue;
                            case "F":
                                continue;
                        }
                    }
                    // GPA formula: GPA = sigma(grade * credit) / sigma(credit)
                    gpa = gradePoint / creditAttemp;
                    System.out.println("Accumulated GPA is " + gpa);
                    break;
                case "t":
                    System.out.println("Enter which year and term do you want to see GPA");
                    Scanner spec = new Scanner(System.in);
                    int specYear = spec.nextInt();
                    int specTerm = spec.nextInt();
                    double specGPA;
                    int specCreditAttemp = 0;
                    double specGradePoint = 0;
                    for (int i = 0; i < numberOfCourses; i++) {
                        if ((year[i] == specYear) && (term[i] == specTerm)) { // only for specific term and year
                            specCreditAttemp += courseCredit[i];
                            switch (grades[i]) {
                                case "A":
                                    specGradePoint += 4 * courseCredit[i];
                                    continue;
                                case "B+":
                                    specGradePoint += 3.5 * courseCredit[i];
                                    continue;
                                case "B":
                                    specGradePoint += 3 * courseCredit[i];
                                    continue;
                                case "C+":
                                    specGradePoint += 2.5 * courseCredit[i];
                                    continue;
                                case "C":
                                    specGradePoint += 2 * courseCredit[i];
                                    continue;
                                case "D+":
                                    specGradePoint += 1.5 * courseCredit[i];
                                    continue;
                                case "D":
                                    specGradePoint += 1 * courseCredit[i];
                                    continue;
                                case "F":
                                    continue;
                            }
                        }
                    }
                    // GPA formula: GPA = sigma(grade * credit) / sigma(credit)
                    specGPA = specGradePoint / specCreditAttemp; 
                    System.out.println("Accumulated GPA is " + specGPA);
                    break;
                case "q":
                    System.exit(1);
            }
        }
    }
}