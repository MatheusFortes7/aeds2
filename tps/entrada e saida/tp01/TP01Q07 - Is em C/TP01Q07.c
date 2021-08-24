#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool isFim(char s[]){
    return (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

int isVogal(char s[]){
    for(int i = 0 ; i < strlen(s); i++){ //corre a string armazenando os caracteres de traz para frente
        if(s[i] != 'a' && s[i] != 'e' && s[i] != 'i' && s[i] != 'o' && s[i] != 'u' ){
            i = strlen(s);
            return "NAO";
        }      
    }
    return "SIM";
}

int isConsoante(char s[]){
    for(int i = 0; i < strlen(s); i++){
    if(strlen(s) == 'a' && strlen(s) == 'e' && strlen(s) == 'i' && strlen(s) == 'o' && strlen(s) == 'u'){
            i = strlen(s);
            return "NAO";
        }
    }
    return "SIM";
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

