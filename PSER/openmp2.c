#include <stdio.h>
#include <omp.h>

int main() {
    int N = 12;
    int array[] = {12,432,23,435,65,2,657,456,4,45,89,20};
    int np = 0, iam = 0, inicio, fin, TAM;
    
    //omp_set_num_threads(4);
    #pragma omp parallel private(np, iam, TAM, inicio, fin)
    {
	np = omp_get_num_threads();
	iam = omp_get_thread_num();
	TAM = N/np;
	inicio = iam * TAM;
	fin = inicio + TAM;
	for(inicio; inicio < fin; inicio++) {
	    printf("Thread %d of %d - array[%d] %d\n",iam + 1,np,inicio,array[inicio]);
	}
    }
    
    return 0;
}