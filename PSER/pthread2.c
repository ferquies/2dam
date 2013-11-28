#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

int N = 100000;
int array[100000];
int busqueda = 99999;
int flag = 0;
pthread_mutex_t mutex;

void * fcn_hijo(void *arg) {
    int *encontrado = (int*) malloc(sizeof(int));
    int i;
    
    for(i = N/2; i < N; i++) {
	if(flag == 0) {
	    if(array[i] == busqueda) {
		*encontrado = array[i];
		pthread_mutex_lock(&mutex);
		flag = 1;
		pthread_mutex_unlock(&mutex);
	    }
	} else {
	    break;
	}
	if(i == N-1)
	    printf("Fin del bucle hijo\n");
    }    
    
    return (void *) encontrado;
}

int main(int argc, char **argv) {
    void * exit_status;
    int i, encontrado;
    pthread_mutex_init(&mutex, NULL);
    
    for(i = 0; i < N; i++) {
	array[i] = i;
    }
    
    pthread_t id;
    pthread_create(&id, NULL, fcn_hijo, &exit_status);
    
    for(i = 0; i < N/2 - 1; i++) {
	if(flag == 0) {
	    if(array[i] == busqueda) {
		encontrado = array[i];
		pthread_mutex_lock(&mutex);
		flag = 1;
		pthread_mutex_unlock(&mutex);
	    }
	} else {
	    break;
	}
	if(i == (N/2) - 1)
	    printf("Fin del bucle padre\n");
    }

    pthread_join(id, &exit_status);
    pthread_mutex_destroy(&mutex);
    
    if(*(int *)exit_status == busqueda) {
	printf("Encontrado por el hijo: %d\n", *(int *) exit_status);
    } else if(encontrado == busqueda) {
	printf("Encontrado por el padre: %d\n", encontrado);
    } else {
	printf("No encontrado\n");
    }
    
    free(exit_status);
    
    return 0;
}