#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/times.h>

int main(int argc, char **argv) {
    int idterminado, inicio, fin, estado, i, j, N = 2060000, busqueda = 1502340, P = 4;
    int array[N];
    int matado[P];
    
    for(i = 0; i < N; i++) {
	array[i] = i;
    }
    
    struct tms buf;
    clock_t t1 = times(&buf);
    
    pid_t id[P];
    
    for(j = 0; j < P; j++) {
	id[j] = fork();
	if(id[j] == 0) {
	    inicio = j*N/P;
	    fin = (j+1)*N/P;
	    for(i = inicio; i < fin; i++) {
		if(array[i] == busqueda)
		    exit(1);
	    }
	    exit(0);
	}
    }
    for(j = 0; j < P; j++) {
	terminado = WEXITSTATUS(estado);
	if(WEXITSTATUS(&estado) == 1) {
	    for(i = 0; i < P; i++) {
		if(i == idterminado) {
		    printf("Viva el hijo\n");
		} else {
		    if(matado[i] == 0) {
			kill(id[i], SIGTERM);
		    }
		}
	    }
	}
    }
}