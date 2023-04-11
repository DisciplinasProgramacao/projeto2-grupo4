package org.example;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import grupo4.GeradorDeGrafos;
import grupo4.LeituraDados.Item;

public class GeradorDeGrafosTest {

    

    @Test
    public void testGerarGrafoSemItens() {
        List<Item> items = new ArrayList<>();
        GeradorDeGrafos.gerarGrafoPelosItems(items, "grafo1");
    }

    @Test
    public void testGerarGrafoComItem() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item();
        items.add(item1);
        GeradorDeGrafos.gerarGrafoPelosItems(items, "grafo2");
    }
}
