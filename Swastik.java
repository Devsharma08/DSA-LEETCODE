import java.util.Scanner;

public class Swastik {
  public static void main(String[] args){
    Scanner inp = new Scanner(System.in);
    int num = inp.nextInt();

    for(int i = 0 ; num > i ; i++){
      for( int j = 0 ; j < num ; j ++ ){
        if(i==num-1) {
          if(j>=num/2 || j==0)
          System.out.print("*\t");
           else 
          System.out.print("\t");
        }
        else if(i==0) {
          if(j<=num/2 || j==num-1)
          System.out.print("*\t");
           else {
          System.out.print("\t");
          }}
        else if(i<num/2) {
          if(j==num/2 || j==num-1)
          System.out.print("*\t");
           else {
          System.out.print("\t");
          }}
        else if(i==num/2) {   
          System.out.print("*\t");
        } 
        else {
          if(j==0 || j==num/2)
          System.out.print("*\t");
           else {
          System.out.print("\t");
          } }
        }
    System.out.println("");
    System.out.println("");
  }

    inp.close();
  }
}
