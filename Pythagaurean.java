import java.util.Scanner;

public class Pythagaurean {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    int num1 = inp.nextInt();
    int num2 = inp.nextInt();
    int num3 = inp.nextInt();
    int max = num1;
    // pick max

    if (max * max == (num2 * num2 + num3 * num3)) {
      System.out.println(true);
      return;
    } else {
      System.out.println("false");
    }
    if (num2 > num1 && num2 > num3) {
      max = num2;
      if (max * max == (num1 * num1 + num3 * num3)) {
        System.out.println(true);
        return;
      } else {
        System.out.println(false);
      }
    } else {
      max = num3;
      if (max * max == (num2 * num2 + num1 * num1)) {
        System.out.println(true);
        return;
      } else {
        System.out.println(false);
      }
    }
  }

}
