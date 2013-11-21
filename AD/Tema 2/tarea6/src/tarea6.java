
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;


public class tarea6 {

	public static void main(String[] args) {
		int programa;
		System.out.println("Selecciona el programa con el cual rellenar las tablas\n 1-->Oracle \n 2-->MYsql \n 3-->SQLite");
		Scanner teclado=new Scanner(System.in);
		programa=teclado.nextInt();
		
		if(programa==1)//ORACLE
		{
			try{
				int idVenta;
				System.out.println("Selecciona identificador de venta");
				Scanner teclado2=new Scanner(System.in);
				idVenta=teclado.nextInt();
				
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conexion  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","UNIDAD2","UNIDAD2");
				
				Statement sentencia= conexion.createStatement();

				sentencia.executeUpdate("INSERT INTO PRODUCTOS (ID, DESCRIPTION, STOCKACTUAL, STOCKMINIMO, PVP) VALUES ('1','JAMONES','20','10','10')");
				sentencia.executeUpdate("INSERT INTO CLIENTES (ID, NOMBRE, DIRECCION, POBLACION, TELEF, NIF) VALUES ('1','PEPE','CASICA','PETRER','6','4')");
				sentencia.executeUpdate("INSERT INTO VENTAS (IDVENTAS, FECHAVENTA, IDCLIENTE,IDPRODUCTO, CANTIDAD) VALUES ('"idVenta"','09/02/02','25','22','10')");
				

				ResultSet resul=sentencia.executeQuery("SELECT * FROM PRODUCTOS");
				while(resul.next())
				{
					System.out.println(resul.getInt(1)+" "+resul.getString(2)+" "+resul.getInt(3)+" "+resul.getInt(4)+" "+resul.getInt(4));
				}
				resul.close();
				
				
				ResultSet resul1=sentencia.executeQuery("SELECT * FROM CLIENTES");
				while(resul1.next())
				{
					System.out.println(resul1.getInt(1)+" "+resul1.getString(2)+" "+resul1.getString(3)+" "+resul1.getString(4)+" "+resul1.getString(5)+" "+resul1.getString(6));
				}
				resul1.close();
				
				
				ResultSet resul2=sentencia.executeQuery("SELECT * FROM VENTAS");
				while(resul2.next())
				{
					System.out.println(resul2.getInt(1)+" "+resul2.getDate(2)+" "+resul2.getInt(3)+" "+resul2.getInt(4)+" "+resul2.getInt(5));
				}
				resul2.close();
				
				
				sentencia.close();
				conexion.close();
				
				
				
					
					}catch(ClassNotFoundException cn) {cn.printStackTrace();}
					catch(SQLException e){e.printStackTrace();}
			
		}
		
		if(programa==2)//MySQL
		{
			try
			{
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/UNIDAD2","UNIDAD2","UNIDAD2");
				
				Statement sentencia=conexion.createStatement();
				sentencia.executeUpdate("INSERT INTO PRODUCTOS (ID, DESCRIPCION, STOCKACTUAL, STOCKMINIMO, PVP) VALUES ('1','JAMONES','20','10','100')");
				sentencia.executeUpdate("INSERT INTO CLIENTES (ID, NOMBRE, DIRECCION, POBLACION, TELEF, NIF) VALUES ('1','PEPE','CASICA','PETRER','966757567','45738368')");
				sentencia.executeUpdate("INSERT INTO VENTAS (IDVENTAS, FECHAVENTA, IDCLIENTE,IDPRODUCTO, CANTIDAD) VALUES ('1','2009-02-02','25','22','10')");
				ResultSet resul=sentencia.executeQuery("SELECT * FROM PRODUCTOS");
				while(resul.next())
				{
					System.out.println(resul.getInt(1)+" "+resul.getString(2)+" "+resul.getInt(3)+" "+resul.getInt(4)+" "+resul.getInt(4));
				}
				resul.close();
				
				
				ResultSet resul1=sentencia.executeQuery("SELECT * FROM CLIENTES");
				while(resul1.next())
				{
					System.out.println(resul1.getInt(1)+" "+resul1.getString(2)+" "+resul1.getString(3)+" "+resul1.getString(4)+" "+resul1.getString(5)+" "+resul1.getString(6));
				}
				resul1.close();
				
				
				ResultSet resul2=sentencia.executeQuery("SELECT * FROM VENTAS");
				while(resul2.next())
				{
					System.out.println(resul2.getInt(1)+" "+resul2.getDate(2)+" "+resul2.getInt(3)+" "+resul2.getInt(4)+" "+resul2.getInt(5));
				}
				resul2.close();
				
				
				
				
				
				
				sentencia.close();
				conexion.close();
				
		}catch(ClassNotFoundException cn) {cn.printStackTrace();}
			catch(SQLException e){e.printStackTrace();}
		}
		
		if(programa==3)//SQLite
		{
			try{
			Class.forName("org.sqlite.JDBC");
			Connection conexion=DriverManager.getConnection("jdbc:sqlite:C:/db/SQlite/ejemplo.bd");
			
			Statement sentencia=conexion.createStatement();
			sentencia.executeUpdate("INSERT INTO PRODUCTOS (ID, DESCRIPCION, STOCKACTUAL, STOCKMINIMO, PVP) VALUES ('1','JAMONES','20','10','100')");
			sentencia.executeUpdate("INSERT INTO CLIENTES (ID, NOMBRE, DIRECCION, POBLACION, TELEFONO, NIF) VALUES ('2','PEPE','CASICA','PETRER','966757567','45738368')");
			sentencia.executeUpdate("INSERT INTO VENTAS (IDVENTAS, FECHAVENTA, IDCLIENTE,IDPRODUCTO, CANTIDAD) VALUES ('2','2009-02-02','25','22','10')");
			ResultSet resul=sentencia.executeQuery("SELECT * FROM PRODUCTOS");
			while(resul.next())
			{
				System.out.println(resul.getInt(1)+" "+resul.getString(2)+" "+resul.getInt(3)+" "+resul.getInt(4)+" "+resul.getInt(4));
			}
			resul.close();
			
			
			ResultSet resul1=sentencia.executeQuery("SELECT * FROM CLIENTES");
			while(resul1.next())
			{
				System.out.println(resul1.getInt(1)+" "+resul1.getString(2)+" "+resul1.getString(3)+" "+resul1.getString(4)+" "+resul1.getString(5)+" "+resul1.getString(6));
			}
			resul1.close();
			
			
			ResultSet resul2=sentencia.executeQuery("SELECT * FROM VENTAS");
			while(resul2.next())
			{
				System.out.println(resul2.getInt(1)+" "+resul2.getDate(2)+" "+resul2.getInt(3)+" "+resul2.getInt(4)+" "+resul2.getInt(5));
			}
			resul2.close();
			
			
			
			sentencia.close();
			conexion.close();
			
			
			}catch(ClassNotFoundException cn) {cn.printStackTrace();}
			catch(SQLException e){e.printStackTrace();}
		
		
	}
}
}
