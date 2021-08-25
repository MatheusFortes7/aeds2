#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>

bool isFim(char s[]){
    return (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

int isVogal(char s[]){
    char z[] = tolower(s);
    bool resp = false;
    for(int i = 0 ; i < strlen(z); i++){ //corre a string armazenando os caracteres de traz para frente
        if(z[i] != 'a' || z[i] != 'e' || z[i] != 'i' || z[i] != 'o' || z[i] != 'u' ){
            i = strlen(z);
            resp = false;
        } else {
            resp = true;
        }     
    }
    if (resp == false){
        return "NAO";
    } else {
        return "SIM";
    }
}

int isConsoante(char s[]){
    char z[] = tolower(s);
    bool resp  = false;
    for(int i = 0; i < strlen(z); i++){
    if(z[i] == 'a' || z[i] == 'e' || z[i] == 'i' || z[i] == 'o' || z[i] == 'u'){
            i = strlen(z);
            resp = false;
        } else {
            resp = true;
        }
    }
    if (resp == false){
        return "NAO";
    } else {
        return "SIM";
    }
}

//FALTA VER SE É INTEIRO (QUE NAO SEI COMO), E QUANDO ELE E U NUMERO REAL <----------------------------------------------------- IMPORTANTE

int main(){
    char entrada[1000][100];
    int numEntrada = 0;

    // Leitura da entrada padrao
    do{
        scanf(" %[^\n]s", entrada[numEntrada]);
    } while (isFim(entrada[numEntrada++]) == false);
    numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

    // Para cada linha de entrada, gerando uma de saida contendo o numero de letras
    // maiusculas da entrada
    for (int i = 0; i < numEntrada; i++){
        printf(isVogal(entrada[i]) + isConsoante(entrada[i]) );
    }
    return 0;
}

