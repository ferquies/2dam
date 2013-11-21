import java.sql.*;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;

public class Ejercicio6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcion=0;
		
		System.out.println("Ingrese con que base quiere insertar (1->Mysql | 2-> Oracle | 3-> Sqlite): ");
		Scanner teclado = new Scanner(System.in);
		opcion = teclado.nextInt();
		
		System.out.println("Ingrese el identificador de la venta: ");
		Scanner idventa = new Scanner(System.in);
		int idventax = idventa.nextInt();				
		int idventay=0;
		int errorventa=0;
		
		System.out.println("Ingrese el identificador del cliente: ");
		Scanner idcliente = new Scanner(System.in);
		int idclientex = idcliente.nextInt();		
		int idclientey = 0;
		int errorcliente=0;
		
		System.out.println("Ingrese el identificador del producto: ");
		Scanner idproducto = new Scanner(System.in);
		int idproductox = idproducto.nextInt();				
		int idproductoy = 0;		
		int errorproducto=0;
		
		System.out.println("Ingrese la cantidad: ");
		Scanner cantidad = new Scanner(System.in);
		int cantidadx = cantidad.nextInt();	
		int errorcantidad=0;
		
		try{
			
			
			if(opcion==1)
			{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conexion  = DriverManager.getConnection("jdbc:mysql://localhost/unidad2","UNIDAD2","UNIDAD2");
					
					Statement sentencia= conexion.createStatement();
					
					
					
						ResultSet resulventa = sentencia.executeQuery("SELECT idventa FROM ventas");
						while(resulventa.next())
						{
						
						
						idventay=resulventa.getInt(1);
						
						if(idventay==idventax){errorventa=1;break;}
						
						}
						resulventa.close();
				
						
						ResultSet resulcliente = sentencia.executeQuery("SELECT id FROM clientes");
						while(resulcliente.next())
						{
						
						
						idclientey=resulcliente.getInt(1);
						if(idclientey==idclientex){errorcliente=0;break;}else{errorcliente=1;}
						
						}
						resulcliente.close();
						
						
						
						ResultSet resulproducto = sentencia.executeQuery("SELECT id FROM productos");
						while(resulproducto.next())
						{
						
						
						idproductoy=resulproducto.getInt(1);
						if(idproductoy==idproductox){errorproducto=0;break;}else{errorproducto=1;}
						
						}
						
						resulproducto.close();
						
						
						
						
						
						if(cantidadx>=0){}else{errorcantidad=1;}
						
						
						Calendar c = Calendar.getInstance();
						String dia = Integer.toString(c.get(Calendar.DATE));
						String mes = Integer.toString(c.get(Calendar.MONTH));
						String annio = Integer.toString(c.get(Calendar.YEAR));	
						
						String fecha = annio+"-"+mes+"-"+dia;
						
					if(errorventa==0)
					{
						if(errorcliente==0)
						{	
							if(errorproducto==0)
							{
								
								if(errorcantidad==0)
								{	
									
								sentencia.executeUpdate("INSERT INTO ventas (idventa,fechaventa,idcliente,idproducto,cantidad) VALUES ('"+idventax+"','"+fecha+"','"+idclientex+"','"+idproductox+"','"+cantidadx+"' )");
								System.out.println("Se ha insertado la venta satisfactoriamente");
								
								}
							
							}
						
												
						}
						
						
					}
					
					
					
					if(errorventa==1){System.out.println("El identificador de ventas existe en la tabla Ventas");}
					if(errorcliente==1){System.out.println("El identificador del cliente no existe en la tabla Clientes");}
					if(errorproducto==1){System.out.println("El identificador del producto no existe en la tabla Productos");}
					if(errorcantidad==1){System.out.println("La cantidad debe ser mayor que 0");}	
					
					
									
						sentencia.close();
						conexion.close();
						
						
						
			}
			else if(opcion==2)
			{
		
			
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conexion  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","UNIDAD2","UNIDAD2");
					
					Statement sentencia= conexion.createStatement();
				
					

					
					
					ResultSet resulventa = sentencia.executeQuery("SELECT idventa FROM ventas");
					while(resulventa.next())
					{
					
					
					idventay=resulventa.getInt(1);
					
					if(idventay==idventax){errorventa=1;break;}
					
					}
					resulventa.close();
			
					
					ResultSet resulcliente = sentencia.executeQuery("SELECT id FROM clientes");
					while(resulcliente.next())
					{
					
					
					idclientey=resulcliente.getInt(1);
					if(idclientey==idclientex){break;}else{errorcliente=1;break;}
					
					}
					resulcliente.close();
					
					
					
					ResultSet resulproducto = sentencia.executeQuery("SELECT id FROM productos");
					while(resulproducto.next())
					{
					
					
					idproductoy=resulproducto.getInt(1);
					if(idproductoy==idproductox){break;}else{errorproducto=1;break;}
					
					}
					resulproducto.close();
					
					
					
					
					
					if(cantidadx>=0){}else{errorcantidad=1;}
					
					java.util.Date date = new java.util.Date(); 
					Calendar c = Calendar.getInstance();
					String dia = Integer.toString(c.get(Calendar.DATE));
					String mes = Integer.toString(c.get(Calendar.MONTH));
					String annio = Integer.toString(c.get(Calendar.YEAR));	
					
					String fecha = annio+"/"+mes+"/"+dia;
					java.text.SimpleDateFormat fecha2=new java.text.SimpleDateFormat("yy/MM/dd");
					fecha = fecha2.format(date);
					
				if(errorventa==0)
				{
					if(errorcliente==0)
					{	
						if(errorproducto==0)
						{
							
							if(errorcantidad==0)
							{	
								
							sentencia.executeUpdate("INSERT INTO ventas (idventa,fechaventa,idcliente,idproducto,cantidad) VALUES ('"+idventax+"','"+fecha+"','"+idclientex+"','"+idproductox+"','"+cantidadx+"' )");
							System.out.println("Se ha insertado la venta satisfactoriamente");
							
							}
						
						}
					
											
					}
					
					
				}
				
			
				if(errorventa==1){System.out.println("El identificador de ventas existe en la tabla Ventas");}
				if(errorcliente==1){System.out.println("El identificador del cliente no existe en la tabla Clientes");}
				if(errorproducto==1){System.out.println("El identificador del producto no existe en la tabla Productos");}
				if(errorcantidad==1){System.out.println("La cantidad debe ser mayor que 0");}	
					
				
					
					
						
						sentencia.close();
						conexion.close();
			
			
		
		
					

				
			}			
			else if(opcion==3)
			{
					Class.forName("org.sqlite.JDBC");
					Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:/db/sqlite/UNIDAD2.db");
					
					Statement sentencia= conexion.createStatement();
				

					
					ResultSet resulventa = sentencia.executeQuery("SELECT idventa FROM ventas");
					while(resulventa.next())
					{
					
					
					idventay=resulventa.getInt(1);
					
					if(idventay==idventax){errorventa=1;break;}
					
					}
					resulventa.close();
			
					
					ResultSet resulcliente = sentencia.executeQuery("SELECT id FROM clientes");
					while(resulcliente.next())
					{
					
					
					idclientey=resulcliente.getInt(1);
					if(idclientey==idclientex){break;}else{errorcliente=1;break;}
					
					}
					resulcliente.close();
					
					
					
					ResultSet resulproducto = sentencia.executeQuery("SELECT id FROM productos");
					while(resulproducto.next())
					{
					
					
					idproductoy=resulproducto.getInt(1);
					if(idproductoy==idproductox){break;}else{errorproducto=1;break;}
					
					}
					resulproducto.close();
					
					
					
					
					
					if(cantidadx>=0){}else{errorcantidad=1;}
					
					
					Calendar c = Calendar.getInstance();
					String dia = Integer.toString(c.get(Calendar.DATE));
					String mes = Integer.toString(c.get(Calendar.MONTH));
					String annio = Integer.toString(c.get(Calendar.YEAR));	
					
					String fecha = annio+"-"+mes+"-"+dia;
					
				if(errorventa==0)
				{
					if(errorcliente==0)
					{	
						if(errorproducto==0)
						{
							
							if(errorcantidad==0)
							{	
								
							sentencia.executeUpdate("INSERT INTO ventas (idventa,fechaventa,idcliente,idproducto,cantidad) VALUES ('"+idventax+"','"+fecha+"','"+idclientex+"','"+idproductox+"','"+cantidadx+"' )");
							System.out.println("Se ha insertado la venta satisfactoriamente");
							
							}
						
						}
					
											
					}
					
					
				}
				
			
				if(errorventa==1){System.out.println("El identificador de ventas existe en la tabla Ventas");}
				if(errorcliente==1){System.out.println("El identificador del cliente no existe en la tabla Clientes");}
				if(errorproducto==1){System.out.println("El identificador del producto no existe en la tabla Productos");}
				if(errorcantidad==1){System.out.println("La cantidad debe ser mayor que 0");}	
				
					
						sentencia.close();
						conexion.close();					
				
						
						
			}			
			}catch(ClassNotFoundException cn) {cn.printStackTrace();}
			catch(SQLException e){e.printStackTrace();}
		}
		
		
		
	
}

