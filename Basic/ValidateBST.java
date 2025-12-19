
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class ValidateBST {

    // Function to check if tree is a valid BST
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;

        // BST property violation
        if (node.val <= min || node.val >= max)
            return false;

        // Check left and right subtrees
        return validate(node.left, min, node.val) &&
               validate(node.right, node.val, max);
    }

    // Main method
    public static void main(String[] args) {

        // Example 1: [2,1,3]
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println(isValidBST(root1)); // true

        // Example 2: [5,1,4,null,null,3,6]
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println(isValidBST(root2)); // false
    }
}
