//USO DE CONSTRUCTORES SECUENCIALES, EJEMPLO FLUSH//
#include <stdio.h>
#include <omp.h>

int main()
{
int i,np,x;


	#pragma omp parallel private( np,i)
	{
	np = omp_get_thread_num();
		#pragma omp master
		{
		
			x=999;
			printf("Soy el thread %d, actualizando x=999 \n\n",np);
			}
			printf("Soy el thread %d, antes del flush, con x=%d \n",np,x);
			
				#pragma omp flush(x)
					printf("\t\tSoy el thread %d, despues del flush, con x=%d \n",np,x);
					
		}//parallel




return 0;
}
