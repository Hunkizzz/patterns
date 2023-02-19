package test.rbt;

class Node {
    int data;
    boolean color;
    Node left, right, parent;

    public Node(int data) {
        this.data = data;
        left = right = parent = null;
        // new node will be red by default
        this.color = true;
    }
}

public class RedBlackTree {

    private Node root;

    public RedBlackTree() {
        root = null;
    }

    // search a node in the tree
    public Node search(int data) {
        return searchNode(root, data);
    }

    private Node searchNode(Node node, int data) {
        if (node == null || node.data == data) {
            return node;
        }

        if (node.data > data) {
            return searchNode(node.left, data);
        } else {
            return searchNode(node.right, data);
        }
    }

    // insert a new node with data
    public void insert(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent = null;
            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        newNode.parent = parent;
                        break;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        newNode.parent = parent;
                        break;
                    }
                }
            }
        }

        // fix red-black tree properties
        fixInsert(newNode);
    }

    // fix the red-black tree after insertion
    private void fixInsert(Node node) {
        Node parent = parentOf(node);
        Node grandParent = parentOf(parent);

        // case A: inserted node is root
        if (parent == null) {
            node.color = false;
            return;
        }

        // case B: parent is black
        if (!parent.color) {
            return;
        }

        // case C: parent and uncle are red
        Node uncle = siblingOf(parent);
        if ((uncle != null) && (uncle.color)) {
            parent.color = false;
            uncle.color = false;
            grandParent.color = true;
            fixInsert(grandParent);
            return;
        }

        // case D: parent is red, uncle is black, and node is right child
        if (parent.right == node) {
            rotateLeft(parent);
            Node temp = parent;
            parent = node;
            node = temp;
        }

        // case E: parent is red, uncle is black, and node is left child
        rotateRight(grandParent);
        parent.color = false;
        grandParent.color = true;
    }

    // rotate left at node x
    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // rotate right at node x
    private void rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // return the parent of a node
    private Node parentOf(Node node) {
        if (node != null) {
            return node.parent;
        }
        return null;
    }

    // return the sibling of a node
    private Node siblingOf(Node node) {
        if (node == null || node.parent == null) {
            return null;
        }

        if (node == node.parent.left) {
            return node.parent.right;
        } else {
            return node.parent.left;
        }
    }

    public void printTree() {
        int height = height(root);

        for (int i = 1; i <= height; i++) {
            printTreeLevel(root, i);
            System.out.println();
        }
        System.out.println();
    }

    private void printTreeLevel(Node node, int level) {
        if (node == null) {
            return;
        }

        if (level == 1) {
            System.out.print(node.data + " ");
        } else if (level > 1) {
            if (node.left != null) {
                System.out.print("/");
            } else {
                System.out.print(" ");
            }

            printTreeLevel(node.left, level - 1);

            if (node.right != null) {
                System.out.print("\\");
            } else {
                System.out.print(" ");
            }

            printTreeLevel(node.right, level - 1);
        }
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);

            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

// insert some nodes
        tree.insert(7);
        tree.insert(3);
        tree.insert(18);
        tree.insert(10);
        tree.insert(22);
        tree.insert(8);
        tree.insert(11);
        tree.insert(26);

// search node with value 11
        Node result = tree.search(11);
        if (result != null) {
            System.out.println("Found node: " + result.data);
        } else {
            System.out.println("Node not found!");
        }
        tree.printTree();
    }
}

