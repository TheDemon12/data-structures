package dev.kartikbhalla;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue);
        Utils.reverseQueue(queue);
        System.out.println(queue);

    }
}
