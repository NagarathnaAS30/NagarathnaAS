package lab3c;
import java.util.Scanner;
public class q6 {
	
		
		    // User-defined function
		    public static String capitalizeWords(String str) {

		        String[] words = str.split(" ");
		        String result = "";

		        for (String word : words) {
		            if (word.length() > 0) {
		                String first = word.substring(0, 1).toUpperCase();
		                String rest = word.substring(1).toLowerCase();
		                result = result + first + rest + " ";
		            }
		        }

		        return result.trim();
		    }

		    public static void main(String[] args) {

		        Scanner sc = new Scanner(System.in);

		        System.out.println("Enter a string:");
		        String input = sc.nextLine();

		        String output = capitalizeWords(input);

		        System.out.println("Capitalized string: " + output);

		        sc.close();
		    }
		}





