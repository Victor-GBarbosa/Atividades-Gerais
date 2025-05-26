#include <stdio.h>
#include <stdlib.h>
#include "baralho.h"

void main () {
    printf("debug 1\n");
    carta_t *baralho[52];
    printf("debug 2\n");
    criarBaralho(baralho, 1);
    printf("debug 3\n");
    mostarBaralho(baralho, 52);
    printf("debug 4\n");

    mostrarCarta(baralho[5]);
    
}