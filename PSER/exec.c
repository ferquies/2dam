/* execve(char * path, char * argv[], char * envp[]);
 * execl(char * path, char * arg0, char * arg1, char * argn, (char *)0);
 * execle(char * path, char * arg0, char * arg1, char * argn, (char *)0, char * envp[]);
 * execv(char * pathname, char * argv[]);
 * execvp(char * file, char * argv[]);
 */
#include <stdio.h>
#include <unistd.h>

int main(int argc, char **argv) {
	printf("Hola\n");
	execl("/bin/ls", "-l", "-a", (char *)0);
	printf("Adios\n");
	
	return 0;
}
