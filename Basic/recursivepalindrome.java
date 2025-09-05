public class recursivepalindrome {
    static boolean checkPalindrome(String s, int i) {
        int n = s.length();
        if (i >= n / 2) {
            return true;
        }
        if (s.charAt(i) != s.charAt(n - i - 1)) {
            return false;
        }
        return checkPalindrome(s, i + 1);
    }

    public static void main(String[] args) {
        String s = "madam";
        if (checkPalindrome(s, 0)) {
            System.out.println(s + " is a palindrome");
        } else {
            System.out.println(s + " is not a palindrome");
        }
    }
}
