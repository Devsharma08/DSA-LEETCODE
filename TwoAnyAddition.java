import java.util.*;

public class TwoAnyAddition {
  
  // checking number to be of valid base
  public static boolean NumCheck(int num, int base){
    while(num!=0){
      int val = num % 10;
      if(val >= base){
        return false;
      }
      num/=10;
    }
    return true;
  }

  // addition
  public static int Addition(int num1,int num2,int base){
    int inc = 0,num = 0,count = 0, rem1 = 0, rem2 = 0;
    while(num1 > 0 || num2 > 0 || rem1 > 0 || rem2 > 0){
      rem1 = num1 % 10;
      rem2 = num2 % 10;
      int result = rem1 + rem2 + inc;
      if(result >= base){
        result -= base;
        inc = 1;
      } else {
        inc = 0;
      }
      num += (result * Math.pow(10, count));
      count++;
      num1 /= 10;
      num2 /= 10;
    }
    return num;
  }

 public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    System.out.print("enter the base for addition:");
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

    int additionResult = Addition(num1, num2, base);
    System.out.print("Sum of "+num1+"and "+num2+"is: "+additionResult);

    inp.close();
 } 
}
