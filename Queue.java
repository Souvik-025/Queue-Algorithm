import java.util.Arrays;

public class Queue {
    int[] arr;
    int capacity;
    int front;
    int rear;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return (rear == -1 || front == -1);
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public int peek() {
        return arr[front];
    }

    public void enqueue(int data) {

        if (isFull())
            throw new QueueOverflowException("Queue Overflow");

        if (isEmpty())
            arr[rear = front = 0] = data;
        else
            arr[rear = (rear + 1) % capacity] = data;
        System.out.println("Data Enqueued");
    }

    public int dequeue() {
        if (isEmpty())
            throw new QueueUnderflowException("Queue Underflow");

        int data = arr[front];

        if (rear == front)
            rear = front = -1;
        else
            front = (front + 1) % capacity;

        return data;
    }

    @Override
    public String toString() {
        String s = "[ ";
        if (!isEmpty()) {
            int i = front;
            while(true)
            {
                if (i != rear)
                s += arr[i] + ", ";
                else {
                    s += arr[i];
                    break;
                }
                i = (i + 1) % capacity;
            }
        }
        s += " ]";

        return s;
    }

}
