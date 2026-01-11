import java.util.*;

public class LCM_GCD {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    System.out.print("enter two number to find it's GCD And LCM:");

    int num1 = inp.nextInt();
    int num2 = inp.nextInt();

    int lcm = 0,gcd = 1,least = 0,max=1;
    //finding least 

    if(num1 > num2) {
      least = num2;
      max = num1;
    } else {
      least = num1;
      max = num2;
    }

    // brute force approcah -- 1st method

    for(int i = least ; 2 <= i ; i--){
        if(num1 % i == 0){
            if(num2 % i == 0){
              gcd = i;
              break;
            }
      } else continue;
      }

      // 2nd method

      int rem = max % least ;
      while(rem > 0){
        max = least;
        least = rem;
        rem = max % least;
      }

      // lcm = (num1*num2/gcd)
    // System.out.println("GCD:"+gcd);
    System.out.println("GCD:"+least);
    System.out.print("LCM:"+((num1*num2)/least));

  }
}
