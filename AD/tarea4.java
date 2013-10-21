/* Programa que lee un fichero aleatorio de empleados, con los ID de
 * empleados desordenado, crea otro fichero aleatorio con los empleados
 * ordenados y le añade dos campos a cada registro USUARIO: 3 primeros
 * caracteres del nombre y tres primeros del apellido
 * y CLAVE: Apellido + nº secuencial
 */

import java.io.*;
import java.util.*;

public class tarea4 {
	public static void main(String args[]) {
		try {
			File f = new File("tarea4.dat");
			File f2 = new File("salida.dat");
			RandomAccessFile raf = new RandomAccessFile(f,"r");
			RandomAccessFile raf2 = new RandomAccessFile(f2,"rw");
			
			
			int id, dep, pos, pos2;
			double salario;
			char apellido[] = new char[10],aux;
			
			pos = 0;
			pos2 = 0;
			
			for(int x = 0; x < 7; x++) {
				raf.seek(pos);
				id = raf.readInt();
				//System.out.println(id);
				//System.out.println();
				for(int i = 0; i < apellido.length; i++) {
					aux = raf.readChar();
					apellido[i] = aux;
				}
				String ap = new String(apellido);
				//System.out.println(ap);
				dep = raf.readInt();
				//System.out.println(dep);
				salario = raf.readDouble();
				//System.out.println(salario);
				
				raf2.seek(pos2);
				raf2.writeInt(id);
				System.out.println(id);
				System.out.println();
				raf2.writeChars(ap.toString());
				System.out.println(ap);
				System.out.println();
				raf2.writeInt(dep);
				System.out.println(dep);
				System.out.println();
				raf2.writeDouble(salario);
				System.out.println(salario);
				System.out.println();
				raf2.writeChars(ap.substring(0,3));
				System.out.println(ap.substring(0,3));
				System.out.println();
				raf2.writeChars(ap + id);
				System.out.println(ap + id);
				System.out.println();
				System.out.println("----------------------");
				
				pos += 36;
				pos2 = (id - 1) * 76;
			}
			raf.close();
			raf2.close();
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}	
	}
}
