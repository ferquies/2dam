import java.io.*;

class ej16 {
	public static void main(String args[]) {
		try {
			File f = new File("f_ej14.txt");
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			StringBuffer sb = null;
			String apellido = "Gonzalez";
			int id = 20, dep = 30;
			double salario = 1230.80;
			long pos = (id - 1)*36;
			
			raf.seek(pos);
			raf.writeInt(id);
			
			sb = new StringBuffer(apellido);
			
			sb.setLength(10);
			raf.writeChars(sb.toString());
			raf.writeInt(dep);
			raf.writeDouble(salario);
			raf.close();
		} catch(FileNotFoundException fnfe) { fnfe.printStackTrace(); }
		catch(IOException ioe) { ioe.printStackTrace(); }
	}
}
