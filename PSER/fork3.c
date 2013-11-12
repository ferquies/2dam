#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/times.h>

int main(int argc, char **argv) {
    int estado, i, N = 2060000, busqueda = 1600000;
    int array[N];
    
    for(i = 0; i < N; i++) {
	array[i] = i;
    }
    
    struct tms buf;
    clock_t t1 = times(&buf);
    
    pid_t id1 = fork();

    if(id1 == 0) {	
	for(i = 0; i < 10000000; i++){}
	
	for(i = 0; i < N/2+1; i++) {
	    if(i == busqueda) {
		printf("Encontrado por el hijo 1\n");
		break;
	    }
	}
	exit(1);
    } else {
	pid_t id2 = fork();
	
	if(id2 == 0) {	
	    for(i = 0; i < 10000000; i++){}
	    
	    for(i = N/2+1; i < N; i++) {
		if(i == busqueda) {
		    printf("Encontrado por el hijo 2\n");
		    break;
		}
	    }
	    exit(2);
	} else {
	    //wait(&estado);
	    waitpid(id2, &estado, 0);
	    printf("Salida del hijo: %d\n", WEXITSTATUS(estado));
	}
	//wait(&estado);
	waitpid(id1, &estado, 0);
	printf("Salida del hijo: %d\n", WEXITSTATUS(estado));
    }
    
    double tvalor1 = sysconf(_SC_CLK_TCK);
    clock_t t2 = times(&buf);
    double tiempo = (double)(t2-t1)/tvalor1;
    
    printf("El tiempo total ha sido: %f\n", tiempo);
    
    return 0;
}