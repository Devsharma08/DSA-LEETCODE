import java.util.Scanner;

public class NumberInc {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    int num = inp.nextInt();
    int number = 1;
    for(int i = 0 ; num > i ; i++){
      for(int j = 0 ; i >= j ; j++){
        System.out.print(number+"\t");
        number++;
      }
      System.out.println();
    }

    inp.close();
    
  }
}
