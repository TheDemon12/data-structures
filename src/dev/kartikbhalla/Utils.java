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

    public static int[] heapSort(int[] list) {

        var sortedList = new int[list.length];
        var heap = new Heap();

        for (var item : list)
            heap.insert(item);
        for (var i = 0; !heap.isEmpty(); i++)
            sortedList[i] = heap.remove();

        return sortedList;
    }

//    public static void heapify(int[] list) {
//        for (int i = 0; i < list.length; i++) {
//            heapify(list, i);
//        }
//    }

    /* Optimised */

    public static void heapify(int[] list) {
        var lastParentIndex = (list.length / 2) - 1;
        for (int i = lastParentIndex; i >= 0; i--) {
            heapify(list, i);
        }
    }

    private static void heapify(int[] list, int index) {

        var largerIndex = index;

        var leftChildIndex = (index * 2) + 1;
        if (leftChildIndex < list.length &&
                list[leftChildIndex] > list[index])
            largerIndex = leftChildIndex;

        var rightChildIndex = leftChildIndex + 1;
        if (rightChildIndex < list.length &&
                list[rightChildIndex] > list[index])
            largerIndex = rightChildIndex;

        if (largerIndex == index)
            return;

        swap(list, index, largerIndex);
        heapify(list, largerIndex);

    }

    private static void swap(int[] list, int first, int second) {
        var temp = list[first];
        list[first] = list[second];
        list[second] = temp;
    }

    public static int getKthLargestNumber(int[] list, int k) {

        if(k < 1 || k > list.length)
            throw new IllegalArgumentException();

        var heap = new Heap();
        for (int item : list)
            heap.insert(item);

        for (int i = 1; i < k; i++)
            heap.remove();

        return heap.max();
    }


}



























