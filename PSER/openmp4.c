#include <stdio.h>
#include <omp.h>

int main() {
    int iam, np, i;
    #pragma omp parallel private(iam, np, i)
    {
	#pragma omp critical
	{
	    iam = omp_get_thread_num();
	    printf("Soy el thread %d al inicio de la seccion critica\n", iam);
	    sleep(1);
	    printf("\t\tSoy el thread %d al final de la seccion critica\n",iam);
	}
    }
    
    return 0;
}