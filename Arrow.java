import java.util.Scanner;

public class Arrow {
  public static void main(String[] args){
    Scanner inp = new Scanner(System.in);
    int num = inp.nextInt();
    inp.close();
    
    int half = num/2;
    int ind = 1;
    // int count = 1;
    for(int i = 0 ; num > i ; i++){
      
      for(int j = 0 ; j < num/2 ; j++){
        if(j < half && i==half){
        System.out.print("*\t");
        continue;
        } else{
          System.out.print("\t");
        }
      }
      for(int j = 0 ; j < half+1 ; j++){
        if(ind > j )
        System.out.print("*\t" );
        else{
          System.out.print("\t");
        }
      }
      System.out.println();
      if(i < half){
        ind++;
      } else ind--;
    }
  }
}
