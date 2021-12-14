#include "stdio.h"
#include "stdlib.h"

int main(){

  int caixas, numPilhas, cx, pilhaDeCaixas, somaEsq, somaDir, alt1, pilha, altura;
  scanf("%d %d", &caixas, &numPilhas);

  while (caixas != 0)
  {
    int h[numPilhas + 1];
    somaDir = 0;
    somaEsq = 0;

    for (int i = 0; i < numPilhas; i++)
    {
      scanf("%d", &pilhaDeCaixas);
      for (int j = 0; j < pilhaDeCaixas; j++)
      {
        scanf("%d", &cx);
        if (cx == 1)
        {
          pilha = i;
          alt1 = j + 1;
        }
      }
      h[i] = pilhaDeCaixas;
    }

    for (int i = 0; i < pilha; i++)
    {
      if (h[i] >= alt1)
      {
        somaDir = somaDir + h[i] + 1 - alt1;
      }
      else
      {
        somaDir = 0;
      }
    }
    for (int i = pilha + 1; i < numPilhas; i++)
    {
      if (h[i] >= alt1)
      {
        somaEsq = somaEsq + h[i] + 1 - alt1;
      }
      else
      {
        i = numPilhas;
      }
    }
    somaDir = somaDir + h[pilha] - alt1;
    somaEsq = somaEsq + h[pilha] - alt1;

    if (somaDir > somaEsq)
    {
      printf("%d\n", somaEsq);
    }
    else
    {
      printf("%d\n", somaDir);
    }
    scanf("%d %d", &caixas, &numPilhas);
  }
  return 0;
}