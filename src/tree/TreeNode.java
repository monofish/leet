package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wei
 * @since 2/27/16
 */
// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode (int x) { val = x; }

    TreeNode (Integer[] serie) {
        this.val = serie[0];
        int size = serie.length;
        this.left = (1 < size && serie[1] != null) ? binaryTreeConstructor(1, serie) : null;
        this.right = (2 < size && serie[2] != null) ? binaryTreeConstructor(2, serie) : null;
    }

    private TreeNode binaryTreeConstructor (int i, Integer[] serie) {
        if (i >= serie.length)  throw new NullPointerException("--error--");
        TreeNode node = new TreeNode(serie[i]);
        int size = serie.length;
        node.left = (i * 2 + 1 < size && serie[i * 2 + 1] != null) ? binaryTreeConstructor(i * 2 + 1, serie) : null;
        node.right = (i * 2 + 2 < size && serie[i * 2 + 2] != null) ? binaryTreeConstructor(i * 2 + 2, serie) : null;
        return node;
    }

    // a generalized iterative solution for pre-order, in-order, and post-order ways
    public List<List<Integer>> traverse(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode visited = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                preorder.add(root.val); // pre-order
                root = root.left;
            } else {
                root = stack.peek();

                if (root.right != visited || root.right == null) {
                    inorder.add(root.val);  // in-order
                }

                if (root.right == visited || root.right == null) {
                    stack.pop();
                    visited = root;
                    postorder.add(root.val);    // post-order
                    root = null;
                } else root = root.right;
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(preorder);
        result.add(inorder);
        result.add(postorder);
        return result;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,2,3,4,5,6,7};

        TreeNode root = new TreeNode(nums);
        List<List<Integer>> results = root.traverse(root);

        System.out.println("Pre-order: " + new BinaryTreePreorderTraversal().preorderTraversal(root).equals(results.get(0)));
        System.out.println(results.get(0));
        System.out.println("In-order: " + new BinaryTreeInorderTraversal().inorderTraversal(root).equals(results.get(1)));
        System.out.println(results.get(1));
        System.out.println("Post-order: " + new BinaryTreePostorderTraversal().postorderTraversal(root).equals(results.get(2)));
        System.out.println(results.get(2));
        System.out.println(new BinaryTreePostorderTraversal().postorderTraversal0(root));

    }
}
