package grupo4;

/**
 * MIT License
 *
 * Copyright(c) 2021-23 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.io.BufferedWriter;
import java.io.*;
import java.util.Date;
import static java.util.Objects.isNull;

/**
 * Classe básica para um Grafo simples não direcionado.
 */

public abstract class Grafo {
    public final String nome;
    protected ABB<Vertice> vertices;

    /**
     * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso de nome não informado 
     * (string vazia), recebe o nome genérico "Grafo"
     */
    public Grafo(String nome){
        if(nome.length()==0) 
            this.nome = "Grafo";
        else
            this.nome = nome;
        this.vertices = new ABB<>();
    }

    /**
     * Retorna o nome do grafo (string), caso seja necessário em outras classes/sistemas
     * @return O nome do grafo (uma string)
     */
    public String nome(){
        return this.nome;
    }

    /**
     * Verifica se um grafo já possui um vértice passado como parâmetro.
     * Caso a vértice já exista, o comando é ignorado e retorna NULL.
     * @param idVertice Id do vértice a ser verificado
     * @return Vertice se existe, NULL caso contrário
     */
    public Vertice existeVertice(int idVertice){
        Vertice vertice = vertices.find(idVertice);
        return vertice;
    }

    /**
     * Checa se existe uma aresta entre dois vértices A e B
     * @param verticeA Vértice A
     * @param verticeB Vértice B
     * @return Aresta caso exista, NULL caso contrário
     */
    public Aresta existeAresta(int verticeA, int verticeB){
        Vertice origem = this.existeVertice(verticeA);
        Vertice destino = this.existeVertice(verticeB);

        if (origem != null && destino != null) {
            return origem.existeAresta(verticeB);
        }

        return null;
    }

    /**
     * Verifica se o grafo é completo, ou seja, se todos os vértices do grafo estão conectados entre si.
     *
     * @return true se o grafo é completo, false caso contrário.
     */
    public boolean completo(){
        int cont = 0;

        Vertice[] arrayVertice = new Vertice[vertices.size()];
        vertices.allElements(arrayVertice);
        for (Vertice vertice : arrayVertice) {
            for (Vertice verticeASerComparado : arrayVertice) {
                if(vertice.existeAresta(verticeASerComparado.getId()) != null &&
                   vertice.getId() != verticeASerComparado.getId()){
                    cont++;

                }
            }
        }

        return vertices.size() * (vertices.size() - 1) == cont;
    }

    /**
     * Gera um subgrafo a partir de uma lista de vértices. Caso algum dos vértices não exista no grafo, retorna null.
     * Caso exista aresta entre dois vértices da lista, essa aresta será adicionada no subgrafo
     * @param vertices Lista de vértices para criar o subgrafo
     * @return Subgrafo com os vértices informados e suas arestas entre si
     */
    public Grafo subGrafo(Lista<Integer> vertices){
        GrafoMutavel subgrafo = new GrafoDirecionado("Subgrafo de " + this.nome);

        Integer[] verticesArr  = new Integer[vertices.size()];
        vertices.allElements(verticesArr);

        for (Integer vertice : verticesArr) {
            if (this.existeVertice(vertice) != null) subgrafo.addVertice(vertice);
            else return null;
        }

        for (Integer vertice : verticesArr) {
            ABB<Aresta> arestaABB = this.existeVertice(vertice).getArestas();
            Aresta[] arestas = new Aresta[arestaABB.size()];
            arestaABB.allElements(arestas);
            for (Aresta aresta : arestas) {
                int destino = aresta.destino();
                if (subgrafo.existeVertice(destino) != null)
                    subgrafo.addAresta(vertice, destino, aresta.peso());
            }
        }

        return subgrafo;
    }

