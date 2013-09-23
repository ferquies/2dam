import java.io.*;

class ej9 {
	public static void main(String args[]) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("f_ej9.txt"));
			for(int i = 1; i <= 10; i++) {
				pw.println("Fila número: " + i);
			}
			pw.close();
		} catch(IOException e) { e.printStackTrace(); }
	}
}
