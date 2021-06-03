package dev.kartikbhalla;

import static dev.kartikbhalla.Utils.firstNonRepeatedCharacter;
import static dev.kartikbhalla.Utils.firstRepeatedCharacter;

public class Main {

    public static void main(String[] args) {

        var ch = firstRepeatedCharacter("hello worhled ");
        System.out.println(ch);
    }
}
