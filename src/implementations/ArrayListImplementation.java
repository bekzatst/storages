package implementations;

import interfaces.CustomArrayList;

import java.util.Arrays;

public class ArrayListImplementation<E> implements CustomArrayList<E> {
    private Object[] array;
    private int size;
    private int capacity;

    public ArrayListImplementation() {
        this.capacity = 10;
        this.array = new Object[capacity];
        this.size = 0;
    }

    @Override
    public void put(E item) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        array[size++] = item;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (int) array[index];
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        if (size < capacity / 4) {
            resize(capacity / 2);
        }
    }

    @Override
    public void resize(int newSize) {
        Object[] newArray = new Object[newSize];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        capacity = newSize;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }
}
