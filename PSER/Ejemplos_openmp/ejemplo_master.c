//USO DE CONSTRUCTORES SECUENCIALES, EJEMPLO MASTER//
#include <stdio.h>
#include <omp.h>

int main()
{
	int nt,np;
	#pragma omp parallel private(nt,np)
	{
		np = omp_get_thread_num();
		#pragma omp master 
		{
			printf("Soy el thread %d,actuando en solitario dentro del primer bloque\n",np);
			sleep(1);
		}
		#pragma omp master 
		{
			printf("Soy el thread %d,actuando en solitario dentro del segundo bloque\n",np);
			sleep(1);
		}
		#pragma omp master 
		{
			printf("Soy el thread %d,actuando en solitario dentro del tercer bloque\n",np);
			sleep(1);
		}
		printf("Soy el thread %d, fuera de los singles\n",np);

	}
return 0;
}
