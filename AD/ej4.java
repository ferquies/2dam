import java.io.*;


class ej4 {
	public static void main(String args[]) {
		try {
			File f = new File("/home/usuario/Documentos/AD/ej3.java");
			FileReader fr = new FileReader(f);
			int i;
			while((i = fr.read()) != -1) {
				System.out.println((char)i);
			}
		} catch(IOException e) { e.printStackTrace(); }
	}
}
