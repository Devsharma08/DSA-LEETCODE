import java.util.*;

public class IfElse {
  public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      System.err.println("Enter the Marks for grading:");
      int marks = input.nextInt();

      if(marks > 90){
        System.out.println("Your grade A+");
      }
      else if( marks >80){
        System.out.println("Your grade A");
      }
      else if( marks >70){
        System.out.println("Your grade B");
      }
      else if( marks >60){
        System.out.println("Your grade C");
      }
      else if( marks > 40){
        System.out.println("Your grade D");
      } 
      else {
        System.out.println("You are Fail");
      }
  } 
}
