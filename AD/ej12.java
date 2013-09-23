import java.io.*;

class ej12 {
	public static void main(String args[]) {
		try {
			File f = new File("f_ej12.dat");
			FileOutputStream fos = new FileOutputStream(f);
			DataOutputStream dos = new DataOutputStream(fos);
			String nombres[] = { "Ana", "Maria", "Pepe", "Manuel", "Elisa", "Juan", "Pedro", "Angel", "Emilio" };
			int edades[] = { 13, 16, 21, 32, 12, 15, 22, 14, 18 };
			
			for(int i = 0; i < edades.length; i++) {
				dos.writeUTF(nombres[i]);
				dos.writeInt(edades[i]);
			}
			dos.close();
		} catch(IOException e) { e.printStackTrace(); }
	}
}
