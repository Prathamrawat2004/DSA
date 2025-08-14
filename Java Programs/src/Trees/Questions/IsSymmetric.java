// Done
// revisions = 1
package Trees.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Trees.Questions.BFS.TreeNode;

public class IsSymmetric {
    // brute force approach
    public boolean isSymmetric1(TreeNode root) {
        // base condition
        if (root == null) {
            return true;
        }

        // creating the left and right list
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        // storing the left subtree values
        preOrder(root.left, leftList);

        // mirroring the right subtree
        mirrorTree(root.right);

        // storing the right subtree values
        preOrder(root.right, rightList);

        return leftList.equals(rightList);

    }

    // helper function to perform preOrder traversal
    public void preOrder(TreeNode node, ArrayList<Integer> list) {
        // if the node is null, store it
        if (node == null) {
            list.add(null);
            return;
        }
        // store the current node's value
        list.add(node.val);

        // go left and right
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    // function to create a mirror tree
    public void mirrorTree(TreeNode node) {
        // swapping the nodes
        if (node == null) {
            return;
        }

        // swapping the current left and right nodes
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        // go swap left and right subtree
        mirrorTree(node.left);
        mirrorTree(node.right);
    }

    // optimized approach
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        // not add root but its children to start
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            // adding nodes
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);

        }

        return true;

    }
}
