import java.util.*;

public class DecimalToAny {

  public static int DecimalToAnyBase(int num,int base){
    int count = 0,finalNum = 0 ; 
    while(num > 0){
      int rem = num % base;
      rem *= Math.pow(10, count);
      finalNum += rem;
      num/=base;
      count++;
    }
    return finalNum;
  }
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    System.out.print("enter a number:");
    int num = inp.nextInt();
    System.out.print("enter a number for conversion to that base:");
    int base = inp.nextInt();
    int value = DecimalToAnyBase(num,base);
    System.out.println("hence the "+base+" of "+num+" value is "+value);
    
    inp.close();
  } 
}
