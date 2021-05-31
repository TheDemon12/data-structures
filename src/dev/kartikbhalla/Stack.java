package dev.kartikbhalla;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {

    /* Usage Example
        var stack = new Stack(5);

        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.pop();

        System.out.println(stack.peek());
        System.out.println(stack);
     */


    private int[] array;
    private int top;

    Stack(int initialSize) {
        this.array = new int[initialSize];
        this.top = -1;
    }
    Stack() {
        this(5);
    }

    public void push(int element) {
        this.top++;
        if(this.top == this.array.length) throw new StackOverflowError();

        this.array[this.top] = element;
    }

    public int pop() {
        if(this.isEmpty()) throw new EmptyStackException();

        var element = this.array[this.top];
        this.array[this.top--] = 0;

        return element;
    }

    public int peek() {
        if(this.isEmpty()) throw new EmptyStackException();

        return this.array[this.top];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    @Override
    public String toString() {
        var array = Arrays.copyOfRange(this.array, 0, this.top + 1);

        return Arrays.toString(array);
    }
}
