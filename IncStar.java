import java.util.*;

public class IncStar {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);

    int num = inp.nextInt();

    for(int i = 1 ; i <= num ; i++){
      for(int j= 1 ; j <= i ; j++){
        System.out.print("* ");
      }
      System.out.println();
    }

    inp.close();
  }
}
