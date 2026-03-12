import java.util.*;

class MinHeap {
    public int[] minheap;
    public int size;

    MinHeap(int maxSize) {
        minheap = new int[maxSize + 1];
        size = 0;
        minheap[0] = Integer.MIN_VALUE;
    }

    
    public void AddToHeap(int val) {
        size++;
        minheap[size] = val;
        
        int current = size;
        while (minheap[current] < minheap[current / 2]) {
            swap(current, current / 2);
            current = current / 2;
        }
    }

    public int RemoveRoot() {
        int popped = minheap[1];
        minheap[1] = minheap[size];
        size--;
        sinkDown(1); 
        return popped;
    }

  
    public void sinkDown(int pos) {
        int curr = pos;
        while (curr <= size / 2) { 
            int child1 = 2 * curr;
            int child2 = 2 * curr + 1;
            int minChild = child1;

            if (child2 <= size && minheap[child2] < minheap[child1]) {
                minChild = child2;
            }

            if (minheap[curr] > minheap[minChild]) {
                swap(curr, minChild);
                curr = minChild;
            } else {
                break;
            }
        }
    }

    public int ViewTop() {
        return size > 0 ? minheap[1] : -1;
    }

    private void swap(int i1, int i2) {
        int temp = minheap[i1];
        minheap[i1] = minheap[i2];
        minheap[i2] = temp;
    }

    public static void main(String[] args) {
        MinHeap t = new MinHeap(10);
        t.AddToHeap(5);
        t.AddToHeap(10);
        t.AddToHeap(2);
        t.AddToHeap(0);

        System.out.println("Top element (Min): " + t.ViewTop()); 
        System.out.println("Removed: " + t.RemoveRoot());     
        System.out.println("New Top: " + t.ViewTop());        
    }
}