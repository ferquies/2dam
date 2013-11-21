#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/times.h>

int main(int argc, char **argv) {
    int estado, i, N = 2060000, busqueda = 1502340;
    int array[N];
    
    for(i = 0; i < N; i++) {
	array[i] = i;
    }
    
    struct tms buf;
    clock_t t1 = times(&buf);
    
    pid_t id = fork();
    
    if(id == 0) {
	for(i = 0; i < N/2; i++) {
	    if(array[i] == busqueda) {
		exit(10);
	    }
	}
	exit(11);
    } else {
	pid_t id2 = fork();
	
	if(id2 == 0) {
	    for(i = N/2; i < N; i++) {
		if(array[i] == busqueda) {
		    exit(12);
		}
	    }
	    exit(13);
	} else {
	    wait(&estado);
	    int terminado = WEXITSTATUS(estado);
	    if(terminado == 10) {
		printf("Encontrado por el hijo 1\n");
		kill(id2, SIGTERM);
	    }
	    else if(terminado == 12) {
		printf("Encontrado por el hijo 2\n");
		kill(id, SIGTERM);
	    }
	    wait(&estado);
	    printf("Terminado: %d\n", terminado);
	}
    }
    
    double tvalor1 = sysconf(_SC_CLK_TCK);
    clock_t t2 = times(&buf);
    double tiempo = (double)(t2-t1)/tvalor1;
    
    printf("El tiempo total ha sido: %f\n", tiempo);
    
    return 0;
}