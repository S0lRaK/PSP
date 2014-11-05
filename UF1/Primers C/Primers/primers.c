#include "primers.h"

void main()
{
	int num;
	int divisors[MAX_DIVISORS];
	int numDivisors;

	for(num = 1; num <= 100; num++)
	{
		printf("%d: ", num);
		
		if(esPrimer(num))
		{
			printf("Primer");
		}
		else
		{
			buscarDivisors(num, divisors, &numDivisors);
			mostrarDivisors(divisors, numDivisors);
		}

		printf("\n");
	}

	pausa();
}

void pausa()
{
	printf("\n\nPolsa INTRO per acabar\n");
	getchar();
}

bool esPrimer(int num)
{
	bool primer = true;
	int divi = 2;

	if(num > 2)
	{
		do
		{
			if(num % divi == 0)
			{
				primer = false;
			}
			else
			{
				divi++;
			}
		}while(primer == true && divi < num);
	}

	return primer;
}

void buscarDivisors(int num, int divisors[MAX_DIVISORS], int *numDivisors)
{
	int divi;

	*numDivisors = 0;
	divi = 2;
	do
	{
		if(esPrimer(divi) && num % divi == 0)
		{
			divisors[(*numDivisors)++] = divi;
			num = num / divi;
		}
		else
		{
			divi++;
		}
	}while(num > 1);
}

void mostrarDivisors(int divisors[MAX_DIVISORS], int numDivisors)
{
	int i;

	for(i = 0; i < numDivisors; i++)
	{
		printf("%d ", divisors[i]);
	}
}