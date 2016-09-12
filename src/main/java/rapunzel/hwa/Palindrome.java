package rapunzel.hwa;

import java.util.HashMap;

public class Palindrome {
    private HashMap<String, Boolean> recentStrings = new HashMap<>();

    private void splitAtPalindrome(String string, int n) {
        int stringLength = string.length();
        if(n < stringLength) {
            int splitLength = stringLength - n;
            String leftSubString = string.substring(0, splitLength);
            if (checkPalindrome(leftSubString)) {
                String rightSubString = string.substring(splitLength, stringLength);
                if(checkPalindrome(rightSubString)) {
                    System.out.println(leftSubString + " " + rightSubString);
                } else {
                    System.out.print(leftSubString + " " ) ;
                    splitAtPalindrome(rightSubString, 0);
                }
            } else {
                splitAtPalindrome(string, n + 1);
            }
        }
    }

    private boolean checkPalindrome(String string) {
        if(recentStrings.get(string) == null) {
            int i = 0;
            int j = string.length() - 1;
            char[] charString = string.toCharArray();
            while (i < j) {
                if (charString[i] == charString[j]) {
                    i++;
                    j--;
                } else {
                    recentStrings.put(string, false);
                    return false;
                }
            }
            recentStrings.put(string, true);
            return true;
        }
        return recentStrings.get(string);
    }

    public static void main(String[] args) {
        Palindrome test = new Palindrome();
        String testString = "MADAMIMADAM";
        test.splitAtPalindrome(testString, 0);
        testString = "MADAMANNA";
        test.splitAtPalindrome(testString, 0);
        testString = "MADAMSANNA";
        test.splitAtPalindrome(testString, 0);
        testString = "HELLOWORLD";
        test.splitAtPalindrome(testString, 0);
        testString = "SHARVARI";
        test.splitAtPalindrome(testString, 0);
    }
}
