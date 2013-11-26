import ejemplo.*;
import java.sql.*;
import java.util.*;

public class OperacionesBD {
  //OBTENCION DE LA CONEXION
  public Connection getConnection(){
     Connection conexion=null;
     try{
	 Class.forName("com.mysql.jdbc.Driver");//Cargar el driver
 	 conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");   
     }
     catch(Exception e){e.printStackTrace();}
     return conexion;
  }
  //LISTAR
  public ArrayList listarDep(){	
	ArrayList departamentos = new ArrayList ();
	try{
		Connection conexion =getConnection();
		Statement sentencia=conexion.createStatement();
		String sql= "SELECT * FROM departamentos;";
		ResultSet resul=sentencia.executeQuery(sql);		       
   		while(resul.next()){ //se crea un array con los datos de los departamentos		
			ejemplo.Departamentos d=new ejemplo.Departamentos (resul.getInt("dept_no"),resul.getString("dnombre"),resul.getString("loc"));
			departamentos.add(d);//anadir dep al array	
		}	
		conexion.close();
		}
    catch(Exception e){e.printStackTrace();}
    return(departamentos);
  }//fin listarDep
  //INSERTAR
  public void insertaDepartamento(ejemplo.Departamentos d){
	try{
		Connection conexion=getConnection();
		Statement sentencia=conexion.createStatement();
		String sql = "INSERT INTO departamentos VALUES('" +d.getDeptno()+"','"+d.getDnombre()+"','"+d.getLoc()+"')";		
		if (d.getDeptno () != 0) sentencia.execute(sql);
		System.out.println("SQL: "+sql);
		conexion.close();
    }
	catch(Exception e){e.printStackTrace();}
  }//fin insertaDepartamento
  
}//fin clase
