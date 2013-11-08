#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(int argc, char **argv) {
    int estado;
    printf("Hola mundo!\n");
    pid_t id = fork();
    if(id == 0) {
	printf("Soy el hijo\n");
	exit(29);
    } else {
	printf("Soy el padre\n");
	//wait(&estado);
	waitpid(id, &estado, 0);
	printf("Salida del hijo: %d\n", WEXITSTATUS(estado));
    }    
    
    return 0;
}