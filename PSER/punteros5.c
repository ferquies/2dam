/* Crear un array estatico y un array dinamico */
#include <stdio.h>
#include <stdlib.h>

int main(char **argv, int argc) {
	int i;
	int arr_estatico[7];
	int *arr_dinamico = (int*) malloc(7*sizeof(int));
	
	for(i = 0; i < 7; i++) {
		arr_estatico[i] = i;
		arr_dinamico[i] = i*2;
	}
	
	for(i = 0; i < 7; i++) {
		printf("Estatico[%d]: %d\nPosicion de memoria: %p\n", i, arr_estatico[i], &arr_estatico[i]);
	}
	printf("\n");
	for(i = 0; i < 7; i++) {
		printf("Dinamico[%d]: %d\nPosicion de memoria: %p\n", i, arr_dinamico[i], &arr_dinamico[i]);
	}
	
	free(arr_dinamico);
	
	return 0;
}
