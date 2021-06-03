package dev.kartikbhalla;

public class DynamicArray {
    private int[] array;
    private int index = 0;

    /* Usage Example
        var array = new DynamicArray(5);
        array.insert(2);
        array.insert(4);
        array.insert(6);
        array.insert(8);
        array.insert(10);
        System.out.println(array);

        array.removeAt(2);
        System.out.println(array);

        System.out.println(array.indexOf(4));
    */

    public DynamicArray(int length) {
        array = new int[length];
    }

    public DynamicArray() {
        this(5);
    }

    public void insert(int item) {

        if (this.index == this.array.length) {
            int[] newArray = new int[this.index * 2];

            for (int i = 0; i < this.index; i++) {
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        }

        this.array[this.index] = item;
        this.index++;
    }

    public int indexOf(int item) {
        for (int i = 0; i < this.index; i++)
            if (this.array[i] == item) return i;

        return -1;
    }

    public int removeAt(int index) {
        if (index < 0 || index >= this.index) throw new IndexOutOfBoundsException();

        int elementDeleted = this.array[index];

        for (int i = index; i < this.index; i++) {
            if (i == this.index - 1) this.array[i] = 0;
            else this.array[i] = this.array[i + 1];
        }

        this.index--;
        return elementDeleted;
    }

    @Override
    public String toString() {
        String arrayToString = "[";

        for (int i = 0; i < this.index; i++) {
            arrayToString += this.array[i];
            if (i != this.index - 1) arrayToString += ", ";
        }

        return arrayToString + "]";
    }

}
