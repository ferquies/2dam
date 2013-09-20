import java.io.*;

class ej5 {
	public static void main(String args[]) {
        char v[] = new char[20];
		try {
			File f = new File("/home/usuario/Documentos/AD/ej3.java");
			FileReader fr = new FileReader(f);
			int i;
			try {
				while((i = fr.read(v)) != -1) {
				System.out.println((char[])v);
				}
			} catch(ArrayIndexOutOfBoundsException e) { e.printStackTrace(); }
		} catch(IOException e) { e.printStackTrace(); }
	}
}
