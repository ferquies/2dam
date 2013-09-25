#include <stdio.h>

int main(int argc, char **argv) {
	int mat[3][5] = {{ 0,1,2,3,4 }, { 5,6,7,8,9 }, { 10,11,12,13,14 }};
	int i, j;
	
	printf("sizeof(int): %d\n", sizeof(int));
	for(i = 0; i < 3; i++) {
		for(j = 0; j < 5; j++) {
			printf("[%d][%d]. %p\n", i, j, &mat[i][j]);
		}
	}
	printf("\n");
	for(i = 0; i < 3; i++) {
		printf("[%d]. %p\n", i, mat+i);
	}
		
	return 0;
}
