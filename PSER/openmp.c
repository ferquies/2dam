#include <omp.h>
#include <stdio.h>

int main() {
    int iam = 0, np = 1;
    
    #pragma omp parallel
    {
	np = omp_get_num_threads();
	iam = omp_get_thread_num();
	printf("Hello from thread %d out of %d \n", iam, np);
    }
    
    return 0;
}