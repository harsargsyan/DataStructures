package linkedlist;

public class Node {
    int data;
    Node next;

    public Node(int d) {
        data = d;
    }

    public void printList(MyLinkedList list) {
        Node currNode = list.head;

        if (currNode != null) {
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        }
    }

    public MyLinkedList insertLast(MyLinkedList list, int data) {
        Node newNode = new Node(data);

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    public MyLinkedList insertFirst(MyLinkedList list, int data) {
        Node newNode = new Node(data);

        if (list.head != null) {
            newNode.next = list.head;
        }
        list.head = newNode;
        return list;
    }
}
