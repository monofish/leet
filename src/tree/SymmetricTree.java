package tree;

import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *   1
 *  / \
 * 2   2
 *  \   \
 *  3    3
 * <p>
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 *
 * @author Wei
 * @since 2/22/16
 */
public class SymmetricTree {
    // recursive solution
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;    // use inclusive OR to avoid NullPointerException
        return (left.val == right.val) && isSymmetricHelper(left.right, right.left) && isSymmetricHelper(left.left, right.right);
    }

    // iterative solution
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;

        TreeNode left, right;
        Stack<TreeNode> stack = new Stack<>();
        if (root.left == null && root.right == null) { return true; }
        else if (root.left != null && root.right != null) {
            stack.push(root.left);
            stack.push(root.right);
        }
        else return false;

        while (!stack.empty()) {
            right = stack.pop();
            left = stack.pop();
            if (left.val != right.val) return false;

            if (left.left != null && right.right != null) {
                stack.push(left.left);
                stack.push(right.right);
            } else if (left.left != null || right.right != null)
                return false;

            if (left.right != null && right.left != null) {
                stack.push(left.right);
                stack.push(right.left);
            } else if (left.right != null || right.left != null)
                return false;
        }
        return true;
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
