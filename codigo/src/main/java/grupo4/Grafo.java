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

import static java.util.Objects.isNull;

/**
 * Classe básica para um Grafo simples não direcionado.
 */

public class Grafo {
    public final String nome;
    private ABB<Vertice> vertices;

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


    public void carregar(String nomeArquivo){

    }

    public void salvar(String nomeArquivo){
        Vertice arrayVertice[] = new Vertice[vertices.size()];
        vertices.allElements(arrayVertice);
        for (Vertice vertice : arrayVertice) {
            System.out.println(vertice.getId());
            System.out.println(vertice.toString());
        }
    }
    
    /**
     * Adiciona um vértice com o id especificado. Ignora a ação e retorna false se já existir
     * um vértice com este id
     * @param id O identificador do vértice a ser criado/adicionado
     * @return TRUE se houve a inclusão do vértice, FALSE se já existia vértice com este id
     */
    public boolean addVertice(int id){
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    public Vertice removeVertice(int id){
        return null;
    }

    /**
     * Verifica se um grafo já possui um vértice passado como parâmetro.
     * Caso a vértice já exista, o comando é ignorado e retorna NULL.
     * @param idVertice Id do vértice a ser verificado
     * @return Vertice se existe, NULL caso contrário
     */
    public Vertice existeVertice(int idVertice){
        Vertice vertice = vertices.find(idVertice);
        if (isNull(vertice)) {
            return null;
        }
        return vertice;
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo, caso os dois vértices existam no grafo. 
     * Caso a aresta já exista, ou algum dos vértices não existir, o comando é ignorado e retorna FALSE.
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     * @param peso Peso da aresta
     * @return TRUE se foi inserida, FALSE caso contrário
     */
    public boolean addAresta(int origem, int destino, int peso){
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if(saida!=null && chegada !=null){
            adicionou = (saida.addAresta(destino, peso)&&chegada.addAresta(origem, peso));
        }
        return adicionou;

    }

    public Aresta removeAresta(int origem, int destino){
        return null;
    }

    /**
     * Checa se existe uma aresta entre dois vértices A e B
     * @param verticeA Vértice A
     * @param verticeB Vértice B
     * @return Aresta caso exista, NULL caso contrário
     */
    public Aresta existeAresta(int verticeA, int verticeB){
        Vertice va = this.existeVertice(verticeA);
        Vertice vb = this.existeVertice(verticeB);

        if (va != null) {
            Aresta aresta = va.existeAresta(verticeB);
            if (aresta != null) return aresta;
        }
        if (vb != null) return vb.existeAresta(verticeA);

        return null;
    }

    /**
     * Verifica se o grafo é completo, ou seja, se todos os vértices do grafo estão conectados entre si.
     *
     * @return true se o grafo é completo, false caso contrário.
     */
    public boolean completo(){
        int cont = 0;

        Vertice arrayVertice[] = new Vertice[vertices.size()];
        vertices.allElements(arrayVertice);
        for (Vertice vertice : arrayVertice) {
            for (Vertice verticeASerComparado : arrayVertice) {
                if(vertice.existeAresta(verticeASerComparado.getId()) != null &&
                   vertice.getId() != verticeASerComparado.getId()){
                    cont++;

                }
            }
        }

        if(vertices.size() * (vertices.size() - 1) == cont){
            return true;
        }
       return false;
    }

    /**
     * Cria um grafo completo com a ordem e nome especificados.
     *
     * @param ordem A ordem do grafo (número de vértices).
     * @param nomeGrafo O nome do grafo.
     * @return Um objeto Grafo completo.
     */
    public static Grafo grafoCompleto(int ordem, String nomeGrafo){

        Grafo grafo = new Grafo(nomeGrafo);
        for(int i = 1; i <= ordem; i++){
            grafo.addVertice(i);
        }

        for(int verticeAtual = 1; verticeAtual <= ordem; verticeAtual++){
            for(int verticeDestino = 1; verticeDestino < ordem; verticeDestino++){
                if(verticeAtual != verticeDestino) {
                    grafo.addAresta(verticeAtual, verticeDestino, 0);
                }
            }
        }
        return grafo;
    }

    public Grafo subGrafo(Lista<Integer> vertices){
        Grafo subgrafo = new Grafo("Subgrafo de " + this.nome);
        
        return subgrafo;
    }
    
    public int tamanho(){
        return Integer.MIN_VALUE;
    }

    public int ordem(){
        return Integer.MIN_VALUE;
    }

}
