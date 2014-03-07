#include<stdio.h>
#include<omp.h>

int main()
{
	int iam,np,i;
	#pragma omp parallel private(iam, np, i)
	{
		np=omp_get_num_threads();
		iam=omp_get_thread_num();
		#pragma omp critical
		{
			printf("Soy el thread %d, al inicio de la seccion critica\n",iam);
			sleep(1);
			printf("\t\tSoy el thread %d, al final de la seccion critica\n\n\n",iam);
		}
	}
}
