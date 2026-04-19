package lab_3b;
import java.util.Scanner;
public class q3 {
	
		 public static String reverseString(String str) {

		        String reversed = "";

		        for (int i = str.length() - 1; i >= 0; i--) {
		            reversed = reversed + str.charAt(i);
		        }

		        return reversed;
		    }

		    public static void main(String[] args) {

		        Scanner sc = new Scanner(System.in);

		        System.out.println("Enter a string:");
		        String input = sc.nextLine();

		        String result = reverseString(input);

		        System.out.println("Reversed string: " + result);

		        sc.close();
		    }
		

	}



