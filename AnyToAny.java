import java.util.*;;

public class AnyToAny {

  public static int AnyToAnyNumber(int num , int base,int convertingBase){
    int finalSum = 0 , count = 0 ;
    while( num > 0 ){
      int rem = num % convertingBase;
      finalSum += rem * Math.pow(base, count);
      count++;
      num /= convertingBase;
    } 
    return finalSum;
  }
  public static void main(String[] args){
    Scanner inp = new Scanner(System.in);
    System.out.println("enter a base value:");
    int base = inp.nextInt();
    
    System.out.println("enter a value:");
    int num = inp.nextInt();
    
    System.out.println("enter a converting base value:");
    int convertingBase = inp.nextInt();

    int finalValue = AnyToAnyNumber(num ,base,convertingBase);
    System.out.println("hence the "+base+" of "+num+" value is "+finalValue);
    inp.close();
  }
}
