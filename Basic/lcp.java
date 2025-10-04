public class lcp{

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
    public static void main(String[] args) {
        lcp sol = new lcp();

        String[] input1 = {"flower", "flow", "flight"};
        System.out.println("Output: " + sol.longestCommonPrefix(input1)); 

        String[] input2 = {"dog", "racecar", "car"};
        System.out.println("Output: " + sol.longestCommonPrefix(input2)); 
    }
}
