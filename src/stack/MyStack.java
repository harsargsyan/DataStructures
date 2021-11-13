package stack;

public class MyStack {
    private int[] arr;
    private int capacity, top;

    public MyStack(int size) {
        capacity = size;
        arr = new int[size];
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("stack is full");
            System.exit(1);
        } else {
            System.out.println("inserting "+x);
            arr[++top] = x;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            System.exit(1);
        }
        System.out.println("removing "+peek());
        return arr[top--];
    }

    public int peek() {
        if(!isEmpty()) {
            return arr[top];
        } else {
            System.out.println("stack is empty");
            System.exit(1);
        }
        return 1;
    }

    // utility methods

    private int getSize() {
        return top + 1;
    }

    private boolean isFull() {
        return getSize() == capacity; // or top == capacity - 1;
    }

    private boolean isEmpty() {
        return getSize() == 0; // or top == -1;
    }
}
