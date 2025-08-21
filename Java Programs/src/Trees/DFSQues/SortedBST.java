// revisions = 1
package Trees.DFSQues;

public class SortedBST {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length);
    }

    // helper function
    private TreeNode constructBST(int[] nums, int start, int end) {
        // base condition
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // recursively create the left and right subtrees
        root.left = constructBST(nums, start, mid - 1);
        root.right = constructBST(nums, mid + 1, end);

        return root;
    }

}
