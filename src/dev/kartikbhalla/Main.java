package dev.kartikbhalla;

import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) {

//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(2);
//        queue.add(3);
//        queue.add(4);
//        System.out.println(queue);
//        Utils.reverseQueue(queue);
//        System.out.println(queue);

//        Queue queue = new Queue(5);
//        queue.enqueue(1);
//        queue.enqueue(2);
//        queue.enqueue(3);
//        queue.enqueue(4);
//        queue.enqueue(5);
//
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        System.out.println(queue);
//
//        queue.enqueue(6);
//        System.out.println(queue);

//        CircularQueue queue = new CircularQueue(5);
//        queue.enqueue(1);
//        queue.enqueue(2);
//        queue.enqueue(3);
//        queue.enqueue(4);
//        queue.enqueue(5);
//        queue.dequeue();
//        queue.enqueue(6);
////        queue.enqueue(7);
//        System.out.println(queue);

//        QueueWithStacks queue = new QueueWithStacks();
//        queue.enqueue(1);
//        queue.enqueue(2);
//        queue.enqueue(3);
//        queue.enqueue(4);
//        queue.enqueue(5);
//
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());




        PriorityQueue queue = new PriorityQueue(5);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        queue.enqueue(5);
        queue.enqueue(4);

        System.out.println(queue);

        while(!queue.isEmpty())
            System.out.println(queue.dequeue());

    }
}
