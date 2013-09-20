import java.io.*;

class ej3 {
	public static void main(String []args) {
		File d = new File("ej3");
		File f1 = new File(d, "fichero1.txt");
		File f2 = new File(d, "fichero2.txt");
		d.mkdir();
		try {
			if(f1.createNewFile()) {
				System.out.println("Fichero creado");
			}
			if(f2.createNewFile()) {
				System.out.println("Fichero creado");
			}
		} catch(IOException e) { e.printStackTrace(); }
		if(f1.exists() && f2.exists()) {
			f1.renameTo(new File(d, "nuevofichero1.txt"));
			f2.delete();
		}
	}
}
