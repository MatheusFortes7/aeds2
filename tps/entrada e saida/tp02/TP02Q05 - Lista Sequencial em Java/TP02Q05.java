import java.io.*;
import java.io.FileReader;

//Classe séries
class Serie {
    private String nome;
    private String formato;
    private String duracao;
    private String pais;
    private String idioma;
    private String emissora;
    private String transmissao;
    private int temporada;
    private int episodios;

    public Serie() {
        nome = "";
        formato = "";
        duracao = "";
        pais = "";
        idioma = "";
        emissora = "";
        transmissao = "";
        temporada = ' ';
        episodios = ' ';
    }

    public Serie(String nome, String formato, String duracao, String pais, String idioma, String emissora,
            String transmissao, int temporada, int episodios) {
        this.nome = nome;
        this.formato = formato;
        this.duracao = duracao;
        this.pais = pais;
        this.idioma = idioma;
        this.emissora = emissora;
        this.transmissao = transmissao;
        this.temporada = temporada;
        this.episodios = episodios;
    }

    // clone
    public Serie clone() {
        Serie temp = new Serie();

        temp.nome = this.nome;
        temp.formato = this.formato;
        temp.duracao = this.duracao;
        temp.pais = this.pais;
        temp.idioma = this.idioma;
        temp.emissora = this.emissora;
        temp.transmissao = this.transmissao;
        temp.temporada = this.temporada;
        temp.episodios = this.episodios;

        return temp;
    }

    // SET
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setEmissora(String emissora) {
        this.emissora = emissora;
    }

    public void setTransmissao(String transmissao) {
        this.transmissao = transmissao;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    // GET
    public String getNome() {
        return nome;
    }

    public String getFormato() {
        return formato;
    }

    public String getDuracao() {
        return duracao;
    }

    public String getPais() {
        return pais;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getEmissora() {
        return emissora;
    }

    public String getTransmissao() {
        return transmissao;
    }

    public int getTemporada() {
        return temporada;
    }

    public int getEpisodios() {
        return episodios;
    }

    // Print
    public void printSerie() {
        System.out.println(this.nome + " " + this.formato + " " + this.duracao + " " + this.pais + " " + this.idioma
                + " " + this.emissora + " " + this.transmissao + " " + this.temporada + " " + this.episodios);
    }

    public String removeTag(String line) {
        String newLine = "";
        int i = 0;

        while (i < line.length()) {

            if (line.charAt(i) == '<') {
                i++;
                while (line.charAt(i) != '>') {
                    i++;
                }
            } else if (line.charAt(i) == '&') {
                i++;
                while (line.charAt(i) != ';')
                    i++;
            } else {
                newLine += line.charAt(i);
            }
            i++;
        }
        return newLine;
    }

    // pega o nome da serie
    public String pegaNome(String entrada) {
        String aux = "";
        for (int i = 0; i < entrada.length(); i++) {
            if (entrada.charAt(i) == '_') {
                aux += ' ';
            } else {
                aux += entrada.charAt(i);
            }
        }
        aux = aux.substring(0, aux.length() - 5);
        return aux;
    }

    // pega os inteiros da String
    public int transformaINT(String line) {
        String aux = "";

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                aux += line.charAt(i);
            } else {
                i = line.length();
            }
        }
        // Converte o aux para int
        return Integer.parseInt(aux);
    }

    public void ler(String entrada) {
        String arquivo = "/tmp/series/" + entrada;
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fileReader);

            setNome(pegaNome(entrada));

            while (!br.readLine().contains("Formato"))
                ;
            setFormato(removeTag(br.readLine()));

            while (!br.readLine().contains("Duração"))
                ;
            setDuracao(removeTag(br.readLine()));

            while (!br.readLine().contains("País de origem"))
                ;
            setPais(removeTag(br.readLine()));

            while (!br.readLine().contains("Idioma original"))
                ;
            setIdioma(removeTag(br.readLine()));

            while (!br.readLine().contains("Emissora de televisão original"))
                ;
            setEmissora(removeTag(br.readLine()));

            while (!br.readLine().contains("Transmissão original"))
                ;
            setTransmissao(removeTag(br.readLine()));

            while (!br.readLine().contains("N.º de temporadas"))
                ;
            setTemporada(transformaINT(removeTag(br.readLine())));

            while (!br.readLine().contains("N.º de episódios"))
                ;
            setEpisodios(transformaINT(removeTag(br.readLine())));

            br.close();

        } catch (FileNotFoundException e) {
            MyIO.println("ERROR: Unable to open file '" + entrada + "'");
        } catch (IOException e) {
            MyIO.println("ERROR: Error reading file '" + entrada + "'");
        }
    }

}

// lista
class CellSerie {

    public Object item;
    public CellSerie next;
    public CellSerie back;

    public CellSerie() {
        item = null;
        next = null;
        back = null;
    }

    public CellSerie(Object value) {
        item = value;
        next = null;
        back = null;
    }

    public CellSerie(Object value, CellSerie nextCell, CellSerie backCell) {
        item = value;
        next = nextCell;
        back = backCell;
    }
}

class ListSerie {
    private CellSerie first;
    private CellSerie last;
    private int qt;

    public ListSerie() {
        first = new CellSerie();
        last = first;
        qt = 0;
    }

    // GET
    public Object getFirst() {
        Object temp = null;
        if (first != last) {
            temp = first.next.item;
        }
        return temp;
    }

    public Object getLast() {
        return last.item;
    }

    public Object getItemAt(int index) {
        Object resp = null;
        if (index == 1) {
            resp = getFirst();
        } else if (index == qt) {
            resp = getLast();
        } else if ((index > 1 && index < qt) && first != last) {
            CellSerie temp = first;
            for (int i = 0; i < index; i++, temp = temp.next)
                ;
            resp = temp.item;
        } else {
            MyIO.println("ERRO:" + index);
        }
        return resp;
    }

