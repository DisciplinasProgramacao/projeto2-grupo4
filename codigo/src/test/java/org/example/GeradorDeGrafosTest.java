package org.example;

import grupo4.GeradorDeGrafos;
import grupo4.GrafoDirecionado;
import grupo4.GrafoMutavel;
import grupo4.LeituraDados.Leitura;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeradorDeGrafosTest {

    private GrafoMutavel grafo;
    @BeforeEach
    void setUp() throws Exception {
        grafo = new GrafoDirecionado("nome");
    }

    @Test
    public void testGerarGrafoComItens() throws IOException {
        grafo = GeradorDeGrafos.gerarGrafoPelosItems(Leitura.gerarItemsDoJson(null), "grafo1");
        assertEquals(2, grafo.existeVertice(2).getId());
        assertEquals(3, grafo.existeVertice(3).getId());
    }

    @Test
    public void testGerarGrafoSemItens() {
        grafo = GeradorDeGrafos.gerarGrafoPelosItems(new ArrayList<>(), "grafo2");
        assertEquals(0, grafo.tamanho());
    }
}
