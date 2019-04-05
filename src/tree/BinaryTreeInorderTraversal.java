package tree;

import java.util.*;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,3,2].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * @author Wei
 * @since 2/23/16
 */
public class BinaryTreeInorderTraversal {
    // iterative solution
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new LinkedList<>();

//        while(root != null || !stack.isEmpty()) {
//            while (root != null) {  // traverse to the bottom left
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            result.add(root.val);
//            root = root.right;
//        }


        while(root != null || !stack.isEmpty()) {
            if (root != null) {  // traverse to the bottom left
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }

    // Morris traversal with O(1) space and no stack
    public List<Integer> inorderTraversal0(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        TreeNode pre;   // always referring to the rightmost node in the current subtree
        while(root != null) {
            if (root.left == null) {        // if there is no left child...
                result.add(root.val);       // add current node into the list,
                root = root.right;          // then go right;
            } else {                        // if there is left child...
                pre = root.left;
                while (pre.right != null && pre.right != root)
                    pre = pre.right;        // find the rightmost node in the left subtree of current node

                if (pre.right == null) {    //  set current node as the right child of the rightmost node, then go left
                    pre.right = root;
                    root = root.left;
                } else {                    // if pre.right point to pre itself, (pre.right == pre)
                    pre.right = null;       // revert the right child as null to recover the original tree shape,
                    result.add(root.val);   // add current node into the list,
                    root = root.right;      // and go right
                }
            }
        }
        return result;
    }

}