    public int getQuantity() {
        return qt;
    }

    // insercao inicio
    public void insertStart(Object value) {
        CellSerie temp = new CellSerie(value, first.next, first);
        first.next = temp;
        if (first == last) {
            last = temp;
        } else {
            temp.next.back = temp;
        }
        qt++;
    }

    // insercao no final
    public void insertEnd(Object value) {
        last.next = new CellSerie(value, null, last);
        last = last.next;
        qt++;
    }

    // isercao no index
    public void insertIndex(Object value, int index) {
        if (index == 0) {
            this.insertStart(value);
        } else if (index == qt) {
            this.insertEnd(value);
        } else if ((index > 0 && index < qt) && first != last) {
            CellSerie temp = first;
            for (int i = 0; i < index; i++, temp = temp.next)
                ;
            CellSerie aux = new CellSerie(value);
            aux.back = temp;
            aux.next = temp.next;
            aux.back.next = aux.next.back = aux;
            aux = temp = null;
            qt++;
        } else {
            MyIO.println("ERRO:" + index);
        }
    }

    // print
    public void printListSerie() {
        for (CellSerie temp = first.next; temp != last.next; temp = temp.next) {
            MyIO.println(temp.item + " ");
        }
    }

    // remove first
    public Object removeStart() {
        Object temp = null;
        if (first != last) {
            CellSerie aux = first;
            first = first.next;
            temp = first.item;
            aux.next = first.back = null;
            qt--;
        }
        return temp;
    }

    // remove o ultimo
    public Object removeEnd() {
        Object temp = null;
        if (first != last) {
            temp = last.item; // Obtem o objeto do last
            last = last.back;
            last.next.back = null;
            last.next = null;
            qt--;
        }
        return temp;
    }

    // remove o index
    public Object removeIndex(int index) {
        Object resp = null;
        if (index == 0) {
            resp = removeStart();
        } else if (index == qt - 1) {
            resp = removeEnd();
        } else if ((index > 0 && index < qt) && (first != last)) {

            CellSerie temp = first;
            for (int i = 0; i <= index; i++, temp = temp.next)
                ;// Encontra o valor do index

            temp.back.next = temp.next;
            temp.next.back = temp.back;

            resp = temp.item;
            temp.next = temp.back = null;
            temp = null;

            qt--;
        } else {
            MyIO.println("ERRO: " + index + "invalido");
        }
        return resp;
    }

}

public class TP02Q05 {
    // fim
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void alterList(String entrada, Serie series, ListSerie lista) {
        int temp;
        if (entrada.charAt(0) == 'I' && entrada.charAt(1) == 'I') {
            series.ler(entrada.substring(3)); // Retira o comando
            lista.insertStart(series);

        } else if (entrada.charAt(0) == 'I' && entrada.charAt(1) == '*') {
            // Entrada no valor indicado
            if (entrada.charAt(4) == ' ') {
                // Se a posicao for de apenas um digito
                series.ler(entrada.substring(5));// Retira o comando e a posicao
                temp = 4;
            } else {
                // Se a posicao possuir 2 digitos
                series.ler(entrada.substring(6));
                temp = 5;
            }
            lista.insertIndex(series, Integer.parseInt(entrada.substring(3, temp)));
            series = (Serie) lista.getItemAt(Integer.parseInt(entrada.substring(3, temp)));

        } else if (entrada.charAt(0) == 'I' && entrada.charAt(1) == 'F') {
            // Entrada no fim
            series.ler(entrada.substring(3));
            lista.insertEnd(series);

        } else if (entrada.charAt(0) == 'R' && entrada.charAt(1) == 'I') {
            // Remocao no inicio
            series = (Serie) lista.removeStart();
            // Remove da lista
            MyIO.println("(R) " + series.getNome());
            // Imprime o nome da serie removida
        } else if (entrada.charAt(0) == 'R' && entrada.charAt(1) == '*') {
            // Remocao no valor indicado
            series = (Serie) lista.removeIndex(Integer.parseInt(entrada.substring(3)));
            MyIO.println("(R) " + series.getNome());
        } else if (entrada.charAt(0) == 'R' && entrada.charAt(1) == 'F') {
            // Remocao no fim
            series = (Serie) lista.removeEnd();
            MyIO.println("(R) " + series.getNome());
        }
    }

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        Serie series = new Serie();
        ListSerie lista = new ListSerie();
        int aux = 0, i, stop;

        do {
            entrada[aux] = MyIO.readLine();
        } while (isFim(entrada[aux++]) == false);

        for (i = 0; i < (aux - 1); i++) {
            series.ler(entrada[i]);
            lista.insertEnd(series.clone());
        }

        aux = 0;
        stop = MyIO.readInt(); // total de alterações
        do {
            entrada[aux] = MyIO.readLine();
            aux++;
        } while (aux < stop);

        for (i = 0; i < aux; i++) {
            System.out.println(entrada[i]);
        }

        for (i = 0; i < (aux - 1); i++) {
            series.ler(entrada[i]);
            lista.insertEnd(series.clone());
        }

        // segunda parte
        aux = 0;
        stop = MyIO.readInt(); // total de alterações
        do {
            entrada[aux] = MyIO.readLine();
            aux++;
        } while (aux < stop);
        // faxz as alteracoes
        for (i = 0; i < aux - 1; i++) {
            alterList(entrada[i], series.clone(), lista);
        }
        // imprime
        aux = lista.getQuantity();
        for (i = 1; i <= aux; i++) {
            series = (Serie) lista.getItemAt(i);
            series.printSerie();

        }

    }
}