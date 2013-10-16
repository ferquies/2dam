/* Leer el fichero aleatorio creado en el ej14*/

import java.io.*;

public class ej15{
	public static void main(String args[])
	{
		try{
			
			File f = new File("tarea4.dat");
			//-Declara el fichero de acceso aleatorio con permisos r-//
			RandomAccessFile raf = new RandomAccessFile(f,"r");
			
			int id,dep,pos;
			double salario;
			char apellido[] = new char[10],aux;
			
			pos = 0; //Lo ponemos a 0 para situarnos al principio 
			
			for(;;)
			{
				raf.seek(pos);//Nos posicionamos en posicion
				id = raf.readInt();//Obtenemos la id del empleado
				for( int i = 0; i < apellido.length; i++)
				{
					aux = raf.readChar(); //Recorro uno a uno los caracteres del apellido
					apellido[i] = aux; //Los voy guardando en el array
				}
				dep = raf.readInt(); //Obtengo el departamento
				salario = raf.readDouble(); //Obtengo el salario
				
				String ap = new String(apellido); //Convierto a un String el array con el apellido
				
				System.out.println("ID: "+id+" APELLIDO: "+ap+" DEPARTAMENTO: "+dep+" SALARIO: "+salario);
				pos = pos+36;//Me posiciono en el siguiente empleado
				
				//- Si he recorrido el todos los bytes salgo del for-//
				if(raf.getFilePointer() == raf.length()) break;
			}
			raf.close();
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
			
	}
}
		
