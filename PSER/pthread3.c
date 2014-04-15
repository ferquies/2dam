#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void * fcn_hijo(void *arg) {
    int N = 20;
    int *mayor = (int*) malloc(sizeof(int));
    int m[N];
    int i;
    
    for(i = 0; i < N; i++) {
	m[i] = i;
    }
    
    for(i = 0; i < N; i++) {
	if(m[i] > *mayor) {
	    *mayor = m[i];
	}
    }
    printf("Hola soy el hijo!\n");
    return (void *) mayor;
}

int main(int argc, char **argv) {
    int exit_status[20];
    pthread_t id;
    pthread_create(&id, NULL, fcn_hijo, (void *)exit_status);
    
    printf("Hola soy el padre!\n");
    
    pthread_join(id, (void)exit_status);
    
    printf("El mayor es: %d\n", *(int *) exit_status);
    
    free(exit_status);
    
    return 0;
}