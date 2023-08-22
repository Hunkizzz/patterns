package test.avlt;

public class AVLTree {

    private Node root;

    public AVLTree() {
        this.root = null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    // Getters
    public Node getRoot() {
        return root;
    }

    // Private methods
    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            // data already exists
            return node;
        }

        // Update height of this ancestor node
        node.height = 1 + max(height(node.left), height(node.right));

        // Check if this node became unbalanced
        int balance = getBalance(node);

        // If this node becomes unbalanced, there are 4 cases
        // 1. Left Left Case
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }
        // 2. Right Right Case
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }
        // 3. Left Right Case
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // 4. Right Left Case
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private Node delete(Node node, int data) {
        if (node == null) {
            return null;
        }

        // Search for the data
        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {
            // Found the node to delete
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Find the inorder successor (smallest in the right subtree)
            Node temp = minValueNode(node.right);

            // Copy the inorder successor's data to this node
            node.data = temp.data;

            // Delete the inorder successor
            node.right = delete(node.right, temp.data);
        }

        // If the tree had only one node then return
        // Update height of this ancestor node
        node.height = 1 + max(height(node.left), height(node.right));

        // Check if this node became unbalanced
        int balance = getBalance(node);

        // If this node becomes unbalanced, there are 4 cases
        // 1. Left Left Case
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        // 2. Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        // 3. Left Right Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // 4. Right Left Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private int max(int a, int b) {
        return Math.max(a, b);
    }

    private Node rightRotate(Node node) {
        Node temp = node.left;
        Node temp2 = temp.right;

        // Perform rotation
        temp.right = node;
        node.left = temp2;

        // Update heights
        node.height = max(height(node.left), height(node.right)) + 1;
        temp.height = max(height(temp.left), height(temp.right)) + 1;

        // Return new root
        return temp;
    }

    private Node leftRotate(Node node) {
        Node temp = node.right;
        Node temp2 = temp.left;

        // Perform rotation
        temp.left = node;
        node.right = temp2;

        //  Update heights
        node.height = max(height(node.left), height(node.right)) + 1;
        temp.height = max(height(temp.left), height(temp.right)) + 1;

        // Return new root
        return temp;
    }

    // Return the height of the node
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Return the balance factor of the node
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Return the node with minimum value in the tree
    private Node minValueNode(Node node) {
        Node current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public void preorder() {
        preorder(root, 0);
    }

    private void preorder(Node node, int level) {
        if (node != null) {
            for (int i = 0; i < level; i++) {
                System.out.print("--");
            }
            System.out.println(node.data);
            preorder(node.left, level + 1);
            preorder(node.right, level + 1);
        }
    }

    public static void main(String[] args) {

        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
//        tree.insert(25);

    /* The constructed AVL Tree would be
             20
            /  \
          10   40
               / \
              30  50
    */
        System.out.println("Preorder traversal of constructed tree is : ");
        tree.preorder();

        tree.delete(20);
//        tree.delete(25);


    /* The AVL Tree after deletion of 30
            20
            /  \
           10  40
                 \
                 50
    */
        System.out.println("");
        System.out.println("Preorder traversal after deletion of 30 :");
        tree.preorder();
    }
}

// Node class
class Node {
    int data;
    Node left;
    Node right;
    int height;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}