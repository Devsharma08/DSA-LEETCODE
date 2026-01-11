import java.util.Scanner; 


public class AnyToDecimal {

  public static int AnyToDecimal(int num , int base){
    int finalSum = 0 , count = 0 ;
    while( num > 0 ){
      int rem = num % 10;
      finalSum += rem * Math.pow(base, count);
      count++;
      num /= 10;
    } 
    return finalSum;
  }
  public static void main(String[] args){
    Scanner inp = new Scanner(System.in);
    System.out.println("enter a base value:");
    int base = inp.nextInt();
    
    System.out.println("enter a value:");
    int num = inp.nextInt();

    int finalValue = AnyToDecimal(num ,base);
    System.out.println("hence the "+base+" of "+num+" value is "+finalValue);
    inp.close();
  }
}
