package Trees.DFSQues;

import java.util.*;

public class RootToNode {
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

    public List<List<Integer>> rootToLeafPath(TreeNode root) {
        // resultant list
        List<List<Integer>> result = new ArrayList<>();

        // base condition
        if (root == null) {
            return result;
        }

        List<Integer> currentPath = new ArrayList<>();

        // helper function
        helper(root, currentPath, result);

        return result;
    }

    // definition of helper function
    public void helper(TreeNode root, List<Integer> currentPath, List<List<Integer>> result) {
        // base condition
        if (root == null) {
            return;
        }

        // add current node
        currentPath.add(root.val);

        // leaf node
        if (root.left == null && root.right == null) {
            // add current path to the result
            result.add(currentPath);
        } else {
            // go to left & right
            helper(root.left, currentPath, result);
            helper(root.right, currentPath, result);
        }

        // backtrack to empty the currentPath arraylist
        currentPath.remove(currentPath.size() - 1);

    }

}
