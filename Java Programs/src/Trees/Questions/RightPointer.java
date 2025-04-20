// Done
package Trees.Questions;

// populating the next right pointers in each node
// Perfect Binary Tree i.e all nodes have two children and all leaf nodes at the same level
public class RightPointer {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }

    }

    public TreeNode connect(TreeNode root) {
        // base condition
        if (root == null) {
            return null;
        }

        TreeNode leftMost = root;

        while (leftMost.left != null) {
            TreeNode current = leftMost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }

        return root;
    }
}
