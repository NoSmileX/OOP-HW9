package org.example.myhashset;

public class Main {
    public static void main(String[] args) {
        MyHashSet<Integer> hs = new MyHashSet<>(6);

        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(3);

        hs.print();
        System.out.println(hs.contains(9));

        hs.add(4);
        hs.add(5);
        hs.add(6);
        hs.add(7);

        hs.print();

        System.out.println(hs.contains(2));

        hs.remove(2);
        hs.print();
        System.out.println(hs.contains(2));

    }
}
