
import java.io.*;

class ej8 {
	public static void main(String args[]) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("f_ej8.txt"));
			for(int i = 1; i <= 10; i++) {
				bw.write("Fila número: " + i);
				bw.newLine();
			}
			bw.close();
		} catch(IOException e) { e.printStackTrace(); }
	}
}
