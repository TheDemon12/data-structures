package dev.kartikbhalla;
import java.util.Stack;

public class QueueWithStacks {

    private Stack<Integer> stack1 = new Stack();
    private Stack<Integer> stack2 = new Stack();

    public void enqueue(int element) {
        stack1.push(element);
    }

    public int dequeue() {
        if(isEmpty()) throw new IllegalStateException();

        moveStack1ToStack2IfStack2isEmpty();
        return stack2.pop();
    }

    public int peek() {
        if(isEmpty()) throw new IllegalStateException();

        moveStack1ToStack2IfStack2isEmpty();
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void moveStack1ToStack2IfStack2isEmpty() {
        if(stack2.isEmpty())
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
    }

}
