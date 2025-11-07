package Trees.MorrisTraversal;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// time-complexity - O(N)
// space-complexity - O(1)

public class InOrder {
    public static void morrisInorder(Node root) {
        Node current = root;

        while (current != null) {

            if (current.left == null) {

                System.out.println(current.data + " ");
                current = current.right;

            } else {

                // find the inorder predecessor
                Node predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // Make connection (temporary link)
                if (predecessor.right == null) {

                    predecessor.right = current;
                    current = current.left;

                } else {

                    // remove thread and print current
                    predecessor.right = null;
                    System.out.println(current.data + " ");
                    current = current.right;
                }

            }
        }
    }
}
