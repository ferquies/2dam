#include <stdio.h>

#define N 65
#define T 40

int media(int pass[], int **pi, int pasos);

void main() {
	int pass[N];
	int **pi = (int**)malloc(sizeof(int*)*T);
	int **pn = (int**)malloc(sizeof(int*)*T);
	int **padres = (int**)malloc(sizeof(int*)*2);
	int *mejor = (int*)malloc(sizeof(int)*N);
	int i, j, padre_anterior = NULL, count = 0, mejor_aux = N-1, pasos = T;

	srand(getpid());
	
	printf("Contraseña original\n");
	
	for(i = 0; i < N-1; i++) {
		pass[i] = 1;
		printf("%d", pass[i]);
	}

	printf("\n\n");

	/* Generar las primeras contraseñas aleatorias */
	for(i = 0; i < T; i++) {
		pi[i] = (int*)malloc(sizeof(int)*N);
		pn[i] = (int*)malloc(sizeof(int)*N);
		if(i < 2) {
			padres[i] = (int*)malloc(sizeof(int)*N);
		}
		printf("Contraseña aleatoria: %d\n", i);
		for(j = 0; j < N-1; j++) {
			pi[i][j] = rand() % 2;
			printf("%d", pi[i][j]);
		}
		printf("\n");
	}
	printf("\n");


	int media_fallos = media(pass, pi, pasos);
	printf("Media de fallos: %d\n", media_fallos);

	/* Comprobar mejor y eliminar peores */
	for(i = 0; i < T; i++) {
		if(pi[i][N-1] > media_fallos) {
			free(pi[i]);
			pi[i] = NULL;
		} else {
			if(pi[i][N-1] < mejor_aux) {
				mejor_aux = pi[i][N-1];
				mejor = pi[i];
			}
		}
	}
	mejor_aux = N-1;

	printf("El que menos fallos tiene es: ");
	for(i = 0; i < N-1; i++) {
		printf("%d", mejor[i]);
	}
	printf(" con %d fallos\n", mejor[N-1]);

	/* De las contraseñas que quedan elegir 2 al azar */
	pasos /= 2;
	for(i = 0; i < pasos; i++) {
		while(count < 2) {
			int random = rand() % T;
			if(pi[random] != NULL && padre_anterior != random) {
				count++;
				padres[count-1] = pi[random];
				padre_anterior = random;
				//printf("El padre %d es: %d\n", count, random);
			}
		}
		int random = rand() % N;
		//printf("Contraseña hijo: %d\n", i);
		for(j = 0; j < N; j++) {
			if(j < random) {
				pn[i][j] = padres[0][j];
			} else {
				pn[i][j] = padres[1][j];
			}
			//printf("%d", pn[i][j]);
		}
		//printf("\n");
		count = 0;
	}

	/* Comprobar mejor y eliminar peores */
	media_fallos = media(pass, pn, pasos);
	printf("Media de fallos: %d\n", media_fallos);
	for(i = 0; i < pasos; i++) {
		if(pn[i][N-1] > media_fallos) {
			free(pn[i]);
			pn[i] = NULL;
		} else {
			if(pn[i][N-1] < mejor_aux) {
				mejor_aux = pn[i][N-1];
				mejor = pn[i];
			}
		}
	}
	mejor_aux = N-1;
	printf("El que menos fallos tiene es: ");
	for(i = 0; i < N-1; i++) {
		printf("%d", mejor[i]);
	}
	printf(" con %d fallos\n", mejor[N-1]);

	/* Liberar memoria */
	for(i = 0; i < T; i++) {
		if(pi[i] != NULL) {
			free(pi[i]);
		}
		if(pn[i] != NULL) {
			free(pn[i]);
		}
	}
	free(pi);
	free(pn);
	free(padres);
}

int media(int pass[], int **pi, int pasos) {
	int m, i, j, fallos = 0, total_fallos = 0;

	for(i = 0; i < pasos; i++) {
		for(j = 0; j < N-1; j++) {
			if(pi[i][j] != pass[j])
				fallos++;
		}
		pi[i][N-1] = fallos;
		//printf("Fallos de contraseña %d: %d\n", i, pi[i][N-1]);
		total_fallos += fallos;
		fallos = 0;
	}

	m = total_fallos / pasos;

	return m;
}