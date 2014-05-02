#include <stdio.h>
#include <omp.h>

#define C 10000
#define F 100

void main() {
	int arr[C];
	int i, j, k, aux, first;
	char cad[2];
    
    /*---------Reglas---------*/
    int regla[4];
    regla[0] = 1;
    regla[1] = 0;
    regla[2] = 0;
    regla[3] = 1;

	srand(getpid());

	for(i = 0; i < C; i++) { arr[i] = rand() % 2; }

	//omp_set_num_threads(1);
    #pragma omp parallel
    {
        for(k = 0; k < 1; k++) {
            system("clear");
            printf("\t\t\tAutomata celular\n");
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
                    
                    /*if((cad[0] == '0') && (cad[1] == '0')) { aux = 0; caux = '@'; }
                    if((cad[0] == '0') && (cad[1] == '1')) { aux = 1; caux = ' '; }
                    if((cad[0] == '1') && (cad[1] == '0')) { aux = 0; caux = '|'; }
                    if((cad[0] == '1') && (cad[1] == '1')) { aux = 1; caux = '_'; }*/

                    arr[i] = aux;

                    if(aux == 0)
                        printf("|");
                    else
                        printf("@");
                }
                printf("\n");
            }
            usleep(120000);
        }
    }
}
