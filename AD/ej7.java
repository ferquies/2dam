import java.io.*;

class ej7 {
	public static void main(String args[]) {
		String s = "Esto es una prueba con FileWriter";
		try {
			File f = new File("/home/usuario/Documentos/2dam/AD/ficherotexto.txt");
			FileWriter fw = new FileWriter(f);
			for(int j = 0; j < 3; j++) {
				for(int i = 0; i < 5; i++) {
					fw.write(s + "\n");
				}
				fw.write("\n");
			}
			fw.close();
		} catch(IOException e) { e.printStackTrace(); }
	}
}
