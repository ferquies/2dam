#include <stdio.h>
#include <omp.h>

int main() {
    int N = 12, i, iam, np;
    int array[] = {12,432,23,435,65,2,657,456,4,45,89,20};
    
    //omp_set_num_threads(4);
    #pragma omp parallel private(i, iam)
    {
	#pragma omp for
	for(i = 0; i < N; i++) {
	    np = omp_get_num_threads();
	    iam = omp_get_thread_num();
	    printf("Thread %d of %d - array[%d] %d\n",iam+1,np,i,array[i]);
	}
    }
    
    return 0;
}