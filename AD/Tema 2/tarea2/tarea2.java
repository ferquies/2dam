import java.sql.*;
import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class tarea2 {
    public static void main(String[] args) {
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	try {
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("Empleados.xml"));
		document.getDocumentElement().normalize();
		
		NodeList empleados = document.getElementsByTagName("empleado");
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conexion  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ejemplo","ejemplo");
		Statement sentencia= conexion.createStatement();
		
			for(int i = 0 ; i < empleados.getLength(); i++) {
			    Node emple = empleados.item(i);
			    if(emple.getNodeType() == Node.ELEMENT_NODE) {
				Element elemento = (Element)emple;
				String id = String.valueOf(getNodo("id",elemento));
				String apellido = String.valueOf(getNodo("apellido",elemento));
				String dep = String.valueOf(getNodo("dep",elemento));
				String salario = String.valueOf(getNodo("salario",elemento));
				sentencia.executeUpdate("INSERT INTO empleados (id, apellido, dep, salario) VALUES ('"+Integer.parseInt(id)+"','"+apellido+"','"+Integer.parseInt(dep)+"','"+Integer.parseInt(salario)+"')");
			    }
			}
			
		sentencia.close();
		conexion.close();
			
	} catch(ClassNotFoundException cn) { cn.printStackTrace(); }
	catch(SQLException e){e.printStackTrace();}
	catch(Exception e){e.printStackTrace();}
    }
	
    private static String getNodo(String etiqueta,Element elem) {
	NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
	Node valornodo = (Node)	nodo.item(0);
	return valornodo.getNodeValue();
    }
}
