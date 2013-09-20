import java.io.*;

class ej7 {
	public static void main(String args[]) {
		String s = "Esto es una prueba con FileWriter";
		try {
			File f = new File("/home/usuario/Documentos/AD/ficherotexto.txt");
			FileWriter fw = new FileWriter(f);
			for(int i = 0; i < 5; i++) {
				fw.write(s + "\n");
			}
			fw.close();
		} catch(IOException e) { e.printStackTrace(); }
	}
}
