import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Class.forName("org.hsqldb.jdbcDriver");
			Connection conexion = (Connection)DriverManager.getConnection("jdbc:hsqldb:file:/home/ferquies/2dam/AD/ejemplo");
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
