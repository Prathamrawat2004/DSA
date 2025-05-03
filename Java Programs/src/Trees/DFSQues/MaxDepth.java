// Done

package Trees.DFSQues;

import Trees.Questions.BFS.TreeNode;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        // base condition
        if (root == null) {
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return ((Math.max(leftHeight, rightHeight)) + 1);
    }
}
