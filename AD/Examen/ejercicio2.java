import java.io.*;

public class ejercicio2 {
    public static void main(String[] args) {
	String fichero = "fichero_aleatorio.dat";
	int id, nacimiento, posicion = 0;
	char codigo[] = new char[4];
	char nombre[] = new char[20];
	char apellido[] = new char[20];
	char pais[] = new char[20];
	char ciudad[] = new char[20];
	char estudios[] = new char[20];
	// 4+4+8+40+40+40+40+40
	char aux;
	try {
	    File f = new File(fichero);
	    RandomAccessFile raf = new RandomAccessFile(f, "r");
	    for(;;) {
		raf.seek(posicion);
		id = raf.readInt();
		for(int i = 0; i < codigo.length; i++) {
		    aux = raf.readChar();
		    codigo[i] = aux;
		}
		String cod = new String(codigo);
		for(int i = 0; i < nombre.length; i++) {
		    aux = raf.readChar();
		    nombre[i] = aux;
		}
		String nom = new String(nombre);
		for(int i = 0; i < apellido.length; i++) {
		    aux = raf.readChar();
		    apellido[i] = aux;
		}
		String ap = new String(apellido);
		for(int i = 0; i < pais.length; i++) {
		    aux = raf.readChar();
		    pais[i] = aux;
		}
		String pa = new String(pais);
		nacimiento = raf.readInt();
		for(int i = 0; i < ciudad.length; i++) {
		    aux = raf.readChar();
		    ciudad[i] = aux;
		}
		String ciu = new String(ciudad);
		for(int i = 0; i < estudios.length; i++) {
		    aux = raf.readChar();
		    estudios[i] = aux;
		}
		String es = new String(estudios);
		
		System.out.println("ID Autor: " + id + " | Codigo: " + cod + " | Nombre: " + nom + " | Apellido: " + ap + " | Pais: " + pa + " | Nacimiento: " + nacimiento + " | Ciudad: " + ciu + " | Estudios: " + es);
		
		posicion += 216;
		
		if(raf.getFilePointer() == raf.length()) { break; }
	    }
	    raf.close();
	} catch(Exception e) { e.printStackTrace(); }
    }
}