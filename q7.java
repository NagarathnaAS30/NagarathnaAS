package lab3c;
import java.util.Scanner;

public class q7 {
	
	
		

		    // User-defined function
		    public static String truncate(String str, int maxLength) {

		        if (str == null || str.length() <= maxLength) {
		            return str; // no need to truncate
		        }

		        return str.substring(0, maxLength) + "...";
		    }

		    public static void main(String[] args) {

		        Scanner sc = new Scanner(System.in);

		        System.out.println("Enter a string:");
		        String input = sc.nextLine();

		        System.out.println("Enter maximum length:");
		        int length = sc.nextInt();

		        String result = truncate(input, length);

		        System.out.println("Truncated string: " + result);

		        sc.close();
		    }
		}




