package Trees.SegmentTree;

// time-complexity: O(logN)

public class Algorithm {
    private static class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    // root node
    Node root;

    // constructor
    public Algorithm(int[] arr) {
        // creating a tree using this array
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    // helper function to create tree
    private Node constructTree(int[] arr, int start, int end) {
        // base condition or leaf node
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        // creating a new node with the range we have
        Node node = new Node(start, end);

        int mid = (start + end) / 2;

        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);

        node.data = node.left.data + node.right.data;

        return node;
    }

    // helper function to display tree
    public void display() {
        displayer(this.root);
    }

    private void displayer(Node node) {
        String str = "";

        // left child
        if (node.left != null) {
            str = str + "Interval = [" + node.left.startInterval + "-" + node.left.endInterval + "] and data: "
                    + node.left.data + " => ";
        } else {
            str = str + "No left child";
        }

        // current node
        str = str + "Interval = [" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " => ";

        // right child
        if (node.right != null) {
            str = str + "Interval = [" + node.right.startInterval + "-" + node.right.endInterval + "] and data: "
                    + node.left.data + " => ";
        } else {
            str = str + "No right child";
        }

        System.out.println(str);

        // call recursion
        if (node.left != null) {
            displayer(node.left);
        }

        if (node.right != null) {
            displayer(node.right);
        }

    }

    // query solving
    public int query(int queryStartIndex, int queryEndIndex) {
        return querySolver(this.root, queryStartIndex, queryEndIndex);
    }

    private int querySolver(Node node, int qsi, int qei) {
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            // node is completely lying inside query
            return node.data;
        } else if (node.startInterval > qei || node.endInterval < qsi) {
            // completely outside
            return 0;
        } else {
            // overlapping case
            // call left and right recursion
            return querySolver(node.left, qsi, qei) + querySolver(node.right, qsi, qei);
        }
    }

    // updating the tree
    public void update(int index, int value) {
        this.root.data = updater(this.root, index, value);
    }

    private int updater(Node node, int index, int value) {
        // check if the node lies inside the interval
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            } else {
                int leftAns = updater(node.left, index, value);
                int rightAns = updater(node.right, index, value);

                node.data = leftAns + rightAns;
                return node.data;
            }
        }

        return node.data;
    }
}
