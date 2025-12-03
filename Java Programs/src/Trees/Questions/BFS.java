// Done
// revisions = 2
package Trees.Questions;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Level Order Traversal
public class BFS {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // base condition
        if (root == null) {
            return result;
        }

        // queue to store the children
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // currentlevel list
            List<Integer> currentlevel = new ArrayList<>(levelSize);

            // adding the current level nodes and their respective children
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentlevel.add(currentNode.val);

                // adding its children
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);

                }
            }

            // adding the currentLevel list
            result.add(currentlevel);

        }

        return result;

    }

}
