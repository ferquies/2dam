
import java.io.*;
import java.util.*;

class ej4p24 {
	public static void main(String args[]) {
		try {
			File f = new File("f_ej14.txt");
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			Scanner scan = new Scanner(System.in);
			
			int id, pos;
			double salario, sal;
			
			System.out.print("Introduce el id del empleado: ");
			id = scan.nextInt();
			System.out.println();
			System.out.print("Introduce el incremento de salario: ");
			salario = scan.nextDouble();
			
			pos = (id - 1) * 36;
			pos = pos + 4 + 20 + 4;
			raf.seek(pos);
			sal = raf.readDouble();
			salario += sal;
			raf.seek(pos);
			raf.writeDouble(salario);
			raf.close();
		} catch(FileNotFoundException e) { e.printStackTrace(); }
		catch(IOException e) { e.printStackTrace(); }
	}
}
