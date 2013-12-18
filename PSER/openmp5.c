#include <stdio.h>
#include <omp.h>

int main() {
    int iam, np, i = 0;
    
    #pragma omp parallel shared(i) private(iam, np)
    {
	iam = omp_get_thread_num();
	for(np = 0; np < 50; np++) {
	    #pragma omp atomic
	    i++;
	}
    }
    
    printf("Valor de i: %d\n", i);
    
    return 0;
}