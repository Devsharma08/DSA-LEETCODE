import java.util.*;

public class W {
 public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    int num = inp.nextInt();
    int is = num/2, ds= num/2;
    for(int i = 0 ; num > i ; i++){
      int num1 = 0;
      for(int j = 0 ; j< num ; j++){
        if(num1==0 || num1==num-1){
          System.out.print("*\t");
        }
        if( i <= num/2 && (is==j || ds==j)){
          System.out.print("*\t");
        } else{
          System.out.print("\t");
        }
        num1++;
      }
      System.out.println();
      System.out.println();
      System.out.println();
      if(ds>=0){
            ds--;
          }
          if(is<num){
            is++;
          }
    }
    inp.close();
 } 
}
