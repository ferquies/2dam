import java.io.*;

class ej2 {
	public static void main(String args[]) {
		File f = new File("ej1.java");
		if(f.exists()) {
			System.out.println("El fichero existe.");
			System.out.println("Nombre: " + f.getName());
			System.out.println("Ruta: " + f.getPath());
			System.out.println("Ruta absoluta: " + f.getAbsolutePath());
			System.out.println("Permisos de escritura: " + f.canWrite());
			System.out.println("Permisos de lectura: " + f.canRead());
			System.out.println("Tamaño: " + f.length());
			System.out.println("Es un directorio: " + f.isDirectory());
			System.out.println("Es un fichero: " + f.isFile());
		} else {
			System.out.println("El fichero no existe");
		}
	}
}
