import java.util.*;

// print backward 
// public class ShowNumber {
//   public static void main(String[] args) {
//     Scanner inp = new Scanner(System.in);
//     System.out.print("Enter the Number to find digit count:");
//     int num = inp.nextInt();
//     int mod = 0;
//     while( num >= 1){
//       mod = num % 10 ; 
//       num = num / 10 ;
//       System.out.println(mod) ;
//      }
//   }
// }

// print forward

public class ShowNumber {

  public static void main(String[] args) {
    // count number    
    Scanner inp = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int num = inp.nextInt();

    int num1 = num;
    int count = 0;
    while( num > 0 ){
      num = num / 10;
      count ++;
    }

    int div =  (int)Math.pow(10, count-1);

    while(div > 0){
      System.out.println(num1/div);
      num1 = num1 % div ;
      div = div / 10 ;
    }
    inp.close();  
  }
}