#include <stdio.h>
#include <unistd.h>
#include <sys/times.h>

int main(int argc, char **argv) {
	struct tms *buf;
	int t1 = times(buf);
	
	// Se obtiene el pid del proceso
	pid_t pid = getpid();
	// Se obtiene el pid del proceso padre
	pid_t ppid = getppid();
	// Se obtiene el id del usuario
	uid_t uid = getuid();
	// Se obtiene el id del usuario efectivo
	uid_t euid = geteuid();
	// Se obtiene el id del grupo del ususario
	gid_t gid = getgid();
	// Se obtiene el id del grupo del usuario efectivo
	gid_t egid = getegid();
	
	printf("El pid del proceso es: %d\nEl pid del proceso padre es: %d\n", pid, ppid);
	printf("\nEl uid del usuario es: %d\nEl euid del usuario efectivo es: %d\n", uid, euid);
	printf("\nEl gid del grupo usuario es: %d\nEl gid del grupo del usuario efectivo es: %d\n", gid, egid);
	
	setuid((uid_t) 1000);
	
	// Se obtiene el pid del proceso
	pid = getpid();
	// Se obtiene el pid del proceso padre
	ppid = getppid();
	// Se obtiene el id del usuario
	uid = getuid();
	// Se obtiene el id del usuario efectivo
	euid = geteuid();
	// Se obtiene el id del grupo del ususario
	gid = getgid();
	// Se obtiene el id del grupo del usuario efectivo
	egid = getegid();
	
	printf("\nEl pid del proceso es: %d\nEl pid del proceso padre es: %d\n", pid, ppid);
	printf("\nEl uid del usuario es: %d\nEl euid del usuario efectivo es: %d\n", uid, euid);
	printf("\nEl gid del grupo usuario es: %d\nEl gid del grupo del usuario efectivo es: %d\n", gid, egid);
	
	int t2 = (int)times(buf);
	
	printf("El tiempo de ejecucion ha sido %d\n", t2-t1);
		
	return 0;
}
