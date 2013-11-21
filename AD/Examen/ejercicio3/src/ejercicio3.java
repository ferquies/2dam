import java.io.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Connection;


public class ejercicio3 {
	public static void main(String[] args) {
		String fichero = "/home/ferquies/2dam/AD/Examen/fichero_aleatorio.dat";
		int id, nacimiento, posicion = 0, registros = 0, pv = 1;
		char codigo[] = new char[4];
		char nombre[] = new char[20];
		char apellido[] = new char[20];
		char pais[] = new char[20];
		char ciudad[] = new char[20];
		char estudios[] = new char[20];
		char aux;
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/autores","root","");
		    Statement sentencia = conexion.createStatement();
		    sentencia.executeUpdate("CREATE TABLE IF NOT EXISTS tb_autores (id INT NOT NULL PRIMARY KEY, codigo VARCHAR(20), nombre VARCHAR(20), apellido VARCHAR(20), pais VARCHAR(20), nacimiento INT, ciudad VARCHAR(20), estudios VARCHAR(20), salario INT(16))");
			
		    File f = new File(fichero);
		    RandomAccessFile raf = new RandomAccessFile(f, "r");
		    for(;;) {
		    	raf.seek(posicion);
		    	id = raf.readInt();
				for(int i = 0; i < codigo.length; i++) {
				    aux = raf.readChar();
				    codigo[i] = aux;
				}
				String cod = new String(codigo).trim();
				for(int i = 0; i < nombre.length; i++) {
				    aux = raf.readChar();
				    nombre[i] = aux;
				}
				String nom = new String(nombre).trim();
				for(int i = 0; i < apellido.length; i++) {
				    aux = raf.readChar();
				    apellido[i] = aux;
				}
				String ap = new String(apellido).trim();
				for(int i = 0; i < pais.length; i++) {
				    aux = raf.readChar();
				    pais[i] = aux;
				}
				String pa = new String(pais).trim();
				nacimiento = raf.readInt();
				for(int i = 0; i < ciudad.length; i++) {
				    aux = raf.readChar();
				    ciudad[i] = aux;
				}
				String ciu = new String(ciudad).trim();
				for(int i = 0; i < estudios.length; i++) {
				    aux = raf.readChar();
				    estudios[i] = aux;
				}
				String es = new String(estudios).trim();
				
				try {
				    sentencia.executeUpdate("INSERT INTO tb_autores VALUES("+ id + ", '" + cod + "', '" + nom + "', '" + ap + "', '" + pa + "', " + nacimiento + ", '" + ciu + "', '" + es + "', 0)");
				    registros++;
				} catch(SQLException sql) {
				    if(pv == 1) {
						System.out.println("AUTORES NO DADOS DE ALTA");
						System.out.println("------------------------");
						pv = 0;
				    }
				    System.out.println("ID Autor: " + id + " | Codigo: " + cod + " | Nombre: " + nom + " | Apellido: " + ap + " | Pais: " + pa + " | Nacimiento: " + nacimiento + " | Ciudad: " + ciu + " | Estudios: " + es + " | Salario: 0");
				    System.out.println("Mensaje de SQL: " + sql.getMessage() + " SQL estado: " + sql.getSQLState() + " Cod error: " + sql.getErrorCode());
				}
					
				posicion += 216;
					
				if(raf.getFilePointer() == raf.length()) { break; }
		    }
		    
		    System.out.println();
		    System.out.println("AUTORES EN LA TABLA TB_AUTORES");
		    System.out.println("------------------------------");
		    ResultSet result = sentencia.executeQuery("SELECT * FROM tb_autores");
		    while(result.next()) {
				System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getInt(6)+" "+result.getString(7)+" "+result.getString(8)+" "+result.getInt(9));
				System.out.println("------------------------------");
		    }
		    System.out.println("Total filas insertadas: " + registros);
			
		    raf.close();
		    result.close();
		    sentencia.close();
		    conexion.close();
		} catch(ClassNotFoundException cn) { cn.printStackTrace(); }
		catch(SQLException e) { e.printStackTrace(); }
		catch(Exception e) { e.printStackTrace(); }
	}
}