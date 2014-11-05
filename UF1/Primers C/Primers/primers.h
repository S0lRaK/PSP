#include <stdio.h>

#define MAX_DIVISORS 6

typedef enum
{
	false,
	true
}bool;

void pausa();
bool esPrimer(int num);
void buscarDivisors(int num, int divisors[MAX_DIVISORS], int *numDivisors);
void mostrarDivisors(int divisors[MAX_DIVISORS], int numDivisors);
