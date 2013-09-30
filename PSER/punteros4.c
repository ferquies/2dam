#include <stdio.h>

int main(int argc, char **argv) {
	int i, j;
	int mat[3][5];

	for(i = 0; i < 3; i++) {
		for(j = 0; j < 5; j++) {
			*(*(mat+i)+j) = i+j;
		}
	}
	printf("\n");
	for(i = 0; i < 3; i++) {
		printf("[%d]. %p\n", i, mat+i);
		printf("[%d]. %d\n", i, **(mat+i));
	}
	printf("\n");
	for(i = 0; i < 15; i++) {
		printf("[%d]. %p\n", i, *(mat+i));
		printf("%d\n", *(*mat+i));
	}
		
	return 0;
}
