import java.util.Scanner;

public class Prime2 {
  public static void main(String[] args){
    Scanner inp = new Scanner(System.in);

    int low = 0;
    int high = 0;
    boolean isPrime = true;
    System.out.print("Enter a low:");
    low = inp.nextInt();
    System.out.print("Enter a high:");
    high = inp.nextInt();
    while( low < high ){
      // System.out.println("indide while");
      for(int i = 2 ; high > i*i ; i++ ){
      // System.out.println("indide for");
        if(i == low ) continue; 
        if( low % i == 0){
          isPrime = false ;
          break;
        }  

      }
      if(isPrime==true){
        System.out.println(low + " is Prime");
      }
      isPrime = true;
      low++;
    }
    
    inp.close();
  }
}
