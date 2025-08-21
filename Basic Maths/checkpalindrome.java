public class checkpalindrome {
    public int palindromeNumber(int n) {
        int reverseNumber = 0;
        int duplicate = n;
        
        while (n > 0) {
            int lastDigit = n % 10;
            n = n / 10;
            reverseNumber = (reverseNumber * 10) + lastDigit;
        }
        
        if (duplicate== reverseNumber) {
            return 1; 
        } else {
            return 0; 
        }
    }

    public static void main(String[] args) {
        checkpalindrome obj = new checkpalindrome(); 
        int n = 6789876; 
        int result = obj.palindromeNumber(n); 

        if (result == 1) {
            System.out.println(n + " is a Palindrome.");
        } else {
            System.out.println(n + " is NOT a Palindrome.");
        }
    }
}