package dev.kartikbhalla;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        int[] numbers = {5, 3, 8, 4, 1, 2};
//        var sorted = Utils.heapSort(numbers);
//        System.out.println(Arrays.toString(sorted));

//        Utils.heapify(numbers);
//        System.out.println(Arrays.toString(numbers));

//        System.out.println(Utils.getKthLargestNumber(numbers, 6));


        var trie = new Trie();
//        trie.insert("kartik");
//        trie.insert("car");
//        trie.insert("carpet");
//        trie.delete("car");
//        trie.delete("carpet");
//
//        System.out.println(trie.contains("carpet"));
//        System.out.println(trie.contains("car"));

        trie.insert("car");
        trie.insert("card");
        trie.insert("careful");
        trie.insert("egg");

        var list = trie.autoComplete("");


        System.out.println(Arrays.toString(list.toArray()));

    }
}
