#include <stdio.h>
#include <pthread.h>

void * fcn_hijo(void *arg) {
    printf("Hola soy el hijo!\n");
    return NULL;
}

int main(int argc, char **argv) {
    void * exit_status;
    pthread_t id;
    pthread_create(&id, NULL, fcn_hijo, NULL);
    
    printf("Hola soy el padre!\n");
    
    pthread_join(id, exit_status);
    
    return 0;
}