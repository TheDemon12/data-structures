package dev.kartikbhalla;

public class PriorityQueueWithHeap {

    /* Usage Example
        PriorityQueue queue = new PriorityQueue(5);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        queue.enqueue(5);
        queue.enqueue(4);

        System.out.println(queue);

        while(!queue.isEmpty())
            System.out.println(queue.dequeue());
     */

    private Heap heap = new Heap();

    public void enqueue(int item) {
        heap.insert(item);
    }
    public int dequeue(int item) {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }


}
