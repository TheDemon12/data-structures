package dev.kartikbhalla;

import java.util.ArrayList;

public class Tree {

    private class Node {
        public int value;
        public Node leftChild;
        public Node rightChild;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node = " + this.value;
        }
    }

    private Node root;



    public void insert(int value) {
        var node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        var current = root;
        while (true) {
            if (value > current.value) {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            } else {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
        }
    }

    public boolean find(int value) {
        var current = root;

        while (current != null) {
            if (value > current.value)
                current = current.rightChild;
            else if (value < current.value)
                current = current.leftChild;
            else return true;
        }

        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(this.root);
    }

    private void traversePreOrder(Node current) {
        if (current == null) return;

        System.out.println(current.value);
        traversePreOrder(current.leftChild);
        traversePreOrder(current.rightChild);
    }


    public void traverseInOrder() {
        traverseInOrder(this.root);
    }

    private void traverseInOrder(Node current) {
        if (current == null) return;

        traverseInOrder(current.leftChild);
        System.out.println(current.value);
        traverseInOrder(current.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(this.root);
    }

    private void traversePostOrder(Node current) {
        if (current == null) return;

        traversePostOrder(current.leftChild);
        traversePostOrder(current.rightChild);
        System.out.println(current.value);
    }

    public int height() {
        return height(this.root);
    }

    private int height(Node current) {
        if (current == null) return -1;

        if (isLeafNode(current)) return 0;

        var heightLeftChild = height(current.leftChild);
        var heightRightChild = height(current.rightChild);

        return 1 + Math.max(heightLeftChild, heightRightChild);

    }

    public int min() {
        return min(this.root);
    }

    private int min(Node current) {
        if (isLeafNode(current)) return current.value;

        var leftMin = min(current.leftChild);
        var rightMin = min(current.rightChild);

        return Math.min(
                Math.min(leftMin, rightMin),
                current.value);

    }

    public boolean equals(Tree tree) {
        if (tree == null)
            return false;
        return equals(tree.root, this.root);
    }

    private boolean equals(Node secondCurrent, Node current) {
        if (current == null && secondCurrent == null) return true;

        if (current != null && secondCurrent != null)
            return current.value == secondCurrent.value &&
                    equals(secondCurrent.leftChild, current.leftChild) &&
                    equals(secondCurrent.rightChild, current.rightChild);
        return false;
    }


    public boolean isBinarySearchTree() {
        return isBinarySearchTree(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node current, int minValue, int maxValue) {
        if (current == null) return true;

        if (minValue > current.value || current.value > maxValue) return false;

        return isBinarySearchTree(current.leftChild, minValue, current.value) &&
                isBinarySearchTree(current.rightChild, current.value, maxValue);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(this.root, distance, list);

        return list;
    }

    private void getNodesAtDistance(Node current, int distance, ArrayList<Integer> list) {

        if (current == null) return;
        if (distance == 0) {
            list.add(current.value);
            return;
        }

        getNodesAtDistance(current.leftChild, distance - 1, list);
        getNodesAtDistance(current.rightChild, distance - 1, list);

    }

    public void traverseLevelOrder() {
        for (var i = 0; i <= height(); i++)
            for (var node : getNodesAtDistance(i))
                System.out.println(node);
    }

    private boolean isLeafNode(Node current) {
        return current.leftChild == null && current.rightChild == null;
    }

}
