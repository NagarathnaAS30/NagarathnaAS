package lab_3b;
import java.util.Scanner;
public class q5 {
	

		
		    // User-defined function
		    public static String removeWhitespace(String str) {
		        return str.replaceAll("\\s", "");
		    }

		    public static void main(String[] args) {

		        Scanner sc = new Scanner(System.in);

		        System.out.println("Enter a string:");
		        String input = sc.nextLine();

		        String result = removeWhitespace(input);

		        System.out.println("String after removing whitespace: " + result);

		        sc.close();
		    }
		}





