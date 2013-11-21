import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
	public static void main(String[] args) {
		try{
			Class.forName("org.h2.Driver");
			Connection conexion = (Connection)DriverManager.getConnection("jdbc:h2:/home/ferquies/2dam/AD/Tema 2/h2/test","sa","");
			Statement sentencia = conexion.createStatement();
			ResultSet result = sentencia.executeQuery("SELECT * FROM departamentos;");
			while(result.next()) {
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
