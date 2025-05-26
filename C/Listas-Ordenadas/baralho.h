enum naipe {
    COPAS = 0,
    OUROS,
    ESPADAS,
    PAUS
};

typedef struct carta_t {
    int index;
    int rank;
    enum naipe naipe;
    struct carta_t *next;
    struct carta_t *prev;
}carta_t;


void criarBaralho(carta_t *baralho[], int size);

void mostarBaralho(carta_t *baralho[], int size);

void mostrarCarta(carta_t *carta);