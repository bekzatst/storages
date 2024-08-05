package implementations;

import interfaces.CustomHashSet;

import java.util.LinkedList;

public class HashSetImplementation<E> implements CustomHashSet<E> {
    private LinkedList<E>[] buckets;
    private int size;
    private int capacity;

    public HashSetImplementation() {
        this.capacity = 10;
        this.buckets = new LinkedList[capacity];
        this.size = 0;
    }

    @Override
    public void put(E item) {
        int index = item.hashCode() % capacity;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        if (!buckets[index].contains(item)) {
            buckets[index].add(item);
            size++;
            if (size > capacity * 0.75) {
                resize(capacity * 2);
            }
        }
    }

    @Override
    public boolean contains(E item) {
        int index = item.hashCode() % capacity;
        if (buckets[index] == null) {
            return false;
        }
        return buckets[index].contains(item);
    }

    @Override
    public E delete(E item) {
        int index = item.hashCode() % capacity;
        if (buckets[index] == null) {
            return null;
        }
        if (buckets[index].remove(item)) {
            size--;
            if (size < capacity / 4) {
                resize(capacity / 2);
            }
            return item;
        }
        return null;
    }

    @Override
    public void resize(int newSize) {
        LinkedList<E>[] newBuckets = new LinkedList[newSize];
        for (int i = 0; i < capacity; i++) {
            if (buckets[i] != null) {
                for (E item : buckets[i]) {
                    int index = item.hashCode() % newSize;
                    if (newBuckets[index] == null) {
                        newBuckets[index] = new LinkedList<>();
                    }
                    newBuckets[index].add(item);
                }
            }
        }
        buckets = newBuckets;
        capacity = newSize;
    }

    @Override
    public void iterate() {
        for (int i = 0; i < capacity; i++) {
            if (buckets[i] != null) {
                for (E item : buckets[i]) {
                    System.out.println(item);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            if (buckets[i] != null) {
                for (E item : buckets[i]) {
                    sb.append(item).append(" ");
                }
            }
        }
        return sb.toString();
    }

}
