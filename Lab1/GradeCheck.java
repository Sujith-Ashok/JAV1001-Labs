import java.util.Scanner;
public class GradeCheck{

  public static void main(String[] args) {

  //Declaring variables
    String studentName;
    Double grade;
    Double nextGrade;

    System.out.println();
    System.out.println("Welcome to Letter Grade Converter");
    System.out.println();

  // getting input "student name" from User
    System.out.print("Enter your name: ");
    Scanner keybName = new Scanner(System.in);
    studentName = keybName.nextLine();

  // getting input "grade" from User
    System.out.print("Enter your Grade: ");
    Scanner keybGrade = new Scanner(System.in);
    grade = keybGrade.nextDouble();

    System.out.println();
    System.out.println("Converting your grade into letter grade....⏳");

    System.out.println();
    System.out.println("\033[0;1m"); //to highlight console output in bold

  // Checking if the grade is within correct range
    if(grade >= 0 && grade <= 100){

      System.out.println("Hello " +studentName);

  // if Condition for A grade
      if(grade >= 80){
        System.out.println("Your letter grade is A 🥇");
        System.out.println("Fantastic Grade!! Keep it up");
      }

  // if Condition for B grade
      else if(grade >= 70 && grade < 80){
        nextGrade = 80 - grade;
        System.out.println("Your letter grade is B 🥈");
        System.out.println("Super Grade!! Try to score more " +nextGrade + " grade points to get A grade.");
      }

  // if Condition for C grade
      else if(grade >= 60 && grade < 70){
        nextGrade = 70 - grade;
        System.out.println("Your letter grade is C 🥉");
        System.out.println("Good Grade!! Try to score more " +nextGrade + " grade points to get B grade.");
      }

  // if Condition for D grade
      else if(grade >= 50 && grade < 60){
        nextGrade = 60 - grade;
        System.out.println("Your letter grade is D 🎖");
        System.out.println("Decent Grade!! Try to score more " +nextGrade + " grade points to get C grade.");
      }

  // if Condition for F grade
      else if(grade < 50){
        nextGrade = 50 - grade;
        System.out.println("Your letter grade is F 📚");
        System.out.println("Try harder next time!! Try to score more " +nextGrade + " grade points to get D grade.");
      }

    }

  // if the grade is beyond specifed limit
    else{
      System.out.println("❌OOPS!! Invalid entry ❌");
      System.out.println("Sorry "+studentName + ", You must only enter a valid grade score within 0 - 100");
    }


  }

}
