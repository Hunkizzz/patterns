package test;

import java.util.List;

public class main {
//    public static void main(String[] args) {
//        int i = 0;
//        int j = 0;
//
//        boolean t = true;
//        boolean r;
//        r = (t & (0 < (i += 2)));
//        r = (t && (0 < (i += 2)));
//        r = (t | (0 < (j += 1)));
//        r = (t || (0 < (j += 2)));
//        System.out.println(i);
//        System.out.println(j);
//
//    }

//
//    public static void main(String[] args) {
//        List<List<Integer>> list = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));
//
////        List<Integer> finList =
//        list.stream().flatMap(List::stream).reduce(Integer::sum).
//                ifPresent(System.out::println);
//
////        finList.forEach(System.out::println);
//    }


//    public static void main(String[] args) {
//        int a = 10, b = 5, c = 1, result;
//        result = a-++c-++b;
//
//        System.out.println(result);
//    }

    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        String c = new String("a");

        System.out.println(a==b);
        System.out.println(b==c);
        c = c.intern();
        System.out.println(b==c);
    }
    static void addTwo(int i) {
        i += 2;
    }

//    int size;
//    private Node first;
//    private Node last;
//
//    private static class Node {
//        int element;
//        Node next;
//        Node previous;
//
//        public Node(int element) {
//            this.element = element;
//        }
//    }
//
//    public boolean remove(int index) {
//        if (index < 0 || index > size - 1) {
//            throw new IllegalArgumentException();
//        }
//        if (index == 0) {
//            first = first.next;
//        } else {
//            Node node = findNodeBeforeByIndex(index);
//            Node tmp = findByIndex(index);
//            node.next = tmp.next;
//        }
//        size--;
//        return false;
//    }
//
//    public boolean removeElement(int element) {
//
//        if (size == 0) {
//            return false;
//        } else if (size == 1) {
//            first = null;
//            last = null;
//            size = 0;
//            return true;
//        }
//
//        Node nodeBefore = findNodeBefore(element);
//
//        if (nodeBefore.element == 0) {
//            first = first.next;
//            size--;
//            return true;
//        } else if (nodeBefore != null) {
//            if (last.element == element) {
//                nodeBefore.next = null;
//                last = nodeBefore;
//            } else {
//                nodeBefore.next = nodeBefore.next.next;
//            }
//            size--;
//            return true;
//        }
//        return false;
//    }
//
//    private Node findByIndex(int index) {
//        if (index < 0 || index > size - 1) {
//            throw new IndexOutOfBoundsException();
//        }
//        int tmpIndex = 0;
//        if (first == null) {
//            throw new IndexOutOfBoundsException();
//        }
//
//        if (index == 0) {
//            return first;
//        }
//
//        Node node = first;
//        while (node.next != null) {
//            node = node.next;
//            tmpIndex++;
//            if (tmpIndex == index) {
//                return node;
//            }
//        }
//        throw new IndexOutOfBoundsException();
//    }
//
//    private Node findNodeBefore(int value) {
//        if (first.element == value) {
//            return new Node();
//        }
//
//        Node node = first;
//        while (node.next != null) {
//            if (node.next.element == value) {
//                return node;
//            }
//            node = node.next;
//        }
//        return null;
//    }
//
//    private Node findNodeBeforeByIndex(int index) {
//        if (index <= 0 || index > size - 1) {
//            return null;
//        }
//
//        int count = 0;
//        Node node = first;
//        while (node.next != null) {
//            if (count == index - 1) {
//                return node;
//            }
//            count++;
//            node = node.next;
//        }
//        return null;
//    }
}