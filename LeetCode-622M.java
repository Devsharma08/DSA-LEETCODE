class MyCircularQueue {
    private int[] qu;
    private int front;
    private int rear;
    private int size;
    private int k;

    public MyCircularQueue(int k) {
        this.qu = new int[k];
        this.k = k;
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        
        qu[rear] = value;
        rear = (rear + 1) % k; 
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        
        front = (front + 1) % k;
        size--;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : qu[front];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        int lastIndex = (rear - 1 + k) % k;
        return qu[lastIndex];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k;
    }
}