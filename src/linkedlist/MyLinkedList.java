package linkedlist;

public class MyLinkedList {
    public Node head;

//    print the linked list nodes
    public void printList() {
        Node currNode = this.head;

        while (currNode != null) {
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        }
        System.out.println();
    }

//    insert a node at the last position
    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

//    insert a node at the first position
    public void insertFirst(int data) {
        Node newNode = new Node(data);

        if (this.head != null) {
            newNode.next = this.head;
        }
        this.head = newNode;
    }

//    insert a node at Nth position
    public void insertNth(int data, int position) {
        Node newNode = new Node(data);

//        if head is null and position is zero then exit
        if (this.head == null) {
            if (position != 0) {
                return;
            } else {
                this.head = newNode;
            }
        }

//        head is not null
        if (position == 0) {
            newNode.next = this.head;
            this.head = newNode;
            return;
        }

        Node currentNode = this.head;
        Node previousNode = null;
        int i = 0;

        while (i < position) {
            previousNode = currentNode;
            currentNode = currentNode.next;

            if (currentNode == null) {
                break;
            }

            i++;
        }

//        if statement is to avoid null pointer exception
        if (previousNode != null) {
            previousNode.next = newNode;
        }

        newNode.next = currentNode;
    }

    public int getNth(int index) {
        Node currentNode = this.head;
        int count = 0;

        while(currentNode != null) {
            if (count == index) {
                return currentNode.data;
            }
            count++;
            currentNode = currentNode.next;
            }

        System.out.print("index out of range։ ");
        return 0;
        }

//    delete a node by position
    public void deleteByPosition(int position) {
        Node currentNode = this.head,
                previousNode = null; // previous node is needed to change currNode.next

//        If index is 0, then head node itself is to be deleted
        if (position == 0 && currentNode != null) {
            this.head = currentNode.next;
        }

//        If the index is greater than 0 but less than the size of LinkedList
        int counter = 0;

        while (currentNode != null) {
            if (counter == position) {
                previousNode.next = currentNode.next;
                System.out.println(position+" position element deleted");
                break;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.next;
                counter++;
            }
        }

        if (currentNode == null) {
            System.out.println(position+" position element not found");
        }
    }
}
