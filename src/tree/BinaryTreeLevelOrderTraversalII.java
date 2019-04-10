package tree;

import java.util.List;

/**
 * Given a binary tree, return the <em>bottom-up</em> level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:<br>
 * Given binary tree {3,9,20,#,#,15,7},<br>
 *   3<br>
 *  / \<br>
 * 9  20<br>
 *   /  \<br>
 * 15   7<br>
 * <p>
 * return its bottom-up level order traversal as:<br>
 * [<br>
 *  [15,7],<br>
 *  [9,20],<br>
 *  [3]<br>
 * ]<br>
 *
 * @author Wei
 * @since 2/22/16
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // just use ArrayList.add(0, list) or LinkedList.addFirst(list)
        return null;
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
