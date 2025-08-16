// Done
// revisions = 1
package Trees.DFSQues;

public class Diameter {
    public class TreeNode {
        private int value;
        // private int height;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter - 1;
    }

    public int height(TreeNode node) {
        // base condition
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(dia, diameter);

        return (Math.max(leftHeight, rightHeight) + 1);
    }
}