    // busca em profundidade
    public Grafo dfs (int idVerticeInicial) {
        GrafoNaoDirecionado grafoNaoDirecionado = new GrafoNaoDirecionado("Grafo gerado pela dfs");
        Stack<Vertice> stack = new Stack<>();
        stack.push(vertices.find(idVerticeInicial));
        while (!stack.empty()) {
            Vertice verticeAtual = stack.pop();
            if (!verticeAtual.visitado()) {
                verticeAtual.visitar();
                grafoNaoDirecionado.addVertice(verticeAtual.getId());
                List<Integer> vizinhos = verticeAtual.getVizinhos();
                for (Integer vizinho: vizinhos) {
                    Vertice verticeVizinho = vertices.find(vizinho);
                    if (!verticeVizinho.visitado()) {
                        stack.push(verticeVizinho);
                        grafoNaoDirecionado.addVertice(vizinho);
                        grafoNaoDirecionado.addAresta(verticeAtual.getId(), vizinho, 0);
                    }
                }
            }
        }
        return grafoNaoDirecionado;
    }

    public Grafo bfs (int idVerticeInicial) {
        GrafoNaoDirecionado grafoNaoDirecionado = new GrafoNaoDirecionado("Grafo gerado pela bfs");
        Queue<Vertice> queue = new ArrayDeque<>();
        Vertice vInicial = vertices.find(idVerticeInicial);
        queue.add(vInicial);
        vInicial.visitar();
        grafoNaoDirecionado.addVertice(idVerticeInicial);

        while (!queue.isEmpty()) {
            Vertice vAtual = queue.remove();
            List<Integer> vizinhos = vAtual.getVizinhos();
            for (Integer vizinho: vizinhos) {
                Vertice verticeVizinho = vertices.find(vizinho);
                if (!verticeVizinho.visitado()) {
                    verticeVizinho.visitar();
                    grafoNaoDirecionado.addVertice(vizinho);
                    grafoNaoDirecionado.addAresta(vAtual.getId(), vizinho, 0);
                    queue.add(verticeVizinho);
                }
            }
        }
        return grafoNaoDirecionado;
    }

    /**
     * Retorna o tamanho (V + E) do grafo
     * @return Tamanho do grafo
     */
    public int tamanho(){
        int somaArestas = 0;
        Vertice[] verticesArr = new Vertice[vertices.size()];
        this.vertices.allElements(verticesArr);

        for (Vertice vertice : verticesArr) {
            somaArestas += vertice.grau();
        }

        return somaArestas + this.ordem();
    }

    /**
     * Retorna a ordem do grafo
     * @return Ordem do grafo
     */
    public int ordem(){
        return this.vertices.size();
    }

    public String imprimirGrafo() {
        StringBuilder sb = new StringBuilder();
        Vertice[] vertic = new Vertice[vertices.size()];
        vertic = vertices.allElements(vertic);
        for (Vertice eachVertice : vertic) {
            sb.append(eachVertice.getId());
            sb.append(" -> ");
            List<Integer> vizinhos = eachVertice.getVizinhos();
            for (Integer eachVizinho : vizinhos) {
                Vertice vizinhoVertice = vertices.find(eachVizinho);
                sb.append(vizinhoVertice.getId());
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

public void salvar(){
    Date dataHoraAtual = new Date();
    try {
        BufferedWriter saida = new BufferedWriter(new FileWriter(dataHoraAtual.toString().concat(".json")));
        saida.write(this.toString(), 0, 0);
        saida.close();    
    } catch (Exception e) {
        // TODO: handle exception
    }
}

public void salvar(String fileName){
    try {
        BufferedWriter saida = new BufferedWriter(new FileWriter(fileName));
        saida.write(this.toString(), 0, 0);
        saida.close();    
    } catch (Exception e) {
        // TODO: handle exception
    }
}

public String toString(){
    Vertice arrayVertice[] = new Vertice[vertices.size()];
    vertices.allElements(arrayVertice);
    String json = new String("[\n");
    for (Vertice vertice : arrayVertice) {
        json = json.concat("{\n\"id\":"+vertice.getId()+",\n\"vizinhos\": [\n");
        //System.out.println("{"+vertice.getId());
        Aresta arrayArestas[]  = new Aresta[vertice.getArestas().size()];
        vertice.getArestas().allElements(arrayArestas);
        for (Aresta aresta: arrayArestas) {
            json = json.concat("{\n\"id\":" + aresta.destino() + ",\n\"peso\": "+1+"\n},\n");
            //System.out.println("Destino da aresta: " + aresta.destino());

        }
        json = json.substring(0, json.length()-2);
        json = json.concat("\n]\n},");
    }
    json = json.substring(0, json.length()-1);
    json = json.concat("\n]");
    return json;

}
}