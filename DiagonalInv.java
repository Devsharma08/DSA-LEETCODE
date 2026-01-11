import java.util.Scanner;

public class DiagonalInv {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    int num = inp.nextInt();
    for(int i = 0 ; num > i ; i++){
      for(int j = num ; j >= i ; j--){
        if(i == j){
        System.out.print("*\t");
        break;
        } else{
          System.out.print("\t");
        }
      }
      System.out.println();
    }
    inp.close();
  }
}
