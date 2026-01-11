import java.util.Scanner;


public class InvKite {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    int num = inp.nextInt();

    int mid = num / 2 ;
    int rem = num % 2 ;
    for(int i = 0 ; i < num ; i++){
      for(int j = 0 ; j < mid ; j++){
        System.out.print("*\t");
      }
      for(int k = 0 ; k < rem ; k++){
        System.out.print("\t");
      }
      for(int h = 0 ; h < mid ; h++){
        System.out.print("*\t");
      }
      System.out.println();
      if(i < num/2){
        mid --;
        rem += 2;
      } else {
        mid++;
        rem-=2;
      }
    }
    inp.close();
  }
}
