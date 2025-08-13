// Done
// revisions = 1
package Trees.Questions;

import java.util.LinkedList;
import java.util.Queue;

import Trees.Questions.BFS.TreeNode;

public class Cousin {

    // brute force solution
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return ((level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy)));
    }

    TreeNode findNode(TreeNode node, int x) {
        if (node == null) {
            return node;
        }

        if (node.val == x) {
            return node;
        }

        TreeNode n = findNode(node.left, x);
        if (n != null) {
            return n;
        }

        return findNode(node.right, x);
    }

    Boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) {
            return false;
        }

        return ((node.left == x && node.right == y) || (node.left == y && node.right == x)
                || isSibling(node.left, x, y) || isSibling(node.right, x, y));
    }

    int level(TreeNode node, TreeNode x, int lev) {
        if (node == null) {
            return 0;
        }

        if (node == x) {
            return lev;
        }

        // go left
        int left = level(node.left, x, lev + 1);
        if (left != 0) {
            return left;
        }

        // go right
        return level(node.right, x, lev + 1);
    }

    // optimized solution
    public boolean isCousins2(TreeNode root, int x, int y) {
        // base condition
        if (root == null) {
            return false;
        }

        // applying bfs algorithm
        // implementing queue to store the nodes at each level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            // checking if the currentlevel nodes are parent of required children or not
            TreeNode parentX = null;
            TreeNode parentY = null;

            for (int i = 0; i < size; i++) {
                // getting the current node
                TreeNode currNode = queue.poll();

                // checking for left and right nodes
                if (currNode.left != null) {
                    if (currNode.left.val == x)
                        parentX = currNode;
                    if (currNode.left.val == y)
                        parentY = currNode;
                }

                if (currNode.right != null) {
                    if (currNode.right.val == x)
                        parentX = currNode;
                    if (currNode.right.val == y)
                        parentY = currNode;
                }
            }

            // after the current level
            if (parentX != null && parentY != null) {
                return parentX != parentY; // condition for cousins
            }

            // only one parent found at current level
            if (parentX != null || parentY != null) {
                return false;
            }
        }

        return false;
    }
}
