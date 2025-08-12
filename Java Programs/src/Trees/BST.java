package Trees;
// revisions = 1
public class BST {
    public class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    // root node
    private Node root;

    // constructor
    public BST() {

    }

    // getting the height of node
    public int height(Node node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        displayer(root, "Root Node: ");
    }

    private void displayer(Node node, String details) {
        // base condition
        if (node == null) {
            return;
        }
        System.out.println(details + node.getValue());

        // displaying the left and right nodes
        displayer(node.left, "Left child of " + node.getValue() + " : ");
        displayer(node.right, "Right child of " + node.getValue() + " : ");
    }

    // inserting node
    public Node insert(int value) {
        return inserter(value, root);
    }

    private Node inserter(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = inserter(value, node.left);
        }

        if (value > node.value) {
            node.right = inserter(value, node.right);
        }

        // by default height for leaf node will be 0
        node.height = Math.max(height(node.left), height(node.right)) + 1; // as just added one more node

        return node;
    }

    // checking if balanced or not
    public boolean balanced() {
        return balancer(root);
    }

    // helper function to check if the tree is balanced or not
    private boolean balancer(Node node) {
        // no tree or no more tree left to traverse
        if (node == null) {
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balancer(node.left) && balancer(node.right);

    }

    // inserting multiple items
    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }

    // inserting multiple elements (sorted array)
    public void populateSorted(int[] nums) {
        populaterSorter(nums, 0, nums.length);
    }

    // helper function
    private void populaterSorter(int[] nums, int start, int end) {
        // base condition
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;

        // insert the middle element
        insert(nums[mid]);

        // call for left array and right array
        populaterSorter(nums, start, mid);
        populaterSorter(nums, mid + 1, end);
    }

    // TRAVERSAL ALGORITHMS(DFS)
    // 1. Pre-order traversal
    // private void preOrder(Node node) {
    //     if (node == null) {
    //         return;
    //     }
    //     System.out.println(node.value + " ");

    //     // call the left
    //     preOrder(node.left);

    //     // call the right
    //     preOrder(node.right);
    // }

    // 2. In-order traversal
    // private void inOrder(Node node) {
    //     if (node == null) {
    //         return;
    //     }
    //     // call the left
    //     inOrder(node.left);
        
    //     // print the node
    //     System.out.println(node.value + " ");

    //     // call the right
    //     inOrder(node.right);
    // }
    
    // 3. Post-order traversal
    // private void postOrder(Node node) {
    //     if (node == null) {
    //         return;
    //     }
    //     // call the left
    //     inOrder(node.left);
        
    //     // call the right
    //     inOrder(node.right);
        
    //     // print the node
    //     System.out.println(node.value + " ");

    // }

    

}
