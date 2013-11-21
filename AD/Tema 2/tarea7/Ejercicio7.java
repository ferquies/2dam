

import java.sql.*;
import java.util.Scanner;
import java.io.*;

public class Ejercicio7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcion=0;
		
		System.out.println("Ingrese con que base quiere insertar (1->Mysql | 2-> Oracle | 3-> Sqlite): ");
		Scanner teclado = new Scanner(System.in);
		opcion = teclado.nextInt();
		
		System.out.println("Ingrese el identificador del cliente: ");
		Scanner cliente = new Scanner(System.in);
		int idcliente = teclado.nextInt();
		

		
		String nombrecliente="";
		
		int ventas=0;		
		int idventa[];
		String descripcion[];
		int pvp[];
		int cantidad[];		
		int importe[];
		int total=0;
		
		
		try{
			
			
			if(opcion==1)
			{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conexion  = DriverManager.getConnection("jdbc:mysql://localhost/unidad2","UNIDAD2","UNIDAD2");
					
					Statement sentencia= conexion.createStatement();
				
				
		
					
					
						ResultSet resul = sentencia.executeQuery("SELECT nombre FROM clientes WHERE id='"+idcliente+"'");								
						while(resul.next())
						{
						
							nombrecliente=resul.getString(1);
							
						}
						resul.close();
		
						
						ResultSet resulventas = sentencia.executeQuery("SELECT COUNT(*) FROM ventas WHERE idcliente='"+idcliente+"'");	
						while(resulventas.next())
						{
							ventas=resulventas.getInt(1);	
						}
						resulventas.close();
						
						idventa= new int[ventas];
						descripcion= new String[ventas];
						pvp= new int[ventas];
						cantidad= new int[ventas];
						importe= new int[ventas];
						
						//VENTAS
						
					ResultSet resul2 = sentencia.executeQuery("SELECT idventa FROM ventas WHERE idcliente='"+idcliente+"'");						

					for(int i=0;i<ventas;i++)
					{	
						
							
						while(resul2.next())
						{
						
							idventa[i]=resul2.getInt(1);//IDVENTA
							break;
							
						}
						
						
					
					}
					resul2.close();

				
								
					
					

					for(int i=0;i<ventas;i++)
					{	
						ResultSet resul3 = sentencia.executeQuery("SELECT descripcion FROM productos WHERE id=(SELECT idproducto from ventas WHERE idventa='"+idventa[i]+"')");						
							
						while(resul3.next())
						{
						
							descripcion[i]=resul3.getString(1);//DESCRIPCION
							break;
							
						}
						if(i==ventas){resul3.close();}
					}
					
					for(int i=0;i<ventas;i++)
					{	
						ResultSet resul4 = sentencia.executeQuery("SELECT pvp FROM productos WHERE id=(SELECT idproducto from ventas WHERE idventa='"+idventa[i]+"')");						
							
						while(resul4.next())
						{
						
							pvp[i]=resul4.getInt(1);//PVP
							break;
							
						}
						if(i==ventas){resul4.close();}
					}
						
					
					for(int i=0;i<ventas;i++)
					{	
						ResultSet resul5 = sentencia.executeQuery("SELECT cantidad FROM ventas WHERE idventa='"+idventa[i]+"'");						
							
						while(resul5.next())
						{
						
							cantidad[i]=resul5.getInt(1);//CANTIDAD
							break;
							
						}
						if(i==ventas){resul5.close();}
					}					
					
					for(int j=0;j<ventas;j++)
					{
						
					importe[j]=cantidad[j]*pvp[j];//IMPORTE
					}
				
					for(int j=0;j<ventas;j++)
					{				
					
					total=importe[j]+total;// TOTAL
					}
				
					
					//A FICHERO
					
					File fichero = new File("C:/db/mysql/Ventas del cliente "+nombrecliente+".txt");
					PrintWriter fic = new PrintWriter(fichero);		
					
					
					fic.println("Ventas del cliente: " + nombrecliente );
					for(int j=0;j<ventas;j++)
					{	
					
					
					fic.println("");
					fic.println("Venta: " + idventa[j]);
					fic.println("");
					fic.println("\t Producto: " + descripcion[j] + "-- PVP: " +pvp[j]);
					fic.println("\t Cantidad: " + cantidad[j]);
					fic.println("\t Importe: " + importe[j]);
					fic.println("");
					fic.println("");
					}
					
					fic.println("Numero total de ventas: " + ventas);	
					fic.println("Importe total: " + total);
					
/*				for(int j=0;j<ventas;j++)
				{	
				System.out.println(nombrecliente + " " + idventa[j] + " " + descripcion[j]+ " " + pvp[j] + " " + cantidad[j]+ " " + importe[j]);
				}
				System.out.println(total);	*/				
				
				
				
				fic.append("");
				fic.close();
				
				
				
					sentencia.close();//FIN
					conexion.close();
						
						
						
			}
			else if(opcion==2)
			{
		
			
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conexion  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","UNIDAD2","UNIDAD2");
					
					Statement sentencia= conexion.createStatement();
				
					ResultSet resul = sentencia.executeQuery("SELECT nombre FROM clientes WHERE id='"+idcliente+"'");								
					while(resul.next())
					{
					
						nombrecliente=resul.getString(1);
						
					}
					resul.close();
	
					
					ResultSet resulventas = sentencia.executeQuery("SELECT COUNT(*) FROM ventas WHERE idcliente='"+idcliente+"'");	
					while(resulventas.next())
					{
						ventas=resulventas.getInt(1);	
					}
					resulventas.close();
					
					idventa= new int[ventas];
					descripcion= new String[ventas];
					pvp= new int[ventas];
					cantidad= new int[ventas];
					importe= new int[ventas];
					
					//VENTAS
					
				ResultSet resul2 = sentencia.executeQuery("SELECT idventa FROM ventas WHERE idcliente='"+idcliente+"'");						

				for(int i=0;i<ventas;i++)
				{	
					
						
					while(resul2.next())
					{
					
						idventa[i]=resul2.getInt(1);//IDVENTA
						break;
						
					}
					
					
				
				}
				resul2.close();

			
							
				
				

				for(int i=0;i<ventas;i++)
				{	
					ResultSet resul3 = sentencia.executeQuery("SELECT descripcion FROM productos WHERE id=(SELECT idproducto from ventas WHERE idventa='"+idventa[i]+"')");						
						
					while(resul3.next())
					{
					
						descripcion[i]=resul3.getString(1);//DESCRIPCION
						break;
						
					}
					if(i==ventas){resul3.close();}
				}
				
				for(int i=0;i<ventas;i++)
				{	
					ResultSet resul4 = sentencia.executeQuery("SELECT pvp FROM productos WHERE id=(SELECT idproducto from ventas WHERE idventa='"+idventa[i]+"')");						
						
					while(resul4.next())
					{
					
						pvp[i]=resul4.getInt(1);//PVP
						break;
						
					}
					if(i==ventas){resul4.close();}
				}
					
				
				for(int i=0;i<ventas;i++)
				{	
					ResultSet resul5 = sentencia.executeQuery("SELECT cantidad FROM ventas WHERE idventa='"+idventa[i]+"'");						
						
					while(resul5.next())
					{
					
						cantidad[i]=resul5.getInt(1);//CANTIDAD
						break;
						
					}
					if(i==ventas){resul5.close();}
				}					
				
				for(int j=0;j<ventas;j++)
				{
					
				importe[j]=cantidad[j]*pvp[j];//IMPORTE
				}
			
				for(int j=0;j<ventas;j++)
				{				
				
				total=importe[j]+total;// TOTAL
				}
			
				
				//A FICHERO
				
				File fichero = new File("C:/db/mysql/Ventas del cliente "+nombrecliente+".txt");
				PrintWriter fic = new PrintWriter(fichero);		
				
				
				fic.println("Ventas del cliente: " + nombrecliente );
				for(int j=0;j<ventas;j++)
				{	
				
				
				fic.println("");
				fic.println("Venta: " + idventa[j]);
				fic.println("");
				fic.println("\t Producto: " + descripcion[j] + "-- PVP: " +pvp[j]);
				fic.println("\t Cantidad: " + cantidad[j]);
				fic.println("\t Importe: " + importe[j]);
				fic.println("");
				fic.println("");
				}
				
				fic.println("Numero total de ventas: " + ventas);	
				fic.println("Importe total: " + total);
				
/*				for(int j=0;j<ventas;j++)
			{	
			System.out.println(nombrecliente + " " + idventa[j] + " " + descripcion[j]+ " " + pvp[j] + " " + cantidad[j]+ " " + importe[j]);
			}
			System.out.println(total);	*/				
			
			
			
			fic.append("");
			fic.close();
							
						sentencia.close();
						conexion.close();
			
			
		
		
					

				
			}			
			else if(opcion==3)
			{
					Class.forName("org.sqlite.JDBC");
					Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:/db/sqlite/UNIDAD2.db");
					
					Statement sentencia= conexion.createStatement();
				
					
					
					
					ResultSet resul = sentencia.executeQuery("SELECT nombre FROM clientes WHERE id='"+idcliente+"'");								
					while(resul.next())
					{
					
						nombrecliente=resul.getString(1);
						
					}
					resul.close();
	
					
					ResultSet resulventas = sentencia.executeQuery("SELECT COUNT(*) FROM ventas WHERE idcliente='"+idcliente+"'");	
					while(resulventas.next())
					{
						ventas=resulventas.getInt(1);	
					}
					resulventas.close();
					
					idventa= new int[ventas];
					descripcion= new String[ventas];
					pvp= new int[ventas];
					cantidad= new int[ventas];
					importe= new int[ventas];
					
					//VENTAS
					
				ResultSet resul2 = sentencia.executeQuery("SELECT idventa FROM ventas WHERE idcliente='"+idcliente+"'");						

				for(int i=0;i<ventas;i++)
				{	
					
						
					while(resul2.next())
					{
					
						idventa[i]=resul2.getInt(1);//IDVENTA
						break;
						
					}
					
					
				
				}
				resul2.close();

			
							
				
				

				for(int i=0;i<ventas;i++)
				{	
					ResultSet resul3 = sentencia.executeQuery("SELECT descripcion FROM productos WHERE id=(SELECT idproducto from ventas WHERE idventa='"+idventa[i]+"')");						
						
					while(resul3.next())
					{
					
						descripcion[i]=resul3.getString(1);//DESCRIPCION
						break;
						
					}
					if(i==ventas){resul3.close();}
				}
				
				for(int i=0;i<ventas;i++)
				{	
					ResultSet resul4 = sentencia.executeQuery("SELECT pvp FROM productos WHERE id=(SELECT idproducto from ventas WHERE idventa='"+idventa[i]+"')");						
						
					while(resul4.next())
					{
					
						pvp[i]=resul4.getInt(1);//PVP
						break;
						
					}
					if(i==ventas){resul4.close();}
				}
					
				
				for(int i=0;i<ventas;i++)
				{	
					ResultSet resul5 = sentencia.executeQuery("SELECT cantidad FROM ventas WHERE idventa='"+idventa[i]+"'");						
						
					while(resul5.next())
					{
					
						cantidad[i]=resul5.getInt(1);//CANTIDAD
						break;
						
					}
					if(i==ventas){resul5.close();}
				}					
				
				for(int j=0;j<ventas;j++)
				{
					
				importe[j]=cantidad[j]*pvp[j];//IMPORTE
				}
			
				for(int j=0;j<ventas;j++)
				{				
				
				total=importe[j]+total;// TOTAL
				}
			
				
				//A FICHERO
				
				File fichero = new File("C:/db/mysql/Ventas del cliente "+nombrecliente+".txt");
				PrintWriter fic = new PrintWriter(fichero);		
				
				
				fic.println("Ventas del cliente: " + nombrecliente );
				for(int j=0;j<ventas;j++)
				{	
				
				
				fic.println("");
				fic.println("Venta: " + idventa[j]);
				fic.println("");
				fic.println("\t Producto: " + descripcion[j] + "-- PVP: " +pvp[j]);
				fic.println("\t Cantidad: " + cantidad[j]);
				fic.println("\t Importe: " + importe[j]);
				fic.println("");
				fic.println("");
				}
				
				fic.println("Numero total de ventas: " + ventas);	
				fic.println("Importe total: " + total);
				
/*				for(int j=0;j<ventas;j++)
			{	
			System.out.println(nombrecliente + " " + idventa[j] + " " + descripcion[j]+ " " + pvp[j] + " " + cantidad[j]+ " " + importe[j]);
			}
			System.out.println(total);	*/				
			
			
			
			fic.append("");
			fic.close();
								
						sentencia.close();
						conexion.close();					
				
						
						
			}			
			}catch(ClassNotFoundException cn) {cn.printStackTrace();}
			catch(SQLException e){e.printStackTrace();}
			catch(FileNotFoundException fn ){System.out.println("No se encuentra el fichero");}
			catch(IOException io ){System.out.println("Error de E/S");}
		
		}
		
		
		
	
}
