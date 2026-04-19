package lab_3b;
import java.util.Scanner;
public class q4 {
	
		

		
		    // User-defined function
		    public static boolean isPalindrome(String str) {

		        // Remove punctuation and spaces, convert to lowercase
		        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		        int left = 0;
		        int right = str.length() - 1;

		        while (left < right) {
		            if (str.charAt(left) != str.charAt(right)) {
		                return false;
		            }
		            left++;
		            right--;
		        }

		        return true;
		    }

		    public static void main(String[] args) {

		        Scanner sc = new Scanner(System.in);

		        System.out.println("Enter a string:");
		        String input = sc.nextLine();

		        if (isPalindrome(input)) {
		            System.out.println("The string is a palindrome");
		        } else {
		            System.out.println("The string is not a palindrome");
		        }

		        sc.close();
		    
		}
	}




