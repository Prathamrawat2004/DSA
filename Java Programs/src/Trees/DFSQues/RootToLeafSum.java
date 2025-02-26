package Trees.DFSQues;

public class RootToLeafSum {
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

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int sum) {
        // base condition
        if (root == null) {
            return 0;
        }

        sum = sum * 10 + root.val;

        // but when at leaf node
        if (root.left == null && root.right == null) {
            return sum;
        }

        return helper(root.left, sum) + helper(root.right, sum);

    }
}
