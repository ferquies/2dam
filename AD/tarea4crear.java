/*Fichero de acceso aleatorio RandomAccesFile*/

import java.io.*;
import java.util.*;

public class tarea4crear {
	public static void main(String args[])
	{
		try{
					
			File f = new File("tarea4.dat");
			//-Se declara el fichero de acceso aleatorio con permisos rw-//
			RandomAccessFile raf = new RandomAccessFile(f,"rw");
			
			//-Arrays con los datos a escribir-//
			String apellido[] = {"FERNANDEZ","GIL","LOPEZ","RAMOS","SEVILLA","CASILLA","REY"};//Apellidos
			int dep [] = {10,20,10,10,30,30,20};//Nº departamentos
			double salario[] = {1000.45,2400.60,3000.0,1500.56,2200.0,1435,87,2000.0};//Salario
			StringBuffer sb = null;//Buffer para almacenar los apellidos 
			int n = apellido.length;//Nº elementos del array
			for (int i = 0; i < n; i++)
			{
				int valor = (int) Math.floor(Math.random()*25+1);
				raf.writeInt(valor);// Empleo i+1 para identificar empleado
				sb = new StringBuffer(apellido[i]);
				sb.setLength(10);//10 Caracteres para el apellido
				raf.writeChars(sb.toString());//Inserto el apellido
				raf.writeInt(dep[i]);//Inserto el departamento
				raf.writeDouble(salario[i]);//Inserto el salario
			}
			raf.close();//Cierro fichero raf
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
			
	}
}
