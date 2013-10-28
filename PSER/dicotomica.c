#include <stdio.h>
#include <stdlib.h>
#include <sys/times.h>

int main(int argc, char **argv) {
	int N = 500000;
	long *array_dinamico = (long*) malloc(N*sizeof(long));
	double tiempo[100];
	double media_tiempo = 0;
	int i, x, z, aleatorio;
	
	for(i = 0; i < N; i++) {
		array_dinamico[i] = i;
	}
	
	for(x = 0; x < 100; x++) {
		int media, min = 0, max = N - 1;

		aleatorio = rand() % N;
		
		printf("El numero buscado es: %d\n", aleatorio);
		
		struct tms buf;
		clock_t t1 = times(&buf);
	
		while(min <= max) {
			for(z = 0; z < 500000; z++){}
     		media = (max + min) / 2;
    		if(array_dinamico[media] == aleatorio) {
    			printf("El numero encontrado es: %d\n", media);
    			break;
    		} else if(aleatorio < array_dinamico[media]) {
        		max = media - 1;
		    }
     		else {
		    	min = media + 1;
	 		}
		}
	
		clock_t t2 = times(&buf);
		tiempo[x] = (float)t2-t1;
		
		printf("El tiempo usado para la busqueda ha sido: %f\n", tiempo[x]);
	}
	
	for(x = 0; x < 100; x++) {
		media_tiempo += tiempo[x];
	}
	
	media_tiempo = media_tiempo/100;
	
	printf("La media de tiempo de todas las busquedas es: %f\n", media_tiempo); 
	
	free(array_dinamico);
	
	return 0;
}
