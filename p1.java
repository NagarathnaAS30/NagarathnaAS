package lab_3b;
import java.util.Scanner;
public class p1 {
	public static boolean isNullOrEmpty(String str) {
        if (str == null || str.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        if (isNullOrEmpty(input)) {
            System.out.println("The string is null or contains only whitespace");
        } else {
            System.out.println("The string is not null or empty");
        }

        sc.close();
    }
}

	