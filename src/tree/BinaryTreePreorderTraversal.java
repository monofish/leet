package tree;

import java.util.*;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,2,3].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * @author Wei
 * @since 2/23/16
 */
public class BinaryTreePreorderTraversal {
    //  Morris traversal
    public List<Integer> preorderTraversalMorris(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode pre;
        while (root != null) {
            if (root.left == null) {
                result.add(root.val);
                root = root.right;
            } else {
                pre = root.left;
                while (pre.right != null && pre.right != root) pre = pre.right;

                if (pre.right == null) {
                    pre.right = root;
                    result.add(root.val);   // the only statement different to in-order implementation
                    root = root.left;
                } else {
                    pre.right = null;
                    root = root.right;
                }
            }
        }
        return result;
    }

    // iterative solution using a stack only for right children
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> rightStack = new ArrayDeque<>();

        while (root != null) {  // if no left child and empty stack for right children
            list.add(root.val);
            if (root.right != null) rightStack.push(root.right);
            root = root.left;
            if (root == null && !rightStack.isEmpty()) root = rightStack.pop();
        }

        return list;
    }

    // another iterative solution, slower
    public List<Integer> preorderTraversal0(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> stack = new LinkedList<>();

        // diff start
        stack.push(root);   // initial condition
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.right != null) stack.push(root.right); // if children are not null, push them into the stack
            if (root.left != null) stack.push(root.left);
        }
        // diff end

        return list;
    }

    // another iterative solution, slower
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> stack = new LinkedList<>();

        // diff start
        stack.push(root);
        while (!stack.isEmpty()) {  // push children into the stack even if they are null
            root = stack.pop();
            if (root != null) {     // then add into the result list if the node is not null
                list.add(root.val);
                stack.push(root.right);
                stack.push(root.left);
            }
        }
        // diff end

        return list;
    }


    // classic recursive solution
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) preorderTraversal(root, list);
        return list;
    }

    private void preorderTraversal(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if (root.left != null) preorderTraversal(root.left, list);
        if (root.right != null) preorderTraversal(root.right, list);
    }

}
