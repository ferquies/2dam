#include <stdio.h>
#include <omp.h>

#define C 300
#define F 10

void binario(int num, int reg[], int i);
int calc_tam(int num);

void main(int argc, char *argv[]) {
	int arr[C];
	int i, j, k, aux, first;
	char cad[2];
    int num;
    if(argv[1]) {
        char *p = argv[1];
        int longitud = strlen(p);

        for(i = 0; i < longitud; i++) {
            num = 10 * num + p[i] - '0';
        }
    } else {
        num = 4;
    }
    
    /*---------Reglas---------*/
    int regla[calc_tam(num)];

    binario(num, regla, 0);
	srand(getpid());

	for(i = 0; i < C; i++) { arr[i] = rand() % 2; }

	//omp_set_num_threads(1);
    #pragma omp parallel
    {
        for(k = 0; k < C; k++) {
            for(j = 0; j < F; j++) { 
                first = arr[0];
                #pragma omp for
                for(i = 0; i < C; i++) {
                    if(i == C-1) {
                        cad[0] = (char)(((int)'0')+arr[C-1]);
                        cad[1] = (char)(((int)'0')+first);
                    } else {
                        cad[0] = (char)(((int)'0')+arr[i]);
                        cad[1] = (char)(((int)'0')+arr[i+1]);
                    }
                    
                    int decimal = 2*cad[1]+cad[0];
            
                    aux = regla[decimal];
                    arr[i] = aux;

                    printf("%d", aux);
                }
            }
        }
    }
    printf("\n");
}

void binario(int num, int reg[], int i)
{
    int aux;
   
    if(num == 0)
        return;

    aux = num % 2;
    num = num / 2;
    reg[i] = aux;
    i++;

    binario(num, reg, i);
}

int calc_tam(int num) {
    int count = 0;
    while(1) {
        num /= 2;
        count++;

        if(!num) { return count; }
    }
}