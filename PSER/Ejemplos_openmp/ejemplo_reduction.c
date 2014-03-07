//EJEMPLO REDUCTION//
#include <stdio.h>
#include <omp.h>

int main()
{






	int x=10; int np = 1, i=0,j=0;
	printf("\n Antes de pragma parallel x=%d \n\n",x);
		#pragma omp parallel private(np,i) reduction(|:x)
		{ 
			np = omp_get_thread_num();				
		printf("Soy el thread %d, antes de actualizar, con x=%d \n",np,x);
		x=(np+1)*10;
		printf("\t\tSoy el thread %d, despues de actualizar, con x=%d \n",np,x);
		}//parallel
	printf("\n Despues de pragma parallel x=%d \n\n",x);



}
