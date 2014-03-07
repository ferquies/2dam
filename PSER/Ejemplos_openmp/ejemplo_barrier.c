//USO DE CONSTRUCTORES SECUENCIALES, EJEMPLO BARRIER//
#include <stdio.h>
#include <omp.h>

int main()
{
int i,np;
	#pragma omp parallel private( np,i)
	{
			np = omp_get_thread_num();
		printf("Soy el thread %d, antes del barrier \n",np);
			#pragma omp barrier
				printf("\t\tSoy el thread %d, despues del barrier \n",np);
	}//parallel

return 0;
}
