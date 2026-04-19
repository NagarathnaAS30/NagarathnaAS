package lab3c;
import java.util.Scanner;
import java.util.Random;

public class q9 {
	
		    // User-defined function
		    public static String generateRandomString(int length) {

		        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		        Random rand = new Random();

		        String result = "";

		        for (int i = 0; i < length; i++) {
		            int index = rand.nextInt(characters.length());
		            result += characters.charAt(index);
		        }

		        return result;
		    }

		    public static void main(String[] args) {

		        Scanner sc = new Scanner(System.in);

		        System.out.println("Enter the length of the random string:");
		        int length = sc.nextInt();

		        String randomString = generateRandomString(length);

		        System.out.println("Generated Random String: " + randomString);

		        sc.close();
		    }
		}




