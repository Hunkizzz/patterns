package test.linkedlist;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public void add(T value) {
        final Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }


    public void delete(T value) {
        Node<T> curNode = head;
        if (curNode == null)
            return;

        while (curNode != null) {
            if (value == null) {
                if (curNode.value == null) {
                    delete(curNode);
                }
            } else {
                if (curNode.value.equals(value)) {
                    delete(curNode);
                }
            }
            curNode = curNode.next;
        }
    }

    private void delete(Node<T> node) {
        final Node<T> next = node.next;
        final Node<T> prev = node.prev;

        if (node.prev == null) {
            head = next;
        } else {
            node.prev.next = node.next;
            node.prev = null;
        }

        if (node.next == null) {
            tail = prev;
        } else {
            node.next.prev = prev;
            node.next = null;
        }
        node.value = null;
    }

    public void show() {
        Node currentNode = head;
        if (currentNode == null) {
            System.out.println("Linked list is empty");
        } else {
            while (currentNode != null) {
                System.out.print(currentNode.value + " ");
                currentNode = currentNode.next;
            }
        }
    }


    public static void main(String[] args) {
        MyLinkedList<Long> longMyLinkedList = new MyLinkedList<>();

        longMyLinkedList.add(1l);
        longMyLinkedList.add(2l);
        longMyLinkedList.add(3l);
        longMyLinkedList.add(4l);
    }

    static class Node<T> {
        Node<T> prev;
        Node<T> next;

        T value;

        public Node(T value) {
            this.value = value;
        }
    }
}