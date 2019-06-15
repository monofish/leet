package tree;

/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * @author Wei
 * @since 2/22/16
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return (root == null) ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
