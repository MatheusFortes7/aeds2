import java.io.*;
import java.io.FileReader;
import java.util.*;
import java.lang.Integer.*;

class Alunos extends Lista{
    private String nome;
    private Character regiao;
    private int custo;

    public  Alunos() {
        nome = "";
        regiao = ' ';
        custo = 0;
    }

    public  Alunos(String nome, Character regiao, int custo) {
        this.nome = nome;
        this.regiao = regiao;
        this.custo = custo;
    }

    public  void setNome(String nome) {
        this.nome = nome;
    }

    public  String getNome() {
        return this.nome;
    }

    public  void setRegiao(Character regiao) {
        this.regiao = regiao;
    }

    public  Character getRegiao() {
        return this.regiao;
    }

    public  void setCusto(int custo) {
        this.custo = custo;
    }

    public  int getCusto() {
        return this.custo;
    }

    public void readClass(String entrada){
        int i = 0;
        String dados[] = new String[3];

        dados = entrada.split(" ");

        this.nome = dados[0];
        Character teste = dados[1].charAt(0);
        this.regiao = teste;
        this.custo = Integer.parseInt(dados[2]);
        //for(int j = 0; i < 3; i++){
        //    System.out.println(dados[i]);
        //}
    }

    public void printClass(){
        System.out.println(this.nome);
    }
}

class Lista {
    private Alunos[] array;
    private int n;

    /**
     * Construtor da classe.
     */
    public Lista() {
        this(70);
    }

    /**
     * Construtor da classe.
     * 
     * @param tamanho Tamanho da lista.
     */
    public Lista(int tamanho) {
        array = new Alunos[tamanho];
        n = 0;
    }

    /**
     * Insere um elemento na primeira posicao da lista e move os demais elementos
     * para o fim da lista.
     * 
     * @param x int elemento a ser inserido.
     * @throws Exception Se a lista estiver cheia.
     */
    public void inserirInicio(Alunos x) throws Exception {

        // validar insercao
        if (n >= array.length) {
            throw new Exception("Erro ao inserir!");
        }

        // levar elementos para o fim do array
        for (int i = n; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = x;
        n++;
    }

    /**
     * Insere um elemento na ultima posicao da lista.
     * 
     * @param x int elemento a ser inserido.
     * @throws Exception Se a lista estiver cheia.
     */
    public void inserirFim(Alunos x) throws Exception {
        // validar insercao
        if (n >= array.length) {
            throw new Exception("Erro ao inserir!");
        }

        array[n] = x;
        n++;
    }

    /**
     * Insere um elemento em uma posicao especifica e move os demais elementos para
     * o fim da lista.
     * 
     * @param x   int elemento a ser inserido.
     * @param pos Posicao de insercao.
     * @throws Exception Se a lista estiver cheia ou a posicao invalida.
     */
    public void inserir(Alunos x, int pos) throws Exception {

        // validar insercao
        if (n >= array.length || pos < 0 || pos > n) {
            throw new Exception("Erro ao inserir!");
        }

        // levar elementos para o fim do array
        for (int i = n; i > pos; i--) {
            array[i] = array[i - 1];
        }

        array[pos] = x;
        n++;
    }

    /**
     * Remove um elemento da primeira posicao da lista e movimenta os demais
     * elementos para o inicio da mesma.
     * 
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia.
     */
    public Alunos removerInicio() throws Exception {

        // validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover!");
        }

        Alunos resp = array[0];
        n--;

        for (int i = 0; i < n; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }

    /**
     * Remove um elemento da ultima posicao da lista.
     * 
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia.
     */
    public Alunos removerFim() throws Exception {

        // validar remocao
        if (n == 0) {
            throw new Exception("Erro ao remover!");
        }

        return array[--n];
    }

    /**
     * Remove um elemento de uma posicao especifica da lista e movimenta os demais
     * elementos para o inicio da mesma.
     * 
     * @param pos Posicao de remocao.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
     */
    public Alunos remover(int pos) throws Exception {

        // validar remocao
        if (n == 0 || pos < 0 || pos >= n) {
            throw new Exception("Erro ao remover!");
        }

        Alunos resp = array[pos];
        n--;

        for (int i = pos; i < n; i++) {
            array[i] = array[i + 1];
        }

        return resp;
    }

    /**
     * Mostra os elementos da lista separados por espacos.
     */
    public void mostrar() {
        // System.out.print("[ ");
        for (int i = 0; i < n; i++) {
            array[i].printClass();
            
        }
        // System.out.println("]");
    }

    /**
     * Procura um elemento e retorna se ele existe.
     * 
     * @param x int elemento a ser pesquisado.
     * @return <code>true</code> se o array existir, <code>false</code> em caso
     *         contrario.
     */
    public boolean pesquisar(Alunos x) {
        boolean retorno = false;
        for (int i = 0; i < n && retorno == false; i++) {
            retorno = (array[i] == x);
        }
        return retorno;
    }

    public void SelectionSort() {
        for (int i = 0; i < (n - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < n; j++) {
                if (array[menor].getCusto() > array[j].getCusto()) {
                    menor = j;
                } else if(array[menor].getCusto() == array[j].getCusto()){
                    if(array[menor].getRegiao() > array[j].getRegiao()){
                        menor = j;
                    }
                } else if(array[menor].getCusto() == array[j].getCusto() && array[menor].getRegiao() == array[j].getRegiao()){
                    if(array[menor].getNome().compareTo(array[j].getNome()) > 0){
                        menor = j;
                    }
                }
            }
            swap(menor, i);
        }
    }
  
    public void SelectionSortRegiao() {
        for (int i = 0; i < (n - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < n; j++) {
                if (array[menor].getRegiao() > array[j].getRegiao()) {
                    menor = j;
                }
            }
            swap(menor, i);
        }
    }

    public void SelectionSortNome() {
        for (int i = 0; i < (n - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < n; j++) {
                if (array[menor].getNome().compareTo(array[j].getNome()) > 0) {
                    menor = j;
                }
            }
            swap(menor, i);
        }
    }

    public void swap(int i, int primeiro) {
        Alunos aux = array[i];
        array[i] = array[primeiro];
        array[primeiro] = aux;
    }

    // 0 strings iguals
    // > 0 Tem letra
}

class Van {

    public static int justInt(String line) {
        String resp = "";
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) >= '0' && line.charAt(i) <= '9') { // caso o caracter seja um número ele é concatenado a
                                                                  // variável resp
                resp += line.charAt(i);
            } else { // caso seja outro caracter, o i recebe o valor da condição de parada e o método
                     // de repetição é encerrado
                i = line.length();
            }
        }
        return Integer.parseInt(resp); // conversão da string resp para número inteiro a ser retornado
    }

    public static void main(String[] args) throws Exception{
        int leitura;
        Alunos aluno = new Alunos();
        String[] input = new String[1000];
        int numInput = 0;
        Lista lista = new Lista();
        leitura = justInt(MyIO.readLine());

        for (int i = 0; i < leitura; i++) {
            input[numInput] = MyIO.readLine();
            numInput++;
        }
        for (int i = 0; i < numInput; i++) {
            aluno = new Alunos();
            aluno.readClass(input[i]);
            lista.inserirFim(aluno);
        }

        lista.SelectionSort();
        lista.mostrar();
    }

}