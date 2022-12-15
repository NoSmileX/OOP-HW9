package org.example.myhashset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashSetTest {

    MyHashSet<Integer> hashSet = new MyHashSet<>(6);

    @BeforeEach
    void setUp() {
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
    }

    @Test
    void testGetCurrentSize() {
        int result = hashSet.getCurrentSize();
        int expected = 3;
        assertEquals(expected, result);
    }

    @Test
    void testGetCapacity() {
        int result = hashSet.getCapacity();
        int expected = 6;
        assertEquals(expected, result);
    }

    @Test
    void contains_False_IfNotContains() {
        assertFalse(hashSet.contains(9));
    }

    @Test
    void contains_True_IfContains() {
        assertTrue(hashSet.contains(2));
    }

    @Test
    void add_True_IfSuccess() {
        assertTrue(hashSet.add(4));
    }

    @Test
    void add_False_IfNotAdded() {
        assertFalse(hashSet.add(1));
    }

    @Test
    void remove_True_IfSuccess() {
        assertTrue(hashSet.remove(2));
    }

    @Test
    void remove_False_IfNotDeleted() {
        assertFalse(hashSet.remove(9));
    }

    @Test
    void testGet() {
        int result = hashSet.get(2);
        int expected = 2;
        assertEquals(expected, result);
    }
}