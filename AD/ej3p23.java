/* Actividad 3 pagina 23
 * Crea un programa que reciba un id de empleado  y visualice sus datos */

import java.io.*;
import java.util.*;

public class ej3p23{
	public static void main(String args[])
	{
		try{
				
			File f = new File("f_ej14.txt");
			
			RandomAccessFile raf = new RandomAccessFile(f,"r");
			Scanner scan = new Scanner(System.in);
			
			int id,pos,dep,identificador;
			double salario;
			char apellido[] = new char[10],aux;
		
			System.out.println("Introduce el ID a consultar");
			identificador = scan.nextInt();
			
			pos = (identificador-1)*36;
			
			if(pos >= raf.length())
			{
				System.out.println("ID: "+identificador+" NO EXISTE EMPLEADO...");
			}
			else{
				raf.seek(pos);
				id = raf.readInt();
				for(int i = 0; i< apellido.length; i++)
				{
					aux = raf.readChar();
					apellido[i] = aux;
				}
				dep = raf.readInt();
				salario = raf.readDouble();
				
				String ap = new String(apellido);
				
				System.out.println("ID: "+id+" APELLIDO: "+ap+" DEPARTAMENTO: "+dep+" SALARIO: "+salario);
			}
			raf.close();
		}catch(IOException e){
			e.printStackTrace();
		/*}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();*/
		}
	}
}
		
		
	
		
		
		
