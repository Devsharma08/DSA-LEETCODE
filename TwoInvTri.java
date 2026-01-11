import java.util.Scanner;

public class TwoInvTri {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    int num = inp.nextInt();

    int numHalf = num/2;
    int gap = 0;
    int star = num;
    for(int i = 0; num > i ; i++){
      for(int j = 0 ; j < gap ; j++){
       System.out.print("\t");
       
      }
      for(int j = 0 ; j < star ; j++){
        if(i==0){
       System.out.print("*\t");
       continue;
        } if(i<num/2){
          if(j==0 || j==star-1){
           System.out.print("*\t");
          } else{
           System.out.print("\t");
          }
        } else{
          System.out.print("*\t");
        }
      }
      System.out.println();
      if(i<numHalf){
        gap++;
        star-=2;
      } else{
        gap--;
        star+=2;
      }
    }

    inp.close();
  }
}
