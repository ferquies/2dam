#include <stdio.h>
#include <stdlib.h>
#include <sys/times.h>

int main(int argc, char **argv) {
	int N = 100000000;
	long *array_dinamico = (long*) malloc(N*sizeof(long));
	double tiempo[100];
	double media = 0;
	int i, x, aleatorio;
	
	for(i = 0; i < N; i++) {
		array_dinamico[i] = i;
	}
	
	for(x = 0; x < 100; x++) {
		aleatorio = rand() % N;
		
		printf("El numero buscado es: %d\n", aleatorio);
		
		struct tms buf;
		clock_t t1 = times(&buf);
	
		for(i = 0; i < N; i++) {
			if(array_dinamico[i] == aleatorio) {
				break;
			}
		}
	
		clock_t t2 = times(&buf);
		tiempo[x] = (float)t2-t1;
		
		printf("El tiempo usado para la busqueda ha sido: %f\n", tiempo[x]);
	}
	
	for(x = 0; x < 100; x++) {
		media += tiempo[x];
	}
	
	media = media/100;
	
	printf("La media de tiempo de todas las busquedas es: %f\n", media); 
	
	free(array_dinamico);
	
	return 0;
}

