import java.util.*;

public class CountNumber {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    int count = 0 ;
    System.out.print("Enter the Number to find digit count:");
    int num = inp.nextInt();
    int num1 = num ;
    // num = num / 10;
    while( num >= 1){
      num = num / 10 ; 
      // System.out.println(num);
      count++;
    }
    System.out.print( "The number of digits in " + num1 + " are " + count );
  }
}
