package dev.kartikbhalla;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        var list = new LinkedList();

        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
//        list.addLast(8);



//        System.out.println(list.contains(18));

//        list.removeFirst();
        System.out.println(Arrays.toString(list.toArray()));

//        list.reverse();
//
//        System.out.println(Arrays.toString(list.toArray()));

        System.out.println(list.getKthElementFromEnd(3));

    }
}
