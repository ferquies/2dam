#include <stdio.h>

int main(int argc, char **argv) {
	int a = 5;
	int *dir_a = &a;
	int **dir_dir_a = &dir_a;
	
	printf("%d\n", a);
	printf("%p, %d\n", dir_a, *dir_a);
	printf("%p, %p, %i\n", dir_dir_a, *dir_dir_a, **dir_dir_a);
	
	return 0;
}
