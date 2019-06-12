package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * @author Wei
 * @since 2/23/16
 */
public class MinimumDepthOfBinaryTree {
    // recursive solution
    public int minDepth(TreeNode root) {
        if (root == null) return 0; // if node is NULL
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;    // if node has 1 child or 2 children
    }

    // another recursive solution, pretty much the same
    public int minDepth0(TreeNode root) {
        if (root == null) return 0; // if node is NULL
        if (root.left == null || root.right == null) return minDepth(root.left) + minDepth(root.right) + 1; // if node has only 1 child
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;    // if node has both 2 children
    }

    // iterative solution
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        TreeNode node, lastNode = root;
        while (!queue.isEmpty()) {
            node = queue.remove();
            if (node.left == null && node.right == null) return level;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            if (node.equals(lastNode)) {    // use an auxiliary tree.TreeNode to track the last node of the present level
                lastNode = (node.right == null ? node.left : node.right);   // the last node of next level has to be the right child of the last node of current level if present
                level++;
            }
        }
        return level;
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
