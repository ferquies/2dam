/****Problema Encriptado-Desencriptado******/
/*
 *           /Realizado por:
 //Juanjo Berenguer : surkhojb@gmail.com//
 //Fernando Quilez : ferquies@gmail.com//
 //Vicente Bañon : vicentebanonpeinado@gmail.com//
 //Abel Moreno : abel_moreno_00@hotmail.com//
 */
#include <stdio.h>

int encriptar(int);//Funcion encargada de encriptar 
int desencriptar(int);//Funcion encargada de desencriptar
int contar(char*, float*);//Funcion que devuelve el porcentaje de cada letra del fichero que pasemos
int diferencia(float*, float*);

int main() {
	int enc = 0;
	printf("Introduce clave (numero) para encriptar: ");
	scanf("%d", &enc);
	if(encriptar(enc) != 0)
		printf("Error al encriptar\n");
	else
		printf("Encriptado con exito!\n");
	
	float c1[26];
	float c2[26];
	int i;
	
	if(contar("salida.txt", c1) != 0)
		printf("Error al calcular porcentaje de cada letra en fichero encriptado\n");
	else
		printf("Calculado porcentaje de cada letra en fichero encriptado\n");
	if(contar("diccionario.txt", c2) != 0)
		printf("Error al calcular porcentaje de cada letra en fichero diccionario\n");
	else
		printf("Calculado porcentaje de cada letra en fichero diccionario\n");
	
	int difer = diferencia(c1, c2);
	printf("Calculada diferencia entre letras con mayor porcentaje de apariciones en ambos ficheros\n");
	
	if(desencriptar(difer) != 0)
		printf("Error al desencriptar\n");
	else
		printf("Desencriptado con exito!\n");
	
	return 0;
}

/* <-------------------------------Funciones-------------------------------> */
//Funcion para encriptar, esta funcion nos lee un fichero con el texto a encriptar
// y lo encriptamos cambiando cada caracter por el caracter que corresponda al sumar las posiciones pasadas en la variable
//enc
int encriptar(int enc) {
	FILE *entrada, *salida;
	char e, s;
	int clave = enc;
	
	if(((entrada = fopen("entrada.txt", "rt")) == NULL) || ((salida = fopen("salida.txt","wt")) == NULL)) {
		printf("Error en la apertura de ficheros\n");
		return 1;
	}
	
	e = fgetc(entrada);
	
	while(e != EOF) {
		if(e == ' ')
			s = fputc(e, salida);
		else if(e == '\n')
			s = fputc(e, salida);
		else if(e == '.')
			s = fputc(e, salida);
		else if(e == ',')
			s = fputc(e, salida);
		else {
			if(((int)e+clave > 90 && (int)e+clave < 97) || ((int)e+clave > 122))
				s = fputc(e+clave-25, salida);
			else
				s = fputc(e + clave, salida);
		}
		
		e = fgetc(entrada);
	}
	
	fclose(entrada);
	fclose(salida);
	
	return 0;
}

int desencriptar(int c) {
	FILE *enc, *des;
	char e, d;
	int clave = c;
	
	if(((enc = fopen("salida.txt", "rt")) == NULL) || ((des = fopen("desencriptado.txt","wt")) == NULL)) {
		printf("Error en la apertura de ficheros\n");
		return 1;
	}
	
	e = fgetc(enc);
	
	while(e != EOF) {
		if(e == ' ')
			d = fputc(e, des);
		else if(e == '\n')
			d = fputc(e, des);
		else if(e == '.')
			d = fputc(e, des);
		else if(e == ',')
			d = fputc(e, des);
		else {
			if(((int)e-clave < 97 && (int)e-clave > 90) || ((int)e-clave < 65))
				d = fputc(e - clave + 25, des);
			else
				d = fputc(e - clave, des);
		}
		
		e = fgetc(enc);
	}
	
	fclose(enc);
	fclose(des);
	
	return 0;
}

int contar(char* fichero, float* letras) {
	FILE *dic;
	char c;
	int total_palabras = 1;
	int total_letras = 0;
	int i;
	
	for(i = 0; i < 26; i++) {
		letras[i] = 0;
	}
	
	if((dic = fopen(fichero, "rt")) == NULL) {
		printf("Error en la apertura de ficheros\n");
		return 1;
	}
	
	c = fgetc(dic);
	//Bucle para contar las palabras del fichero pasado como parametro
	//En este bucle contamos las palabras que esten separadas por intros o espacio 
	//Y distinguimos entre minusculas y mayusculas
	while(c != EOF) {
		if(c == '\n' || c == ' ') {
			total_palabras++;
		} else {
			total_letras++;
			if((((int)c) >= 65) && (((int)c) <= 90))
				letras[((int)c)+32-97]++;
			else if((((int)c) >= 97) || (((int)c) <= 122))
				letras[((int)c)-97]++;
		}
		
		c = fgetc(dic);
	}
	
	fclose(dic);
	
	for(i = 0; i < 26; i++) {
		letras[i] = letras[i]/total_letras*100;
	}
	
	return 0;
}


int diferencia(float* c1, float* c2) {
	int max1 = 0; int max2 = 0; int dif = 0; int i; char ch1, ch2;
	
	for(i = 0; i < 26; i++) {
		if(c1[i] > max1) {
			max1 = c1[i];
			ch1 = (char)i+97;
		}
		if(c2[i] > max2) {
			max2 = c2[i];
			ch2 = (char)i+97;
		}
	}
	
	int max, min;
	if((int)ch1 > (int)ch2) {
		max = (int)ch1;
		min = (int)ch2;
	} else {
		max = (int)ch2;
		min = (int)ch1;
	}
	
	dif = max - min;
	
	return dif;
}