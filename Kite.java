import java.util.Scanner;

public class Kite {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    int num = inp.nextInt();

    // 1st way
    // for (int i = 0; num > i; i++) {
    //   // 1st blank
    //   for (int j = num; j > i; j--) {
    //     System.out.print("   ");

    //   }
    //   // 2nd triangle
    //   for (int k = 0; k <= i; k++) {
    //     System.out.print("   *  ");
    //   }
    //   System.out.println();
    // }
    // for (int j = 0; j <= num; j++) {
    //   // same but opposite for lower half
    //   for (int m = 0; m < j; m++) {
    //     System.out.print("   ");
    //   }
    //   // 2nd triangle
    //   for (int l = num; l >= j; l--) {
    //     System.out.print("   *  ");
    //   }
    //   System.out.println();
    // }

    // 2nd way
    int mid = num / 2 ;
    int rem = num % 2 ;

    for(int i = 0 ; num > i ; i++){
      for(int j = 0 ; j < mid ; j++){
        System.out.print("   ");
      }
      for(int k = 0 ; rem > k ; k++){
        System.out.print(" * ");
      }
      System.out.println();
      if(i < num/2){
        rem += 2;
        mid --;
      } else {
        rem -=2;
        mid ++;
      }
    }
    
    inp.close();
  }
}