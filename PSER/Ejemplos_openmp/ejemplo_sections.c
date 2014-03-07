//Uso de "section" para ejecutar bloques de codigo por theards distintos
#include <stdio.h>
#include <omp.h>

int main()
{
	int nt,np;
	#pragma omp parallel private(nt,np)
	{
		np = omp_get_thread_num();
		#pragma omp sections
		{
		#pragma omp section
		printf("Soy el thread %d, en solitario en la seccion 11a \n",np);
		#pragma omp section
		printf("Soy el thread %d, en solitario en la sección 22a \n",np);
		#pragma omp section
		printf("Soy el thread %d, en solitario en la seccion 33a \n",np);
		}
		
	}

		
	
	
	return 0;
}
