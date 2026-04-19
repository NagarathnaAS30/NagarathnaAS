package lab_3b;
import java.util.Scanner;
public class q2 {
	
		  public static int countOccurrences(String mainStr, String subStr) {

		        int count = 0;
		        int index = 0;

		        while ((index = mainStr.indexOf(subStr, index)) != -1) {
		            count++;
		            index = index + subStr.length(); // move ahead
		        }

		        return count;
		    }

		    public static void main(String[] args) {

		        Scanner sc = new Scanner(System.in);

		        System.out.println("Enter the main string:");
		        String mainStr = sc.nextLine();

		        System.out.println("Enter the substring:");
		        String subStr = sc.nextLine();

		        int result = countOccurrences(mainStr, subStr);

		        System.out.println("The substring appears " + result + " times");

		        sc.close();
		    }
		}



