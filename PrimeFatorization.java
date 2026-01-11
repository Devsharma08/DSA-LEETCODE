import java.util.Scanner;

public class PrimeFatorization {
  public static void main(String[] args){
      Scanner inp = new Scanner(System.in);
      int num = inp.nextInt();
      for(int i = 2 ; num >= i*i ;){
        if(num%i==0){
          System.out.print(i+" ");
          num /= i ;
        }
        else{
          i++;
        }
      }
      System.out.print(num);
  }
}
