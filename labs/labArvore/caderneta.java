import java.io.*;
import java.util.*;

class Contato{
    public String nome;
    public String telefone;
    public String email;
    public int cpf;

    public Contato(){
        nome = "";
        telefone = "";
        email = "";
        cpf = 0;
    }

    public Contato(String nome, String telefone, String email, int cpf){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    } 
    public void setEmail(String email){
        this.email = email;
    } 
    public void setCpf(int cpf){
        this.cpf = cpf;
    } 
   

}

class Celula{
    public Contato item;
    public Celula prox;

    public Celula(){
        item = new Contato();
        prox = null;
    }

    Celula(Contato contato){
        item = contato;
        prox = null;
    }
}

class No{
    public char letra;
    public No esq;
    public No dir;
    public Celula primeiro;
    public Celula ultimo;

    public No(){
        letra = ' ';
        esq = dir = null;
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public No(char letra){
        this.letra = letra;
        esq = dir = null;
        primeiro = new Celula();
        ultimo = primeiro;
    }
}

class Agenda{
    public No raiz;

    Agenda(){
        raiz = null;
    }

    public void inserir(Contato contato){
        raiz = inserir(contato, raiz);
    }
    private No inserir(Contato contato, No i){
        if(i == null){
            i = new No(contato.nome.toUpperCase().charAt(0));
            i.ultimo.prox = new Celula(contato);
            i.ultimo = i.ultimo.prox;
        } else if(contato.nome.toUpperCase().charAt(0) < i.letra){
            i.esq = inserir(contato, i.esq);
        } else if(contato.nome.toUpperCase().charAt(0) > i.letra){
            i.dir = inserir(contato, i.dir);
        } else {
            i.ultimo.prox = new Celula(contato);
            i.ultimo = i.ultimo.prox;
        }
        return i;
    }


    public void remover(String nome){

    }

    public boolean pesquisar(int cpf){
        return pesquisar(cpf, raiz);
    }

    private boolean pesquisar(int cpf, No i){
        boolean resp = false;
        if(i != null){
            Celula tmp = i.primeiro.prox;
            while(tmp != null){
                if(tmp.item.cpf == cpf){
                    resp = true;
                    tmp = null;
                } else {
                    tmp = tmp.prox;
                }
            }
            if(resp == false){
                resp = pesquisar(cpf, i.esq);
                if(resp == false){
                    resp = pesquisar(cpf, i.dir);
                }
            }
        }
        return resp;
    }


}

class caderneta{

}