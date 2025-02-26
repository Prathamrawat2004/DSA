package Trees.Questions;

import java.util.LinkedList;
import java.util.Queue;

public class LvlSuccessor {
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


    public TreeNode findSuccessor(TreeNode node, int key){
        // base condition
        if(node == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            TreeNode currNode = queue.poll();

            // adding its children
            if (currNode.left != null) {
                queue.offer(currNode.left);
            }
            if (currNode.right != null) {
                queue.offer(currNode.right);

            }

            if(currNode.val == key){
                break;
            }
        }

        return queue.peek();
    }
}
