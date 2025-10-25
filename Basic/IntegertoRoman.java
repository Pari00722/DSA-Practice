public class IntegertoRoman {
    public static String intToRoman(int num) {
        // Define values and their corresponding Roman symbols
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        // Loop through each value-symbol pair
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }

        return roman.toString();
    }

    // Example test cases
    public static void main(String[] args) {
        System.out.println(intToRoman(3749)); // Output: MMMDCCXLIX
        System.out.println(intToRoman(58));   // Output: LVIII
        System.out.println(intToRoman(1994)); // Output: MCMXCIV
        System.out.println(intToRoman(4));    // Output: IV
        System.out.println(intToRoman(9));    // Output: IX
    }
}


