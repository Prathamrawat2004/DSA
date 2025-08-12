package Trees;
// revisions = 1
import java.util.Scanner;

public class BinaryTree {

    public BinaryTree() {

    }

    // Node class
    private static class Node {

        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    // insert elements
    public void populate(Scanner scanner) {
        System.out.println("Enter the root node: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populater(scanner, root); // helper function to create binary tree
    }

    // helper function to create binary tree
    private void populater(Scanner scanner, Node node) {
        System.out.println("Do you want to enter left of" + node.value);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value of the left of" + node.left);
            int value = scanner.nextInt();
            node.left = new Node(value);
            // further create tree
            populater(scanner, node.left);
        }

        System.out.println("Do you want to enter right of" + node.value);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value of the left of" + node.right);
            int value = scanner.nextInt();
            node.right = new Node(value);
            // further create tree
            populater(scanner, node.right);
        }

    }

    // function to display the tree
    public void display(){
        displayer(root, "");
    }

    private void displayer(Node node, String indent){
        // base condition
        if(node == null){
            return;
        }

        // current node
        System.out.println(indent + node.value);

        // recursive calls to left and right
        displayer(node.left, indent + "\t");
        displayer(node.right, indent + "\t");
    }


}
