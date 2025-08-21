// Done
// revisions = 1
package Trees.DFSQues;

import java.util.LinkedList;
import java.util.*;

public class Flatten {
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

    // optimized approach
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                // finding the rightmost empty element
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }

                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }
    }

    // brute force
    public void Flatten(TreeNode root) {
        // base condition
        if (root == null) {
            return;
        }

        // implementing queue for dfs
        Queue<TreeNode> queue = new LinkedList<>();

        // helper function
        dfs(root, queue);

        // creating a linkedlist
        TreeNode prev = queue.poll();
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            prev.left = null;
            prev.right = curr;
            prev = curr;
        }

    }

    // helper function definition
    public void dfs(TreeNode node, Queue<TreeNode> queue) {
        // base condition
        if (node == null) {
            return;
        }

        // add current node
        queue.offer(node);

        // go to left
        dfs(node.left, queue);

        // go to right
        dfs(node.right, queue);
    }
}
