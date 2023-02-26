package test.MyLinkedList;

public class MyLinkedList2<T> {
    Node<T> head;
    Node<T> tail;

    public void add(T element) {
        if (element == null)
            return;
        Node<T> newNode = new Node(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void delete(T element) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.value.equals(element)) {
                delete(temp);
                return;
            } else
                temp = temp.next;
        }
    }

    private void delete(Node<T> temp) {
        Node<T> prev = temp.prev;
        Node<T> next = temp.next;

        if (prev == null)
            head = next;
        else {
            temp.prev.next = next;
            temp.prev = null;
        }

        if (temp.next == null) {
            tail = prev;
        } else {
            temp.next.prev = prev;
            temp.next = null;
        }
        temp.value = null;
    }


    public static void main(String[] args) {
        MyLinkedList2<Long> list2 = new MyLinkedList2();

        list2.add(1l);
        list2.add(2l);
        list2.add(3l);
        list2.add(4l);

        list2.delete(1l);
        list2.delete(2l);
        list2.delete(3l);

        System.out.println(list2);

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
