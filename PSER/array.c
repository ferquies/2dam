#include <stdio.h>
#include <stdlib.h>
#include <sys/times.h>

int main(int argc, char **argv) {
	int N = 1000000;
	long *array_dinamico = (long*) malloc(N*sizeof(long));
	long mayor = 0;
	int i, x;
	
	for(i = 0; i < N; i++) {
		array_dinamico[i] = rand() % 10000;
	}
	
	struct tms buf;
	clock_t t1 = times(&buf);
	
	for(i = 0; i < N; i++) {
		if(array_dinamico[i] > mayor) {
			mayor = array_dinamico[i];
		}
		for(x = 0; x < 100000; x++) {}
	}
	
	clock_t t2 = times(&buf);
	
	printf("El mayor es %lu\n", mayor);
	
	free(array_dinamico);
	
	printf("El tiempo de ejecucion con %d veces es %f\n", N, (float)t2-t1);
	
	return 0;
}
