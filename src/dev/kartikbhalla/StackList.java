package dev.kartikbhalla;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.LinkedList;

public class StackList {

    /* Usage Example
        var stack = new StackList();

        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.pop();

        System.out.println(stack.peek());
        System.out.println(stack);
     */

    private LinkedList<Integer> list;

    StackList() {
        this.list = new LinkedList<>();
    }

    public void push(int element) {
        this.list.addLast(element);
    }

    public int pop() {
        if (this.isEmpty()) throw new EmptyStackException();

        return this.list.removeLast();
    }

    public int peek() {
        if (this.isEmpty()) throw new EmptyStackException();

        return this.list.getLast();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public String toString() {
        return Arrays.toString(this.list.toArray());
    }
}
