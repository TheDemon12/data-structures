package dev.kartikbhalla;

import java.util.*;
import java.util.Queue;
import java.util.Stack;

public class Utils {

    public static String reverseString(String input) {

        /* Usage Example
            String string = "kartik";
            var reversed = Utils.reverseString(string);
         */


        if (input == null) throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();
        char[] charArray = input.toCharArray();
        for (char ch : charArray)
            stack.push(ch);

        StringBuffer reversedStringBuffer = new StringBuffer();
        while (!stack.isEmpty()) reversedStringBuffer.append(stack.pop());


        return reversedStringBuffer.toString();
    }

    public static void reverseQueue(Queue<Integer> queue) {

        /* Usage Example
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(2);
            queue.add(3);
            queue.add(4);
            System.out.println(queue);
            Utils.reverseQueue(queue);
            System.out.println(queue);
         */

        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());
    }

    public static Character firstNonRepeatedCharacter(String input) {

        /* Usage Example
            var ch = firstNonRepeatedCharacter("hello world ");
            System.out.println(ch);
         */

        Map<Character, Integer> map = new HashMap<>();
        var charArray = input.toCharArray();

        for (char ch : charArray)
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);

        for (char ch : charArray)
            if (map.get(ch) == 1)
                return ch;

        return Character.MIN_VALUE;
    }

    public static Character firstRepeatedCharacter(String input) {

        /* Usage Example
            var ch = firstRepeatedCharacter("hello world ");
            System.out.println(ch);
         */

        Set<Character> set = new HashSet<>();
        var charArray = input.toCharArray();

        for (char ch : charArray) {
            if (set.contains(ch)) return ch;
            set.add(ch);
        }

        return Character.MIN_VALUE;
    }

}
