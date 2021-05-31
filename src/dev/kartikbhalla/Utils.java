package dev.kartikbhalla;

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

}
