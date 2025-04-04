import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercises {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String Inp1 = input.nextLine();
        System.out.println(findDate(Inp1));
        String Inp2 = input.nextLine();
        System.out.println(validateEmail(Inp2));
        String Inp3 = input.nextLine();
        System.out.println(findPalindromes(Inp3));
        String Inp4 = input.nextLine();
        System.out.println(findValidPasswords(Inp4));

    }

    /*
        complete the method below, so it will validate an email address
     */
    public static boolean validateEmail(String email) {
        String regex = "^(?!.*\\.{2})[a-zA-Z0-9._%+-]+(?<!\\.)@[a-zA-Z0-9.-]+(?<!-)(\\.[a-zA-Z]{2,})$";


        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    /*
        this method should find a date in string
        note that it should be in british or american format
        if there's no match for a date, return null
     */
    public static String findDate(String string) {
        String regex = "\\b(\\d{4})[/-](0[1-9]|1[0-2])[/-](0[1-9]|[12][0-9]|3[01])\\b|\\b(0[1-9]|[12][0-9]|3[01])[/-](0[1-9]|1[0-2])[/-](\\d{4})\\b";


        ;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {
            return matcher.group();
        }

        return null;
    }

    /*
        given a string, implement the method to detect all valid passwords
        then, it should return the count of them

        a valid password has the following properties:
        - at least 8 characters
        - has to include at least one uppercase letter, and at least a lowercase
        - at least one number and at least a special char "!@#$%^&*"
        - has no white-space in it
     */
    public static int findValidPasswords(String input) {
        if (input == null || input.trim().isEmpty())
            return 0;
        int validCount = 0;
        String[] passwords = input.split("\\s+");
        String regex = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[^\\s]{8,}";
        Pattern compiledPattern = Pattern.compile(regex);
        for (String p : passwords) {
            if (compiledPattern.matcher(p).matches()) {
                validCount++;
            }
        }
        return validCount;
    }



    /*
        you should return a list of *words* which are palindromic
        by word we mean at least 3 letters with no whitespace in it

        note: your implementation should be case-insensitive, e.g. Aba -> is palindrome
     */
    public static List<String> findPalindromes(String string) {
        List<String> list = new ArrayList<>();

        String[] words = string.split("\\W+");

        for (String word : words) {
            int left = 0;
            int right = word.length() - 1;
            boolean isPalindrome = true;



            while (left < right) {
                String lowerCaseWord = word.toLowerCase();
                if (lowerCaseWord.charAt(left) != lowerCaseWord.charAt(right)) {
                    isPalindrome = false;
                }

                left++;
                right--;
            }
            if (word.length() >= 3) {




                if (isPalindrome) {
                    list.add(word);
                }


            }
        }

        return list;
    }

}
