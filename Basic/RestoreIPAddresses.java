
import java.util.*;

public class RestoreIPAddresses {

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(String s, int index, int dots,
                                  StringBuilder current, List<String> result) {

        // If 4 parts are formed and all digits are used
        if (dots == 4 && index == s.length()) {
            result.add(current.substring(0, current.length() - 1));
            return;
        }

        // If parts exceed 4 or digits end early
        if (dots > 4 || index >= s.length()) return;

        // Try parts of length 1 to 3
        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);

            // Leading zero check
            if (part.length() > 1 && part.startsWith("0")) break;

            int value = Integer.parseInt(part);
            if (value > 255) break;

            int before = current.length();
            current.append(part).append(".");
            backtrack(s, index + len, dots + 1, current, result);
            current.setLength(before); // backtrack
        }
    }

    public static void main(String[] args) {
        String s1 = "25525511135";
        System.out.println(restoreIpAddresses(s1));

        String s2 = "0000";
        System.out.println(restoreIpAddresses(s2));

        String s3 = "101023";
        System.out.println(restoreIpAddresses(s3));
    }
}
