package dev.kartikbhalla;

import java.util.Queue;
import java.util.Stack;

public class Utils {

    /* Usage Example
        String string = "kartik";
        var reversed = Utils.reverseString(string);
     */


    public static String reverseString(String input) {

        if(input == null) throw new IllegalArgumentException();

        Stack<Character> stack  = new Stack<>();
        char[] charArray = input.toCharArray();
        for(char ch: charArray)
            stack.push(ch);

        StringBuffer reversedStringBuffer = new StringBuffer();
        while(!stack.isEmpty()) reversedStringBuffer.append(stack.pop());


        return reversedStringBuffer.toString();
    }

    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack  = new Stack<>();

    while(!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());
    }

}
