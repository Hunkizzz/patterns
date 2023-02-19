package test.bt;

public class BinaryTree {
    Node root;

    public BinaryTree(int key) {
        root = new Node(key);
    }

    public BinaryTree() {
        root = null;
    }

//This method mainly calls insertRec()

    void insert(int key) {
        root = insertRec(root, key);
    } /* A recursive function to insert a new key in Binary Tree */

    Node insertRec(Node root, int key) { /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }
        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key); /* return the (unchanged) node pointer */
        return root;
    }

    //This method mainly calls InorderRec()

    void inorder() {
        inorderRec(root);
    }

    //A utility function to do inorder traversal of BST

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

//        Driver Program
//        to test
//        above functions

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        /* Let us create following BST
         50
         / \
        30 70
        / \ / \
      20 40 60 80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        //print inorder traversal of the BST
        tree.inorder();
    }
} // A class to represent a node in Binary Tree

class Node {
    int key;
    Node left;
    Node right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}