package dev.kartikbhalla;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Trie {
    private final int ALPHABET_SIZE = 26;

    private class Node {
        private char value;
        //        private Node[] children = new Node[ALPHABET_SIZE];
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node value = " + value;
        }

        public boolean hasChild(char ch) {
//            var index = ch - 'a';
//            return children[index] != null;

            return children.containsKey(ch);
        }

        public void addChild(char ch) {
//            var index = ch - 'a';
//            children[index] = new Node(ch);
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
//            if (!hasChild(ch))
//                throw new IllegalStateException();

//            var index = ch - 'a';
//            return children[index];

            return children.get(ch);
        }

        public Node[] getAlLChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }

    }


    private Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);

            current = current.getChild(ch);
        }

        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null) return false;

        var current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traverse() {
        traverse(root);

    }

    private void traverse(Node current) {
        System.out.println(current.value);
        for (var child : current.getAlLChildren())
            traverse(child);
    }

    public void delete(String word) {
        if (word == null) return;

        delete(root, word, 0);
    }

    private void delete(Node current, String word, int index) {

        if (index == word.length()) {
            current.isEndOfWord = false;
            return;
        }

        var ch = word.charAt(index);
        var child = current.getChild(ch);
        if (child == null) return;

        delete(child, word, index + 1);

        if (!child.hasChildren() && !child.isEndOfWord) {
            current.removeChild(ch);
        }


    }

    public List<Integer> autoComplete(String input) {
        if (input == null) throw new IllegalArgumentException();

        var current = root;
        List list = new ArrayList<String>();

        for (char ch : input.toCharArray()) {
            if(current == null) return list;
            current = current.getChild(ch);
        }

        autoComplete(current, input, list);
        return list;
    }


    private void autoComplete(Node current, String word, List<String> list) {
        if (current == null) return;

        if (current.isEndOfWord)
            list.add(word);

        for (var node : current.getAlLChildren())
            autoComplete(node, word + node.value, list);

    }


}
