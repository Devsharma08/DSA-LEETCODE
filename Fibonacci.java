import java.util.Scanner;

public class Fibonacci{
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    System.out.print("Enter a Number to find it's fibonacci:");
    int fib = inp.nextInt();
    int i = 2;
    int fir = 0;
    int sec = 1;
    int thr = 1;
    System.out.println(fir);
    System.out.println(sec);
    while(fib > i){
      thr = fir + sec;
      System.out.println(thr);
      fir = sec ;
      sec =  thr;
      i++ ;
    }
  }
}