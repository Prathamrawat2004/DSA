package Trees.DFSQues;

import java.util.*;

public class BoundaryTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public List<Integer> boundaryNodes(TreeNode root) {
        // resultant list
        List<Integer> result = new ArrayList<>();

        // base condition
        if (root == null) {
            return result; // empty list
        }

        // adding the root (if not leaf)
        if (!isLeaf(root)) {
            result.add(root.val);
        }

        // adding the left boundary nodes
        addLeftBoundary(root.left, result);

        // adding the leaf nodes
        addLeaves(root, result);

        // adding the right boundary nodes
        addRightBoundary(root.right, result);

        return result;
    }

    // helper function to check if node is leaf
    public static boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }

    // helper function to add left boundary nodes
    public static void addLeftBoundary(TreeNode node, List<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) {
                result.add(node.val);
            }

            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    // helper function to add leaf nodes
    public static void addLeaves(TreeNode node, List<Integer> result) {
        if (isLeaf(node)) {
            result.add(node.val);
            return;
        }
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    // helper function to add left boundary nodes
    public static void addRightBoundary(TreeNode node, List<Integer> result) {
        Stack<TreeNode> stack = new Stack<>();

        while (node != null) {
            if (!isLeaf(node)) {
                stack.push(node);
            }

            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        // adding right boundary elements
        while (!stack.isEmpty()) {
            result.add(stack.pop().val);
        }
    }
}
