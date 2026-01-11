import java.util.Scanner;

class Prime{
  public static void main(String[] arsg){
    Scanner inp = new Scanner(System.in);
    int isPrime = 0 ;
    System.out.print("Enter a number:");
    byte t = inp.nextByte();
    for(int i = 0 ; t > i ; i++){
      System.out.print("Enter a number:");
      byte n = inp.nextByte(); 
      for(int j = 1 ; n >= (j * j) ; j++){
        if( j == 1 ) continue;
        if(n % j == 0){
          isPrime++;
          break;
        }
      }
      if(isPrime == 0){
        System.out.println("Number is Prime");
      } else
        System.out.println("Number is not prime");
      isPrime = 0;
    }
    inp.close();
  }
}