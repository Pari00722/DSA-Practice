public class stringtoint {
    public static int myAtoi(String s) {
        int i = 0, n = s.length();
        int sign = 1;
        long result = 0; // use long to handle overflow before clamping

        // 1️⃣ Step 1: Ignore leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2️⃣ Step 2: Check for sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3️⃣ Step 3: Read digits and build number
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;

            // 4️⃣ Step 4: Clamp if out of 32-bit range
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        // 5️⃣ Step 5: Apply sign and return
        return (int) (sign * result);
    }

    // Example test cases
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));          // Output: 42
        System.out.println(myAtoi("   -042"));     // Output: -42
        System.out.println(myAtoi("1337c0d3"));    // Output: 1337
        System.out.println(myAtoi("0-1"));         // Output: 0
        System.out.println(myAtoi("words and 987"));// Output: 0
    }
}


