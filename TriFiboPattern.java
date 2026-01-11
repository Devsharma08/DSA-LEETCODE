import java.util.Scanner;

public class TriFiboPattern {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    int num = inp.nextInt();
    int first= 0,second=1;
    for(int i = 0 ; num > i ; i++){
      for(int j = 0 ; j <= i ; j++){
        System.out.print(first+"\t");
        int next = first + second;
        first = second;
        second = next;
      }
      System.out.println();
    }
    inp.close();
  }
}
