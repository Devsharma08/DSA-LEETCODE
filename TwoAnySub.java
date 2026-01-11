import java.util.*;

public class TwoAnySub {
  
  // checking number to be of valid base
  public static boolean NumCheck(int num, int base){
    while(num!=0){
      int val = num % base;
      if(val >= base){
        return false;
      }
      num/=10;
    }
    return true;
  }

  // addition
  public static int Subtraction(int num1,int num2,int base){
    int inc = 0,num = 0,count = 0, rem1 = 0, rem2 = 0;
    while(num1 > 0 || num2 > 0){
      rem1 = num1 % base;
      rem2 = num2 % base;
      int result = 0;
      if(rem1 >= rem2){
        result = rem1 - rem2;
      } else{
        rem1 += base; 
        result = rem1 - rem2;
        num1 -= (int)Math.pow(base,count+1);
      }
      num1 /= 10;
      num2 /= 10;
      
      if(result >= base && num1 > 0){
        result -= base;
        inc = 1;
        num1 += inc;
      } else {
        inc = 0;
      }
      num += (result * Math.pow(base, count));
      System.out.println("result"+result);
      if(num1 <= 0 && num1 < num2){
        num2 = num2*(int)Math.pow(base, count+1);
        num = num2 - result;
        return -num;
      }
      count++; 
    }
    return num;
  }

 public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    System.out.print("enter the base for subtraction:");
    int base = inp.nextInt();
    System.out.print("enter first number:");
    int num1 = inp.nextInt();
    boolean numStatus = NumCheck(num1,base);
    if(!numStatus){
      System.out.println("number not valid");
      return ;
    } else{
      System.out.println("number is valid");
    }
    System.out.print("enter second number:");
    int num2 = inp.nextInt();
    numStatus = NumCheck(num2,base);
    if(!numStatus){
      System.out.println("number not valid");
      return ;
    } else{
      System.out.println("number is valid");
    }

    int subtractionResult = Subtraction(num1, num2, base);
    System.out.print("Subtraction of "+num1+"and "+num2+"is: "+subtractionResult);

    inp.close();
 } 
}
