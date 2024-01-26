package org.learing.gs.training;

import java.util.Arrays;

public class CustomArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public CustomArrayList() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void add(Object element) {
        ensureCapacity();
        array[size++] = element;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (Object) array[index];
    }

    public int size() {
        return size;
    }

    public Object remove(int index) {
        // if index is negative or greater than size of size, we throw

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }

        Object removedElement = array[index];
        for (int i = index; i < size - 1; i++) {
           array[i] = array[i + 1];
        }
        size--; // reduce size of ArrayListCustom after removal of element.

        return removedElement;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }


    public void display() {
        System.out.print("Displaying list : ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        System.out.println("Element added");
        list.add(10);
        list.add(20);
        list.add(30);list.add(40);
        list.display();
        list.remove(2);
        System.out.println("After  remove");
        list.display();
        System.out.println("Get element at 3 position; "+list.get(2));


    }

}


