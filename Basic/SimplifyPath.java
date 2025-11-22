
import java.util.*;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String p : parts) {
            if (p.isEmpty() || p.equals(".")) continue;
            if (p.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(p);
            }
        }
        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));                      // /home
        System.out.println(simplifyPath("/home//foo/"));                 // /home/foo
        System.out.println(simplifyPath("/home/user/Documents/../Pictures")); // /home/user/Pictures
        System.out.println(simplifyPath("/../"));                        // /
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));       // /.../b/d
    }
}
