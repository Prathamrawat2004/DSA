// Done

package Trees.DFSQues;

import Trees.Questions.BFS.TreeNode;

public class InvertBTree {

    public TreeNode invertTree(TreeNode root) {
        // base condition
        if (root == null) {
            return root;
        }

        // getting the left and right nodes
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);

        // swapping the nodes if not null
        if (leftNode != null && rightNode != null) {
            swapSubtree(root);
        }

        return root;
    }

    public void swapSubtree(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
