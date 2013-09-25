import java.io.*;

class ej17 {
	public static void main(String args[]) {
		try {
			File f = new File("f_ej14.txt");
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			int id = 4;
			int dep = 40;
			double salario = 3000.00;
			int pos = (id - 1) * 36;
			
			pos = pos + 4 + 20; // tamaño del id + apelllido
			raf.seek(pos);
			raf.writeInt(dep);
			raf.writeDouble(salario);
			raf.close();
		} catch(IOException e) { e.printStackTrace(); }
	}
}
