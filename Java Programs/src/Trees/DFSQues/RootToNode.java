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

    // given the node present in the tree
    // find the path from root -> node
    // NOTE: path is always present & node is always present
    public List<Integer> rootToNode(TreeNode root, int x) {
        // resultant list
        List<Integer> result = new ArrayList<>();

        // base condition
        if (root == null) {
            // empty list
            return result;
        }

        // helper function to generate the path
        getPath(root, result, x);

        return result;
    }

    // definition of helper function
    public boolean getPath(TreeNode node, List<Integer> result, int x) {
        // base condition
        if (node == null) {
            return false;
        }

        // adding current node
        result.add(node.val);

        if (node.val == x) {
            return true;
        }

        // go check left & right
        boolean left = getPath(node.left, result, x);
        boolean right = getPath(node.right, result, x);

        if (left || right) {
            return true;
        }

        // removing the last added node
        result.remove(result.size() - 1);
        return false;
    }

}
