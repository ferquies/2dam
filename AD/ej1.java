import java.io.*;

class ej1 {
    public static void main(String []args) {
		String dir = args[0];
		File fichero1 = new File(dir);
		String[] archivos = fichero1.list();
		for(int i = 0; i < archivos.length; i++) {
			System.out.println(archivos[i]);
		}
	}
}
