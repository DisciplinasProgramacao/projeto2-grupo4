package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import grupo4.Lista;

public class ListaTest {
 
    private Lista<Integer> lista;
    
    @BeforeEach
    public void setUp() {
        lista = new Lista<>();
    }

    @Test
    public void testAdd() {
        assertTrue(lista.add(1));
        assertTrue(lista.add(2));
        assertTrue(lista.add(3));
    }
    
    @Test
    public void testAllElements() {
        Integer[] array = new Integer[3];
        lista.add(1);
        lista.add(2);
        lista.add(3);
        assertArrayEquals(new Integer[]{1,2,3}, lista.allElements(array));
    }
    
    @Test
    public void testRemove() {
        lista.add(1);
        lista.add(2);
        lista.add(3);
        assertEquals(2, lista.remove(1).intValue());
        assertEquals(2, lista.size());
        assertNull(lista.remove(10));
    }
    
    @Test
    public void testSize() {
        assertEquals(0, lista.size());
        lista.add(1);
        lista.add(2);
        assertEquals(2, lista.size());
    }
}
