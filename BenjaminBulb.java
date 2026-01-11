import java.util.Scanner;

public class BenjaminBulb {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    int num = inp.nextInt();

    // print buld with on states rest all are false -- get false eventually -- calc factorials always get even for non perfect square number
    
    for(int i = 1 ; num >= i*i ; i++){
      System.out.println(i*i);
    }
    inp.close();
  } 
}
