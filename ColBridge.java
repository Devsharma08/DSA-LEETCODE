import java.util.Scanner;

public class ColBridge {
  public static void main(String[] args) {

    Scanner inp = new Scanner(System.in);
    int col = inp.nextInt();

    // total col = 2col -1
    for(int i = 0 ; col > i ; i++){
      int val  = 1 ;
      for(int j = 0 ; col >= j ; j++){
        if(j<=i){
        System.out.print(val+j+"\t");
      } else System.out.print("\t") ;

      }
      for(int j = col-2 ; j >= 0  ; j--){
        if(j<=i)
        System.out.print(val+j+"\t");
        else System.out.print("\t");
      }
      System.out.println();
      
    }
    inp.close();
  }
}
