package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo4.ABB;

public class ABBTest {

    ABB<Integer> abb;

    @BeforeEach
    void setUp() {
        abb = new ABB<>();
    }

    @Test
    public void testCreateABB() {
        assertNotNull(abb);
        assertEquals(0, abb.size());
    }

    @Test
    public void testAddElement() {
        assertTrue(abb.add(10, 10));
        assertEquals(1, abb.size());
    }

    @Test
    public void testAddExistingElement() {
        assertTrue(abb.add(10, 10));
        assertFalse(abb.add(10, 20));
        assertEquals(1, abb.size());
    }

    @Test
    public void testFindElement() {
        abb.add(10, 10);
        abb.add(20, 20);
        assertEquals(Integer.valueOf(10), abb.find(10));
        assertEquals(Integer.valueOf(20), abb.find(20));
        assertNull(abb.find(30));
    }

    @Test
    public void testRemoveElement() {
        abb.add(10, 10);
        abb.add(20, 20);
        assertEquals(Integer.valueOf(10), abb.remove(10));
        assertEquals(1, abb.size());
        assertNull(abb.find(10));
    }

    @Test
    public void testAllElements() {
        abb.add(10, 10);
        abb.add(20, 20);
        Integer[] array = new Integer[2];
        Integer[] result = abb.allElements(array);
        assertEquals(2, result.length);
        assertEquals(Integer.valueOf(10), result[0]);
        assertEquals(Integer.valueOf(20), result[1]);
    }
}
