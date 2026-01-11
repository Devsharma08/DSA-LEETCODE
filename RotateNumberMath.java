// import java.util.*;

// public class RotateNumber {
//   public static void main(String[] args) {

//     Scanner inp = new Scanner(System.in);
//     int num = inp.nextInt();
//     int num1 = num;
//     System.out.print("Enter ratating number:");
//     int rotate = inp.nextInt();
//     // int inc = 0;
//     int sum = 0;
//     int count = 0;

//     // calculate count  

//     while(num1>0){
//       count++;
//       num1/=10;
//     }
    
//     if(rotate < 0){
//       if(Math.abs(rotate) > count) rotate = rotate % count;
//       rotate = rotate + count; 
//     }

//     if(rotate > count){
//       rotate = rotate % count;
//     }

//     for(int i = 0 ; rotate > i ; i++){
//       int mul = num % 10 * (int)Math.pow(10, i);
//       num = num / 10;
//       sum += mul;
//     }
//      sum = sum *(int) Math.pow(10,(count-rotate));
//      sum += num;
//      System.out.println(sum);
//     inp.close();
//   }
// }


import java.util.Scanner;

public class RotateNumberMath {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = inp.nextInt();
        int num1 = num; // Copy for counting digits

        System.out.print("Enter rotating number: ");
        int rotate = inp.nextInt();
        
        int count = 0;
        while (num1 > 0) {
            count++;
            num1 /= 10;
        }
        
        if (num == 0) {
            System.out.println(0);
            inp.close();
            return;
        }

        rotate = rotate % count;
        if (rotate < 0) {
            rotate = rotate + count;
        }

        int div = (int)Math.pow(10, rotate);
       
        int mul = (int)Math.pow(10, count - rotate);

        int backPart = num % div;
        
        int frontPart = num / div;

        int result = (backPart * mul) + frontPart;

        System.out.println(result);
        
        inp.close();
    }
}