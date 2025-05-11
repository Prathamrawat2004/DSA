// Done
// Rev count = 2
package Trees.DFSQues;

public class MaxPathSum {
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

    int maxSum = Integer.MIN_VALUE; // initializing a global variable

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    public int helper(TreeNode node) {
        // base condition
        if (node == null) {
            return 0;
        }

        // finding the left and right values
        int left = helper(node.left);
        int right = helper(node.right);

        // ignoring the left and right sums if they are negative
        left = Math.max(0, left);
        right = Math.max(0, right);

        int pathSum = left + right + node.val;
        maxSum = Math.max(pathSum, maxSum);

        return Math.max(left, right) + node.val;

    }
}
