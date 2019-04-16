package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [3,2,1].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * @author Wei
 * @since 2/23/16
 */
public class BinaryTreePostorderTraversal {
    // Morris
    public List<Integer> postorderTraversalMorris(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode pre;
//        while (root != null) {
//            if (root.left != null) {
//                pre = root.left;
//                while (pre.right != null && pre.right != root) pre = pre.right;
//                if(pre.right == null) {
//                    pre.right = root.right;
//                    root = root.left;
//
//                } else {
//                    pre.right = null;
//                    root = root.right;
//                    result.add(root.val);
//                }
//            } else {
//                result.add(root.val);
//                root = root.right;
//            }
//        }
        return result;
    }

    // iterative solution
    public List<Integer> postorderTraversal0(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode visited = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.peek();
                if (root.right == visited || root.right == null) {
                    result.add(root.val);
                    stack.pop();
                    visited = root;
                    root = null;
                } else root = root.right;
            }
        }
        return result;
    }


    // classic recursive solution
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) postorderTraversal(root, list);
        return list;
    }

    private void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root.left != null) postorderTraversal(root.left, list);
        if (root.right != null) postorderTraversal(root.right, list);
        list.add(root.val);
    }

}
