/* Leer el fichero aleatorio creado en el ej14*/

import java.io.*;

public class ej15{
	public static void main(String args[])
	{
		try{
			File f = new File("tarea4.dat");
			RandomAccessFile raf = new RandomAccessFile(f,"r");
			
			int id,dep,pos;
			double salario;
			char apellido[] = new char[10],aux;
			
			pos = 0;
			
			for(int x = 0; x < 7; x++) {
				raf.seek(pos);
				id = raf.readInt();
				for(int i = 0; i < apellido.length; i++) {
					aux = raf.readChar();
					apellido[i] = aux;
				}
				dep = raf.readInt();
				salario = raf.readDouble();
				
				String ap = new String(apellido);
				
				System.out.println("ID: "+id+" APELLIDO: "+ap+" DEPARTAMENTO: "+dep+" SALARIO: "+salario);
				pos = pos+36;
			}
			raf.close();
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
			
	}
}
		
