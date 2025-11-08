public class Countandsay {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countAndSay(n)); // Output: 1211
    }

    public static String countAndSay(int n) {
        if (n == 1) return "1";

        String s = "1";

        for (int i = 2; i <= n; i++) {
            s = getNext(s);
        }
        return s;
    }

    private static String getNext(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                count++;
            } else {
                sb.append(count).append(s.charAt(i-1)); // count + digit
                count = 1;
            }
        }

        // add last group
        sb.append(count).append(s.charAt(s.length()-1));

        return sb.toString();
    }
}
