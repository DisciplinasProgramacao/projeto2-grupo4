[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-8d59dc4de5201274e310e4c54b9627a8934c3b88527886e3b421487c677d23eb.svg)](https://classroom.github.com/a/_jy02Gvr)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-f4981d0f882b2a3f0472912d15f9806d57e124e0fc890972558857b51b24a6f9.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=10598215)
# Algoritmos em Grafos
Esse repositório tem como foco o estudo e implementação focada em tipos diversos de Grafos. Dentre eles:
- Grafo Completo
- Grafo Direcionado
- Grafo Não direcionado

Algoritmos de busca dentro da classe Abstrata Grafo:
- Busca em profundidade
- Busca em largura

Estruturas de dados presentes para o funcionamento geral da aplicação:
- Árvore Binária de Busca <ABB>
- Lista Duplamente Encadeada <List>

- Projeto testado unitariamente com Junit5

## Correção e comentários

### Nota: 13,2

Grafo de teste

![Grafo de teste](docs/grafoTeste.png)

---

- Método salvar usando length 0: não salva
- Exceção quando carrega: __Unexpected character (']' (code 93)): expected a valid value (number, String, array, object, 'true', 'false' or 'null') at [Source: (FileInputStream); line: 52, column: 1]__  (IDE aponta erro no JSON na linha 50 - um vértice sem vizinhos gera ] sem [ )
- Tamanho do grafo: esqueceu de dividir as arestas por 2 (lema do aperto de mãos)
- Corrigi o arquivo na mão e o método carregar retornou grafo vazio.
- DFS parece estar fazendo BFS (verifica todos os vizinhos em lugar de 'descer' no primeiro)
- App somente faz um teste. 

---

- Aderência às classes do diagrama: 2/2 pontos
- Requisitos de grafos corretamente implementados: 6,7/12 pontos
  - Carregar/salvar		0/2 pontos
  - Grafo completo e subgrafo 2,7/3 pontos
  - Grafo direcionado/não direcionado 2/2 pontos
  - Busca em largura e profundidade 2/4 pontos
  - App para uso 0/1 ponto
- Documentação de código: 3/4 pontos
  - Todos os filenames constam como nulo, sem instrução do que deve ser colocado ali
- Testes (quantidade e qualidade): 1,5/2 pontos
  - boa cobertura, porém teste de leitura com erro e os erros apontados acima passaram.

## Alunos integrantes da equipe

* Fernando Couto
* Gabriel Borges
* Rafael Pierre
* Tito Li An Chen
* vinicius Lima

## Professores responsáveis

* João Caram

