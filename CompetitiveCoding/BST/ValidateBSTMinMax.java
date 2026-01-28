// ValidateBST
// Validate a BST (isValidBST)
//
// Starter Java template. Implement methods as required by the practical.
//
// Compile:
//   javac ValidateBST.java
// Run:
//   java ValidateBST
//
// 

public class ValidateBST_MinMax {

    // Tree node definition
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    // BST validation using min-max range
    static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null)
            return true;

        if (node.val <= min || node.val >= max)
            return false;

        return validate(node.left, min, node.val) &&
               validate(node.right, node.val, max);
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

        System.out.println("BST Check (Min-Max
