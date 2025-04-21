// Done

package Trees.Questions;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Trees.Questions.BFS.TreeNode;

public class RightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // base condition
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Track the size of the current level

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();

                // If it's the last node in the level, add it to the result
                if (i == levelSize - 1) {
                    result.add(currNode.val);
                }

                // Add left and right children (right first to ensure rightmost nodes are
                // processed first)
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
        }

        return result;
    }
}
