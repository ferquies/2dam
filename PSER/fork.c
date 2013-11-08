#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(int argc, char **argv) {
	int estado;
	printf("Hola\n");
	pid_t id = fork();
	if(id == 0) {
		printf("Adios hijo\n");
	} else {
		printf("Adios padre\n");
	}
	wait(&estado);
	//waitpid(pid_t pid, int *estado, int opciones);
	exit(0);
	
	return 0;
}
