package dev.kartikbhalla;

public class PriorityQueue extends Queue {

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


    PriorityQueue(int size) {
        super(size);
    }

    @Override
    public void enqueue(int element) {
        if (isFull()) throw new IllegalStateException();
        else if (isEmpty()) {
            front = rear = 0;
            array[rear] = element;
        } else {
            var position = shiftItemsToInsert(element);
            array[position + 1] = element;
            rear++;
        }
    }

    private int shiftItemsToInsert(int element) {
        int i;
        for (i = rear; i >= 0; i--) {
            if (array[i] > element) {
                array[i + 1] = array[i];
            } else break;
        }
        return i;
    }
}
