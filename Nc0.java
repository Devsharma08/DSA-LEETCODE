import java.util.Scanner;
// pascal triangal
public class Nc0 {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    int num = inp.nextInt();

    for(int i = 0 ; num > i ; i++){
      int ncr = 1;

      for(int j  = 0 ; j <= i ; j++){
        System.out.print(ncr+"\t");
        ncr = ncr * (i-j) / (j+1) ;
      }
      System.out.println();
    }
    inp.close();

  }
}
