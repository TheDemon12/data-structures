package dev.kartikbhalla;

public class AVLTree {
    private class AVLNode {
        public int value;
        public AVLNode leftChild;
        public AVLNode rightChild;
        public int height;

        AVLNode(int value) {
            this.value = value;
            this.height = 0;
        }

        @Override
        public String toString() {
            return "Node = " + this.value;
        }
    }

    private AVLNode root;


    public void insert(int value) {
        this.root = insert(this.root, value);
    }

    private AVLNode insert(AVLNode current, int value) {
        if (current == null)
            return new AVLNode(value);

        if (value < current.value)
            current.leftChild = insert(current.leftChild, value);
        else
            current.rightChild = insert(current.rightChild, value);

        setHeight(current);

        return balance(current);
    }

    private AVLNode balance(AVLNode current) {
        if(isLeftHeavy(current)) {
//            System.out.println(current.value + " is left heavy");

            if(balanceFactor(current.leftChild) < 0)
//                System.out.println("L rotation needed at " + current.leftChild.value);
                current.leftChild = rotateLeft(current.leftChild);

//            System.out.println("R rotation needed at " + current.value);
            return rotateRight(current);

        }
        else if(isRightHeavy(current)) {
//            System.out.println(current.value + " is right heavy");

            if(balanceFactor(current.rightChild) > 0)
//                System.out.println("R rotation needed at " + current.rightChild.value);
                current.rightChild = rotateRight(current.rightChild);

//            System.out.println("L rotation needed at " + current.value);
           return rotateLeft(current);
        }

        return current;

    }

    private AVLNode rotateLeft(AVLNode current) {

        AVLNode tempNode = current.rightChild;
        current.rightChild = tempNode.leftChild;
        tempNode.leftChild = current;

        setHeight(current);
        setHeight(tempNode);

        return tempNode;

    }
    private AVLNode rotateRight(AVLNode current) {

        AVLNode tempNode = current.leftChild;
        current.leftChild = tempNode.rightChild;
        tempNode.rightChild = current;

        setHeight(current);
        setHeight(tempNode);

        return tempNode;

    }

    private void setHeight(AVLNode node) {
        node.height = Math.max(
                height(node.leftChild),
                height(node.rightChild)) + 1;
    }



    private int height(AVLNode node) {
        return node == null ? -1 : node.height;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }


}
