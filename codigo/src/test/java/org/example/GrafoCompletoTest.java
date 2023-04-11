package org.example;

import grupo4.GrafoCompleto;
import grupo4.GrafoDirecionado;
import grupo4.GrafoMutavel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class GrafoCompletoTest {
    private GrafoCompleto grafoCompleto;
    private GrafoMutavel grafoNaoCompleto;

    @Test
    public void testEhCompleto() {
        grafoCompleto = new GrafoCompleto("Grafo Completo", 5);
        assertTrue(grafoCompleto.completo());
    }

    @Test
    public void testNaoEhCompleto() {
        grafoNaoCompleto = new GrafoDirecionado("Grafo Mutavel");
        grafoNaoCompleto.addVertice(1);
        grafoNaoCompleto.addVertice(2);
        assertFalse(grafoNaoCompleto.completo());
    }

}
