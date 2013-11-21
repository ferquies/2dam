import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;


public class Main {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/test","mysql","");
			Statement sentencia = conexion.createStatement();
			ResultSet result = sentencia.executeQuery("SELECT * FROM departamentos");
			while(result.next())
			{
				System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3));
				
			}
			result.close();
			sentencia.close();
			conexion.close();
		}catch(ClassNotFoundException cn){
			cn.printStackTrace();
		}catch(SQLException sql){
			sql.printStackTrace();
		}
		
		
	
	}

}
