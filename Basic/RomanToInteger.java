import java.util.*;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = values.get(s.charAt(i));

            if (i + 1 < s.length() && value < values.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RomanToInteger converter = new RomanToInteger();
        
        System.out.println(converter.romanToInt("III"));      // 3
        System.out.println(converter.romanToInt("LVIII"));    // 58
        System.out.println(converter.romanToInt("MCMXCIV"));  // 1994
    }
}
