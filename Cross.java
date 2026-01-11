import java.util.*;

public class Cross {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    int num = inp.nextInt();
    int lastStar = num;
    // int mid = num / 2 + 1;

    for(int i = 0 ; i < num ; i++ ){
      for(int j = 0 ; j < num ; j++ ){
        if(j==i || i+j==num-1){
          System.out.print("*\t");
          lastStar--;
          // break;
        }
        else{
          System.out.print("\t");
        }
      }
      System.out.println();
    }
  }
}
