import java.util.Scanner;

public class InverseNum {
  public static void main(String[] args){

    // simple inverse

    // int count = 0;
    // Scanner inp = new Scanner(System.in);
    // int num = inp.nextInt();
    // int num1 = num ; 
    // if(num>0){
    //     while(num % 10 > 0){
    //         num /= 10; 
    //         count ++;
    //     }
       
    //     int invSum = 0;
    //     int div = (int)Math.pow(10, count-1);
    //     while(div>0){
    //         invSum += (num1 % 10) * div;
    //         div /= 10;
    //         num1/=10;
    //     }
    //     System.out.println(invSum); 
    // } 

    // complex inverse

    int sum = 0 ;
    Scanner inp = new Scanner(System.in);
    int num = inp.nextInt();
    int i = 1;
    int value = num % 10 ;
    int multiplier = (int)Math.pow(10, (value -1));
    while(value > 0){
      sum += i * multiplier;
      i++;
      num /= 10;
      value = num % 10 ;
      multiplier = (int)Math.pow(10, (value -1));
    }
    System.out.println(sum);
    inp.close();

  }  
}
