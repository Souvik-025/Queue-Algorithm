public class Queue<T> {
    private Object[] arr;
    private int front = -1;
    private int rear = -1;
    private int size = 0;

    public Queue(int capacity) {
        this.arr = new Object[capacity];
    }

    public final boolean isEmpty()
    {
        return front == -1 && rear == -1;
    }

    public final boolean isFull() {
        return (rear + 1) % arr.length == front;
    }

    public final void enqueue(Object data) {
        if (isEmpty()) {
            arr[++front] = arr[++rear] = data;
        } else {
            if (!isFull()) {
                arr[this.rear = (rear + 1) % arr.length] = data;
            } else
                throw new QueueOverFlowException("Queue OverFlow");
        }
        size++;
    }

    public final Object dequeue() {
        Object data;
        if (isEmpty())
            throw new QueueUnderFlowException("Queue Underflow");
        else {
            if(front == rear)
            {
                data = arr[front];
                front = rear = -1;
            }
            else
            {
                data = arr[front];
                front = (front + 1) % arr.length;
            }
        }
        size--;
        return data;
    }

    public final int getSize()
    {
       return size; 
    }

    public final Object peek()
    {
        return !isEmpty() ? arr[front] : null;
    }

    @Override
    public String toString()
    {
        String s = "[ ";
        for (int i = front; true ; i = (i + 1) % arr.length)
        {
            s += i != rear ? arr[i]+", " : arr[i];
            if(i == rear)
                break;
        }
        s += " ]";
        return s;
    }
}
