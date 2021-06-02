package dev.kartikbhalla;

public class PriorityQueue extends Queue{

    PriorityQueue(int size) {
       super(size);
    }

    @Override
    public void enqueue(int element) {
        if (isFull()) throw new IllegalStateException();
        else if(isEmpty()) {
            front = rear = 0;
            array[rear] = element;
        }
        else {
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
            }
            else break;
        }
        return i;
    }
}
