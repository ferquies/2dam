import java.io.*;

class ej13 {
	public static void main(String args[]) throws IOException {
		FileInputStream fis = new FileInputStream("f_ej12.dat");
		DataInputStream dis = new DataInputStream(fis);
		
		String nombre;
		int edad;
		
		try {
			while(true) {
				nombre = dis.readUTF();
				edad = dis.readInt();
				System.out.println("Nombre: " + nombre + "\nEdad: " + edad);
			}
		} catch(EOFException e) { dis.close(); }
	}
}
	
