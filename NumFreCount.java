import java.util.*;

public class NumFreCount {

  public static int numCount(int num,int f){
    int count = 0 ;
    while(num>0){
      if(num%10==f){
        count++;
      }
      num/=10;
    }
    return count;
  }
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    int num = inp.nextInt();
    int f = inp.nextInt();

    int numFre = numCount(num,f);
    System.out.print("number "+f +" occured in "+num+" "+numFre+" times");

    inp.close();
  }
}
