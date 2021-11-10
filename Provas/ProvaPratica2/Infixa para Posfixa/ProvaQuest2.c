#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_TAM 300

int paraInt(char operacao){
    if(operacao == '^'){
        return 3;
    } else if(operacao == '*'){
        return 2;
    } else if(operacao == '/'){
        return 2;
    } else if(operacao == '-'){
        return 1;
    } else if (operacao == '+'){
        return 1;
    } else {
        return 0;
    }
}

void paraPosfixa(const char *antes, char *depois){
    char linha[MAX_TAM];
    int i, z = 0, tmp = -1;
    char carac;

    for (i = 0; antes[i] != '\n' && antes[i] != '\0'; i++){
        carac = antes[i];

        if (carac == ' '){
            continue;
        }

        if (carac == '(')
        {
            linha[++tmp] = carac;
        } else if (carac == ')'){
            while (tmp > -1 && linha[tmp] != '(')
            {

                depois[z++] = linha[tmp--];
            }

            tmp--;
        } else if ((carac >= '0' && carac <= '9') || (carac >= 'a' && carac <= 'z') || (carac >= 'A' && carac <= 'Z')){
            depois[z++] = carac;
        } else{
            while (tmp > -1 && linha[tmp] != '(' && paraInt(linha[tmp]) >= paraInt(carac)){
                depois[z++] = linha[tmp--];
            }
            linha[++tmp] = carac;
        }
    }
    while (tmp > -1){
        depois[z++] = linha[tmp--];
    }
    depois[z++] = '\0';
}

int main(void){
    int N;
    char infixa[MAX_TAM], posfixa[MAX_TAM];
    scanf("%d\n", &N);

    while (N-- > 0){
        fgets(infixa, MAX_TAM, stdin);
        paraPosfixa(infixa, posfixa);
        printf("%s\n", posfixa);
    }

    return 0;
}



