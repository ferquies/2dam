//USO DE CONSTRUCTORES SECUENCIALES, EJEMPLO ORDERED//
#include <stdio.h>
#include <omp.h>

int main()
{
		int i,np;
#pragma omp parallel private(np,i)
{
	np = omp_get_thread_num();
	#pragma omp for ordered
		for(i=0;i<5;i++)
		{
		printf("\t\tSoy el thread %d, antes del ordered en la iteracion %d\n",np,i);
			#pragma omp ordered
			{
			printf("Soy el thread %d, actuando en la iteracion %d\n",np,i);
			sleep(1);
			}
		}
	}//parallel

return 0;
}
