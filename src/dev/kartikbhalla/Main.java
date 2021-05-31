package dev.kartikbhalla;

public class Main {

    public static void main(String[] args) {

        var stack = new StackList();
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.pop();

        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
