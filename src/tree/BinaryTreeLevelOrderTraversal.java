package tree;

import java.util.*;

/**
 * Given a binary tree, return the <em>level order</em> traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:<br>
 * Given binary tree {3,9,20,#,#,15,7},<br>
 *   3<br>
 *  / \<br>
 * 9  20<br>
 *   /  \<br>
 *  15   7<br>
 * <p>
 * return its level order traversal as:<br>
 * [<br>
 *  [3],<br>
 *  [9,20],<br>
 *  [15,7]<br>
 * ]<br>
 *
 * @author Wei
 * @since 2/22/16
 */
public class BinaryTreeLevelOrderTraversal {
    // recursive solution
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> treeList = new ArrayList<List<Integer>>();
        levelOrder(root, treeList, 0);
        return treeList;
    }

    private void levelOrder(TreeNode root, List<List<Integer>> treeList, int ht) {
        if (root == null) return;
        if (treeList.size() < ht + 1) treeList.add(new ArrayList<>());
        treeList.get(ht).add(root.val);
        levelOrder(root.left, treeList, ht + 1);
        levelOrder(root.right, treeList, ht + 1);
    }

    // iterative solution
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> treeList = new ArrayList<>();
        if (root == null) return treeList;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int level = 0;
        TreeNode node;
        int count = 1;
        int countChildren = 0;
        while (!queue.isEmpty()) {
            node = queue.remove();
            if (treeList.size() < level + 1) treeList.add(new ArrayList<>());
            treeList.get(level).add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                countChildren++;
            }
            if (node.right != null) {
                queue.add(node.right);
                countChildren++;
            }

            if (--count == 0) { // if all elements in the present level are exhausted, make next level the present level and clear the children counter
                level++;
                count = countChildren;
                countChildren = 0;
            }
        }
        return treeList;
    }
}
