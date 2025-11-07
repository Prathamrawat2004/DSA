package Trees.Questions;

import java.util.*;

public class BottomView {
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

    public class Pair {
        TreeNode node;
        int hd; // horizontal distance

        // constructor
        public Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<Integer> bottomView(TreeNode root) {
        // resultant list
        List<Integer> result = new ArrayList<>();

        // base condition
        if (root == null) {
            return result;
        }

        // applying level-order traversal
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        // creating a map to store the bottommost node
        // stores in sorted manner
        Map<Integer, Integer> map = new TreeMap<>();

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int hd = current.hd;

            // updating map to get the bottommost value stored along with it's corresponding
            // hd
            map.put(hd, node.val);

            // storing the children
            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }

        // filling the resultant array
        for (int val : map.values()) {
            result.add(val);
        }

        return result;
    }
}
