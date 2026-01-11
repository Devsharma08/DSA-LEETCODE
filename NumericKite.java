import java.util.Scanner;

public class NumericKite {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    int num = inp.nextInt();
    int value = 1;
    int stVal = 1;
    int blank = num/2 ,star = 1 ;
    for(int i = 0 ; num > i ; i++ ){
      // value = 1;
      for(int j = 0 ; blank > j ; j++){
        System.out.print("\t");
      }
      value = stVal; 
      for(int j =0 ; j < star ; j++){
        System.out.print((value)+"\t");
      // System.out.print(value);
      if(j<star/2){
        value++;
      } else{
        value--;
      }

      }
      System.out.println();
      if(num/2 > i ){
        blank--;
        stVal++;
        star+=2;
      } else{
       
        blank++;
        stVal--;
        star-=2;
      }
    }
    inp.close();
  }
}
