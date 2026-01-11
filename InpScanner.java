import java.util.*;


public class InpScanner { 
  // used nextLine() instead of nextInt()|double() ...etc
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("enter some number");
    int num = Integer.parseInt(input.nextLine());
    System.out.println( "Int :" + num );
    System.out.print("enter some float number");

    double numFloat = Double.parseDouble(input.nextLine());
    System.out.println( "Float :" + numFloat );
    System.out.print("enter some string");
    String str = input.nextLine();
    System.out.println( "String :" + str );
  }
} 
