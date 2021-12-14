#include <iostream>
#include <sstream>
#include <cstdio>
#include <cctype>

using namespace std;

bool booleano, enter = false;

struct no{
   no *esq;
   string elemento;
   no *dir;
   no(string info) : elemento(info),
                     esq(0),
                     dir(0) {}
};

struct no *inserir(no *arvoreBinaria, string elemento){
   if (arvoreBinaria == NULL){
      arvoreBinaria = new no(elemento);
   } else {
      int i = 0;
      while (i > -1){
         if (elemento[i] < arvoreBinaria->elemento[i]){
            arvoreBinaria->esq = inserir(arvoreBinaria->esq, elemento);
            break;
         } else if (elemento[i] > arvoreBinaria->elemento[i]) {
            arvoreBinaria->dir = inserir(arvoreBinaria->dir, elemento);
            break;
         } else
            i++;
      }
   }
   return arvoreBinaria;
};

struct no *pesquisaNo(no *arvoreBinaria, string elemento){
   if (arvoreBinaria != NULL){
      if (elemento == arvoreBinaria->elemento){
         booleano = true;
         return arvoreBinaria;
      } else {
         int i = 0;
         while (i > -1){
            if (elemento[i] < arvoreBinaria->elemento[i]){
               arvoreBinaria->esq = pesquisaNo(arvoreBinaria->esq, elemento);
               break;
            } else if (elemento[i] > arvoreBinaria->elemento[i]) {
               arvoreBinaria->dir = pesquisaNo(arvoreBinaria->dir, elemento);
               break;
            } else
               i++;
         }
      }
   }
   return arvoreBinaria;
};

bool pesquisa(no *arvoreBinaria, string elemento){
   if (arvoreBinaria != NULL){
      arvoreBinaria = pesquisaNo(arvoreBinaria, elemento);
      if (booleano || elemento == arvoreBinaria->elemento)
         return true;
      else
         return false;
   } else
      return false;
}

void caminharCentral(no *arvoreBinaria){
   if (arvoreBinaria != NULL){
      caminharCentral(arvoreBinaria->esq);
      cout << arvoreBinaria->elemento << endl;
      caminharCentral(arvoreBinaria->dir);
   }
}

int main(){
   no *raiz = 0;
   string linha, leitura = "", temp = "";
   char letra;
   booleano = false;

   while (getline(cin, linha)){
      stringstream streamlinha(linha);
      while (streamlinha >> leitura){
         int i = 0;
         while (i <= leitura.length()){
            if (isalpha(leitura[i])){
               letra = tolower(leitura[i]);
               temp += letra;
            } else if (temp.length() > 0 || (temp.length() == i && temp.length() > 0)){
               if (!pesquisa(raiz, temp)){
                  raiz = inserir(raiz, temp);
                  temp = "";
               } else {
                  temp = "";
                  booleano = false;
               }
            }
            i++;
         }
      }
   }
   caminharCentral(raiz);
   return 0;
}