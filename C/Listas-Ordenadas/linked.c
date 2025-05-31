#include <stdio.h>
#include <stdlib.h>

typedef struct Dado {
    unsigned int valor;
    struct Dado* next;
} Dado;

Dado *createDado (unsigned int valor);
void append(Dado **dado, unsigned int valor);

int main () {
    
}

Dado *createDado (unsigned int valor) {
    Dado *newDado = (Dado*)malloc(sizeof(Dado));
    
    if (newDado != NULL) {
        newDado->valor = valor;
        newDado->next = NULL;
    }

    return newDado;
}

void append(Dado **dado, unsigned int valor) {
    
    Dado *newNode = createDado(valor);

    if(newNode == NULL) {
    printf("Memory allocation error!\n");
    return;
  }

  if  (*dado == NULL) {
    *dado = newNode;

  } else {
    Dado *temp = *dado;

    while (temp->next != NULL)
    {
        temp = temp->next;
    }

    temp->next = newNode;
  }

}