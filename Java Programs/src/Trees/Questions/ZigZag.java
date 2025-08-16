// Done
package Trees.Questions;
// revisions = 1
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZag {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // base condition
        if (root == null) {
            return result;
        }

        // using deque
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        // maintaining a flag for reverse order
        boolean reverse = false;

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                // two cases
                if (!reverse) {
                    // normal order = remove first & add last
                    TreeNode currentnode = deque.pollFirst();
                    currentLevel.add(currentnode.val);

                    // adding the children
                    if (currentnode.left != null) {
                        deque.addLast(currentnode.left);

                    }
                    if (currentnode.right != null) {
                        deque.addLast(currentnode.right);

                    }

                } else {
                    // reverse order = remove last & add first
                    TreeNode currentnode = deque.removeLast();
                    currentLevel.add(currentnode.val);
                    
                    // adding the children
                    if (currentnode.right != null) {
                        deque.addFirst(currentnode.right);

                    }
                    
                    if (currentnode.left != null) {
                        deque.addFirst(currentnode.left);

                    }

                }

                
            }
            reverse = !reverse;
            result.add(currentLevel);

        }

        return result;

    }
}
