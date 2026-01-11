import java.util.Scanner;

public class RecPermutation {

  public static int fact(int num){
    int total = 1;
    while(num>1){
      total*=num;
      num--;
    }
    return total;
  };
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    int n = inp.nextInt();
    int r = inp.nextInt();

    int num = fact(n);
    int nMr = fact(n-r);

    System.out.println(n+"P"+r+"="+num/nMr);
    inp.close();
  }
}
