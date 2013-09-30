
import java.io.File;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class ej19{
	public static void main(String args[])
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try{
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(new File("Empleados2.xml"));
			document.getDocumentElement().normalize();
			
			System.out.println("Elemento raiz: "+document.getDocumentElement().getNodeName());
			//Crea una lista con todos los nodos empleados
			NodeList lista = document.getElementsByTagName("empleado");
			//recorrer la lista
			for(int i = 0; i < lista.getLength(); i++){
				Node emple = lista.item(i);
				if(emple.getNodeType() == Node.ELEMENT_NODE){
					
				Element elemento = (Element) emple;
				System.out.println("ID: "+getNodo("id",elemento));
				System.out.println("Apellido: "+getNodo("apellido",elemento));
				System.out.println("Departamento: "+getNodo("dep",elemento));
				System.out.println("Salario: "+getNodo("salario",elemento));
				}
			}
		}catch(Exception e){e.printStackTrace();}
	}
	private static String getNodo(String etiqueta,Element elem)
	{
		NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
		Node valornodo = (Node) nodo.item(0);
		return valornodo.getNodeValue();
	}
}
				
