package Trees.DFSQues;

public class KthSmallest {
    public class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public int KthSmallestElement(TreeNode root, int k) {
        return helper(root, k).val;
    }

    int count = 0;

    public TreeNode helper(TreeNode root, int k) {
        // base condition
        if (root == null) {
            return null;
        }

        // go towards left as we have to find the smallest value so in-order
        TreeNode left = helper(root.left, k);

        if (left != null) {
            return left;
        }

        count++;

        if (count == k) {
            return root;
        }

        return helper(root.right, k);

    }
}
