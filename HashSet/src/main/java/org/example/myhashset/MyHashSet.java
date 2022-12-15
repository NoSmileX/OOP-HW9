package org.example.myhashset;

import java.util.Arrays;
import java.util.Objects;

public class MyHashSet<T> {
    private final double LOAD = .75;
    private int size = 16;

    private Node<T>[] array;
    private int currentSize = 0;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        private Node(T data) {
            this.data = data;
            next = null;
        }

        private static <T> Node<T>[] makeArray(int size) {
            return new Node[size];
        }
    }

    public MyHashSet(int size) {
        this.size = size;
        array = Node.makeArray(size);
    }

    public MyHashSet() {
        array = Node.makeArray(size);
    }

    public int getCurrentSize() {
        return currentSize;
    }

    private int getHash(T item) {
        int hash = Math.abs(Objects.hashCode(item) % array.length);
        return hash;
    }

    public int getCapacity() {
        return array.length;
    }

    private void resize() {
        Node<T>[] newArray = Node.makeArray(getCapacity() * 2);
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public boolean contains(T item) {
        Node<T> current = array[getHash(item)];
        if (current == null) {
            return false;
        }
        while (current != null) {
            if (current.data.equals(item)) {
                return true;
            }
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        return false;
    }

    public boolean add(T data) {
        if ((double) getCurrentSize() / (double) getCapacity() >= LOAD) {
            resize();
        }
        if (contains(data)) {
            return false;
        } else {
            Node<T> newData = new Node<>(data);
            if (array[getHash(data)] == null) {
                array[getHash(data)] = newData;
            } else {
                Node<T> current = array[getHash(data)];
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newData;
            }
            currentSize++;
            return true;
        }
    }

    public boolean remove(T data) {
        if (!contains(data)) {
            return false;
        } else {
            Node<T> current = array[getHash(data)];
            while (current != null) {
                if (current.data.equals(data)) {
                    if (current == array[getHash(data)]) {
                        array[getHash(data)] = array[getHash(data)].next;
                        return true;
                    }
                } else {
                    current = current.next;
                }
            }
            currentSize--;
        }
        return true;
    }

    public void print() {
        System.out.print("[ ");
        for (Node<T> tNode : array) {
            if (tNode != null) {
                System.out.print(tNode.data + " ");
            }
        }
        System.out.print("]");
    }

    public T get(int index) {
        Node<T> result = array[index];
        if (result == null) {
            return null;
        }
        return result.data;
    }

    @Override
    public String toString() {
        return "MyHashSet{" +
                "LOAD=" + LOAD +
                ", size=" + size +
                ", array=" + Arrays.toString(array) +
                ", currentSize=" + currentSize +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyHashSet<?> myHashSet = (MyHashSet<?>) o;
        return Double.compare(myHashSet.LOAD, LOAD) == 0 && size == myHashSet.size && currentSize == myHashSet.currentSize && Arrays.equals(array, myHashSet.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(LOAD, size, currentSize);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}
