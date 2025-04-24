// Done

package Trees.DFSQues;
import java.util.*;
public class DFSusingStack {
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


    // for preorder traversal
    public void dfsStack(TreeNode node){
        if(node == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            TreeNode removed = stack.pop();
            System.out.print(removed.val + " ");

            // pushing the children
            if(removed.right != null){
                stack.push(removed.right);
            }

            if(removed.left != null){
                stack.push(removed.left);
            }
        }
    }
}
