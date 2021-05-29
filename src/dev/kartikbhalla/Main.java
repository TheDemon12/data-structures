package dev.kartikbhalla;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

//        var array = new DynamicArray(5);
//        array.insert(2);
//        array.insert(4);
//        array.insert(6);
//        array.insert(8);
//        array.insert(10);
//        System.out.println(array);
//
//        array.removeAt(2);
//        System.out.println(array);
//
//        System.out.println(array.indexOf(4));

        var array  = new ArrayList<Integer>();
        array.add(2);
        array.add(4);
        array.add(6);
        array.add(8);
        array.add(10);
        array.remove(2);
        System.out.println(array);



    }
}
