//EJEMPLO PRIVATE//
#include <stdio.h>
#include <omp.h>

int main()
{
int i,np;





	int x=1234;
	#pragma omp parallel private(np,i,x)
	{
			np = omp_get_thread_num();
	printf("Soy el thread %d, antes de actualizar, con x=%d \n",np,x);
	x=np*1111;
	printf("\t\tSoy el thread %d, despues de actualizar, con x=%d \n",np,x);
	}
	printf("\n Despues de pragma parallel x=%d \n\n",x); //x=1234



}
