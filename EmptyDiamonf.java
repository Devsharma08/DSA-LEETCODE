import java.util.*;

public class EmptyDiamonf {
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);
    int num = inp.nextInt();
    // num = (num%2==0)?num+1:num;
    int lower = 0 , upper = num/2+1;


    for(int i = 0 ; num > i ; i++){
      // 1st triangle
      for(int j = 0 ; j <= num/2+1 ; j++ ){  
          if(j==upper){
            System.out.print("*\t");
          } else{
            System.out.print("\t");
          }
      }
      
      // 2nd triangle
      for(int j = 1 ; (num/2+1) >= j ; j++ ){
       if(j==lower){
             System.out.print("*\t");
           } else{
             System.out.print("\t");
           }
      }

      System.out.println();
      if(i>=num/2){
        lower--;
        upper++;
      } else{
        upper--;
        lower++;
      }
    }
    inp.close();
  }
}
