public class ValidateBST_Inorder {

    // Tree node definition
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    static Integer prev = null;

    static boolean isValidBST(TreeNode root) {
        prev = null; // reset for safety
        return inorder(root);
    }

    private static boolean inorder(TreeNode root) {
        if (root == null)
            return true;

        if (!inorder(root.left))
            return false;

        if (prev != null && root.val <= prev)
            return false;

        prev = root.val;

        return inorder(root.right);
    }

    // Main method
    public static void main(String[] args) {

        /*
                 10
                /  \
               5    15
                   /
                  12
        */

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(12);

        System.out.println("BST Check (Inorder): " + isValidBST(root));
    }
}
