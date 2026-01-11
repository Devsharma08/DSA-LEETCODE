import java.util.*;

public class TableMul {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    int num = inp.nextInt();
    
      for(int j = 1 ; j <= 10 ; j++){
        System.out.println(num+" "+" * "+j+" = "+num*j);
      }
    inp.close();
  } 
}
