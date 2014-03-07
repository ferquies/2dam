//EJEMPLO LASTPRIVATE//
#include <stdio.h>
#include <omp.h>

int main()
{
int i,np;





	int x=1234;
	#pragma omp parallel private(np,i)
	{
			np = omp_get_thread_num();		
		printf("Soy el thread %d, antes de actualizar, con x=%d \n",np,x);
		#pragma omp for lastprivate(x) schedule(dynamic)
			for(i=0;i<11;i++)
			{
			x=np*i;
			printf("\tSoy el thread %d, actualizando en for, i=%d x=%d\n",np,i,x);
			}
		printf("\t\tSoy el thread %d, despues de actualizar, con x=%d \n",np,x);
	}
	printf("\n Despues de pragma parallel x=%d \n\n",x);



}
