package dev.kartikbhalla;

import static dev.kartikbhalla.Utils.firstNonRepeatedCharacter;
import static dev.kartikbhalla.Utils.firstRepeatedCharacter;

public class Main {

    public static void main(String[] args) {

//        var ch = firstRepeatedCharacter("hello worhled ");
//        System.out.println(ch);

        HashTable table = new HashTable();
        table.put(6, "A");
        table.put(8, "B");
        table.put(11, "C");
        System.out.println(table.get(8));
        System.out.println(table.remove(8));
        System.out.println(table.get(8));
//        System.out.println(table.remove(8));
    }
}
