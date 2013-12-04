#include <stdio.h>
#include <omp.h>

int main() {
    int array[] = {0,1,2,3,4,5,6,7,8,9};
    int iam = 0, np = 1, inicio, fin;
    
    #pragma omp parallel
    {
	np = omp_get_num_threads();
	iam = omp_get_thread_num();
	inicio = 10 * iam;
	fin = inicio + 9;
	for(inicio; inicio < fin; inicio++) {
	    printf("thread %d - array %d\n",iam,array[inicio]);
	}
    }
    
    return 0;
}