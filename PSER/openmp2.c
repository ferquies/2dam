#include <stdio.h>
#include <omp.h>

int main() {
    int array[] = {12,432,23,435,65,2,657,456,98,16,78,54};
    
    // omp_set_num_threads(4);
    #pragma omp parallel
    {
	int np = omp_get_num_threads();
	int iam = omp_get_thread_num();
	int inicio = 3 * iam;
	int fin = inicio + 3;
	for(inicio; inicio < fin; inicio++) {
	    printf("Thread %d of %d - array[%d] %d\n",iam,np,inicio,array[inicio]);
	}
    }
    
    return 0;
}