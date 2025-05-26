#include "baralho.h"
#include <stdlib.h>
#include <stdio.h>

void criarBaralho() {
  
}

//Fazer uma função que imprima uma carta
void mostrarCarta(carta_t *carta) {

    if (carta == NULL) {
        printf("carta não existe");
    }
    switch (carta->naipe) {
        case COPAS:
            printf("%d de copas\n", carta->rank);
            break;
        case OUROS:
            printf("%d de ouros\n", carta->rank);
            break;
        case ESPADAS:
            printf("%d de espadas\n", carta->rank);
            break;
        case PAUS:
            printf("%d de paus\n", carta->rank);
            break;
        default:
            printf("%d de desconhecido\n", carta->rank);
            break;
    }
}

void mostarBaralho(carta_t baralho[], int size) {
    for (int i = 0; i < size; i++) {
        switch (baralho[i].naipe) {
            case COPAS:
                printf("%d de copas\n", baralho[i].rank);
                break;
            case OUROS:
                printf("%d de ouros\n", baralho[i].rank);
                break;
            case ESPADAS:
                printf("%d de espadas\n", baralho[i].rank);
                break;
            case PAUS:
                printf("%d de paus\n", baralho[i].rank);
                break;
            default:
                printf("%d de desconhecido\n", baralho[i].rank);
                break;
        }
    }
}

