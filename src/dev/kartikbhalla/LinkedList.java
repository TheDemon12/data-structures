package dev.kartikbhalla;

public class LinkedList {

    /* Usage Example
        var list = new LinkedList();

        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);

        System.out.println(list.contains(18));

        list.removeFirst();
        System.out.println(Arrays.toString(list.toArray()));

        list.reverse();

        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.getKthElementFromEnd(3));

     */

    private class Node {
        public int value;
        public Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    LinkedList() {
        this.first = this.last = null;
    }

    public void addLast(int value) {
        var node = new Node(value);

        if (isEmpty()) first = last = node;
        else {
            last.next = node;
            this.last = node;
        }
        ;

        this.size++;
    }

    public void addFirst(int value) {
        var node = new Node(value);

        if (isEmpty()) first = last = node;
        else {
            node.next = this.first;
            this.first = node;
        }

        this.size++;
    }

    public int indexOf(int value) {
        var node = this.first;
        int index = 0;

        while (node != null) {
            if (node.value == value) return index;

            index++;
            node = node.next;
        }
        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int removeFirst() {

        if (first == null) throw new IllegalStateException();
        else {
            int value = this.first.value;

            if (first == last) first = last = null;
            else
                this.first = this.first.next;

            this.size--;
            return value;
        }
    }

    public int removeLast() {

        if (first == null) throw new IllegalStateException();
        else {
            int value = this.first.value;

            if (first == last) first = last = null;
            else {
                var previousNode = getPreviousNode(this.last);

                previousNode.next = null;
                last = previousNode;
            }
            this.size--;
            return value;
        }
    }


    private Node getPreviousNode(Node node) {
        var currentNode = this.first;

        while (currentNode.next != null) {
            if (currentNode.next == node) return currentNode;
            currentNode = currentNode.next;
        }

        return null;
    }


    public int size() {
        return this.size;
    }


    public void reverse() {
        var currentNode = this.first;
        Node previousNode = null;

        while (currentNode != null) {
            Node nextNode = currentNode.next;

            if (previousNode == null) {
                this.last = currentNode;
                this.last.next = null;
            } else currentNode.next = previousNode;

            previousNode = currentNode;
            currentNode = nextNode;
        }

        this.first = previousNode;
    }

    public int getKthElementFromEnd(int k) {

        if (k < 1 || k > this.size) throw new IllegalArgumentException();

        var firstPointer = this.first;
        var secondPointer = firstPointer;

        for (int i = 0; i < k - 1; i++) {
            secondPointer = secondPointer.next;
        }

        while (secondPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return firstPointer.value;
    }

    public int[] toArray() {
        int[] array = new int[this.size];
        var node = this.first;
        int index = 0;

        while (node != null) {
            array[index++] = node.value;
            node = node.next;
        }

        return array;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void printList() {
        var node = this.first;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

}
