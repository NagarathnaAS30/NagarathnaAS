package lab2a;

public class StringOperationsDemo {

    public static void main(String[] args) {

        // 1. String Creation and Basic Operations
        String str1 = "Hello";
        String str2 = new String("World");
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);

        // 2. Length and Character Access
        System.out.println("\nLength of str1: " + str1.length());
        System.out.println("Character at index 1 in str1: " + str1.charAt(1));

        // 3. String Comparison
        String str3 = "hello";
        System.out.println("\nstr1 equals str3: " + str1.equals(str3));
        System.out.println("str1 equalsIgnoreCase str3: " + str1.equalsIgnoreCase(str3));

        // 4. String Searching
        String sentence = "Java programming is fun";
        System.out.println("\nIndex of 'programming': " + sentence.indexOf("programming"));
        System.out.println("Contains 'fun': " + sentence.contains("fun"));

        // 5. Substring Operations
        System.out.println("\nSubstring (0 to 4): " + sentence.substring(0, 4));

        // 6. String Modification
        String modified = sentence.replace("fun", "awesome");
        System.out.println("\nModified String: " + modified);

        // 7. Whitespace Handling
        String spaced = "   Hello Java   ";
        System.out.println("\nBefore trim: '" + spaced + "'");
        System.out.println("After trim: '" + spaced.trim() + "'");

        // 8. String Concatenation
        String concat = str1 + " " + str2;
        System.out.println("\nConcatenated String: " + concat);

        // 9. String Splitting
        String fruits = "Apple,Banana,Orange";
        String[] fruitArray = fruits.split(",");
        System.out.println("\nSplitted Strings:");
        for (String fruit : fruitArray) {
            System.out.println(fruit);
        }

        // 10. StringBuilder Demo
        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Programming");
        sb.insert(5, "Language ");
        sb.replace(0, 4, "Advanced");
        System.out.println("\nStringBuilder Result: " + sb);

        // 11. String Formatting
        String name = "Nagu";
        int age = 20;
        String formatted = String.format("Name: %s, Age: %d", name, age);
        System.out.println("\nFormatted String: " + formatted);

        // 12. Validate Email using contains(), startsWith(), endsWith()
        String email = "example@gmail.com";

        if (email.contains("@") && email.contains(".") &&
            email.endsWith(".com") &&
            !email.startsWith("@")) {

            System.out.println("\nEmail is valid: " + email);
        } else {
            System.out.println("\nInvalid Email: " + email);
        }
    }
}