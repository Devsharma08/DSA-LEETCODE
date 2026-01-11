import java.util.*;

public class DiagonalPrint {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    int num = inp.nextInt();
    for (int i = 1; i <= num; i++) {
      for (int j = 1; j <= i; j++) {
        if (i == j) {
          System.out.print("*\t");
          break;
        } else {
          System.out.print("\t");
          continue;
        }
      }
      System.out.println();
    }
    inp.close();
  }
}
