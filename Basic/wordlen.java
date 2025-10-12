public class wordlen {
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int lastSpace = s.lastIndexOf(' ');
        
        return s.length() - lastSpace - 1;
    }

    public static void main(String[] args) {
        String s1 = "Hello World";
        String s2 = "   fly me   to   the moon  ";
        String s3 = "luffy is still joyboy";

        System.out.println(lengthOfLastWord(s1)); 
        System.out.println(lengthOfLastWord(s2)); 
        System.out.println(lengthOfLastWord(s3)); 
    }
}
