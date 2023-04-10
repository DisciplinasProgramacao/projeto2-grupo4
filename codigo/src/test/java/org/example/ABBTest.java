package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;

import grupo4.ABB;

public class ABBTest {
    @Test
    public void testCreateABB() {
        ABB<Integer> abb = new ABB<>();
        assertNotNull(abb);
        assertEquals(0, abb.size());
    }

    @Test
    public void testAddElement() {
        ABB<Integer> abb = new ABB<>();
        assertTrue(abb.add(10, 10));
        assertEquals(1, abb.size());
    }

    @Test
    public void testAddExistingElement() {
        ABB<Integer> abb = new ABB<>();
        assertTrue(abb.add(10, 10));
        assertFalse(abb.add(10, 20));
        assertEquals(1, abb.size());
    }

    @Test
    public void testFindElement() {
        ABB<Integer> abb = new ABB<>();
        abb.add(10, 10);
        abb.add(20, 20);
        assertEquals(Integer.valueOf(10), abb.find(10));
        assertEquals(Integer.valueOf(20), abb.find(20));
        assertNull(abb.find(30));
    }

    @Test
    public void testRemoveElement() {
        ABB<Integer> abb = new ABB<>();
        abb.add(10, 10);
        abb.add(20, 20);
        assertEquals(Integer.valueOf(10), abb.remove(10));
        assertEquals(1, abb.size());
        assertNull(abb.find(10));
    }

    @Test
    public void testAllElements() {
        ABB<Integer> abb = new ABB<>();
        abb.add(10, 10);
        abb.add(20, 20);
        Integer[] array = new Integer[2];
        Integer[] result = abb.allElements(array);
        assertEquals(2, result.length);
        assertEquals(Integer.valueOf(10), result[0]);
        assertEquals(Integer.valueOf(20), result[1]);
    }
}
