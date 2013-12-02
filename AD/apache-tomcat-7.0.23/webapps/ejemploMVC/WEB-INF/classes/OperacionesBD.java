import ejemplo.*;
import java.sql.*;
import java.util.*;

public class OperacionesBD {
  //OBTENCIÓN DE LA CONEXIÓN
  public Connection getConnection(){
     Connection conexion=null;
     try{
	 Class.forName("com.mysql.jdbc.Driver");//Cargar el driver
 	 conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo","ejemplo", "ejemplo");   
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
		String sql= "SELECT * FROM departamentos";
		ResultSet resul=sentencia.executeQuery(sql);		       
   		while(resul.next()){ //se crea un array con los datos de los departamentos		
			ejemplo.Departamentos  d=new ejemplo.Departamentos (resul.getByte("dept_no"),
	 	                 resul.getString("dnombre"),resul.getString("loc"));			
			departamentos.add(d);//añadir dep al array	
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
  
  public ArrayList listarEmp(){
	  ArrayList empleados = new ArrayList();
	  try{
		  Connection conexion = getConnection();
		  Statement sentencia = conexion.createStatement()
		  String sql = "SELECT * FROM empleados";
		  ResultSet result = sentencia.executeQuery(sql);
		  while(result.next())
		  {
			  empleados.Empleados e = new ejemplo.Empleados(result.getByte("empno"),
			  result.getString("apellido"),result.getString("oficio"));
			  empleados.add(e);
		  }
		  conexion.close();
		  
	  }
  }
  public void insertarEmple(ejemplo.Empleados e){
	  Connection conexion = getConnection();
	  Statement sentencia = conexion.createStatement();
	  String sql = "INSERT INTO empleados VALUES('" +e.getEmpno()+"','"+e.getApellido()+"','"+e.getOficio()+"')";
	  if(e.getEmpno() != 0) sentencia.executeUpdate(sql);
	  System.out.println("SQL: "+sql);
	  conexion.close();
  }
}//fin clase
