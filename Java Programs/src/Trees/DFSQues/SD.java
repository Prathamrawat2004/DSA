package Trees.DFSQues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SD {
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

    public List<String> serialize(TreeNode node) {
        List<String> list = new ArrayList<>();
        helper(node, list);
        return list;
    }

    public void helper(TreeNode node, List<String> list) {
        // base condition
        if (node == null) {
            list.add("null");
            return;
        }

        list.add(String.valueOf(node.val));

        // calling left and right nodes
        helper(node.left, list);
        helper(node.right, list);
    }

    public TreeNode deserialize(List<String> list) {
        Collections.reverse(list); // avoid shifting 
        TreeNode node = helper2(list);
        return node;
    }

    TreeNode helper2(List<String> list) {
        String val = list.remove(list.size() - 1);

        // if the string is null
        if (val.charAt(0) == 'n') {
            return null;
        }

        // create the node and call left and right
        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = helper2(list);
        node.right = helper2(list);

        return node;

    }
}
