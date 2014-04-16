#include <stdio.h>

#define N 33

void main() {
	int arr[N];
	int i, j, k, aux, first;
	char cad[2], caux;

	srand(getpid());
	for(i = 0; i < N; i++) { arr[i] = rand() % 2; }
		
	for(k = 0; k < N*10; k++) {
		system("clear");
		printf("\t\t\tAutomata celular\n");
		for(j = 0; j < N; j++) { 
			first = arr[0];
			for(i = 0; i < N; i++) {
				if(i == N-1) {
					cad[0] = (char)(((int)'0')+arr[N-1]);
					cad[1] = (char)(((int)'0')+first);
				} else {
					cad[0] = (char)(((int)'0')+arr[i]);
					cad[1] = (char)(((int)'0')+arr[i+1]);
				}
		
				if((cad[0] == '0') && (cad[1] == '0')) { aux = 0; caux = '@'; }
				if((cad[0] == '0') && (cad[1] == '1')) { aux = 1; caux = '#'; }
				if((cad[0] == '1') && (cad[1] == '0')) { aux = 1; caux = '|'; }
				if((cad[0] == '1') && (cad[1] == '1')) { aux = 0; caux = '^'; }
			
				arr[i] = aux;
		
				printf("%c ", caux);
			}
			printf("\n");
		}
		usleep(110000);
	}
}