/* Leemos de dos ficheros xml y lo volcamos en un tercer fichero ordenados por id*/

import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
public class ej20{
	public static void main(String args[])
		{
			int id1,id2,dep;
			double salario;
			String apellido;
			int a=0,b=0;
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			try{
				DocumentBuilder fsalida = factory.newDocumentBuilder();
				DOMImplementation imple = fsalida.getDOMImplementation();
				Document dsalida = imple.createDocument(null,"Empleados",null);
				dsalida.setXmlVersion("1.0");
				Source source = new DOMSource(dsalida);
				Result result = new StreamResult(new java.io.File("fichero3.xml"));
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.transform(source,result);
				
				DocumentBuilder builder_f1 = factory.newDocumentBuilder();
				DocumentBuilder builder_f2 = factory.newDocumentBuilder();
				Document document_f1 = builder_f1.parse(new File("fichero1.xml"));
				Document document_f2 = builder_f1.parse(new File("fichero2.xml"));				
				document_f1.getDocumentElement().normalize();
				
				Element elemento1 = (Element)emple1;
				Element elemento2 = (Element)emple2;
				id1 = Integer.parseInt(getNodo("id",elemento1));
				id2 = Integer.parseInt(getNodo("id",elemento2));
				
				NodeList empleados_f1 = document_f1.getElementsByTagName("empleado");
				NodeList empleados_f2 = document_f2.getElementsByTagName("empleado");
				
				
				if(id1 < id2)
				{
					for(int i = 0; i < empleados_f1.getLength(); i++)
					{
						Node emple1 = empleados_f1.item(a);
						if(emple1.getNodeType() == Node.ELEMENT_NODE){
							elemento1 = (Element) emple1;
							System.out.println("ID"+getNodo("id",elemento1));
							System.out.println("Apellido"+getNodo("apellido",elemento1));
							System.out.println("Dep"+getNodo("dep",elemento1));
							System.out.println("Salario"+getNodo("salario",elemento1));
						}
						a++;
					}
				}
				else
				{
					for(int i = 0; i < empleados_f1.getLength(); i++)
					{
						Node emple2 = empleados_f2.item(b);
						if(emple2.getNodeType() == Node.ELEMENT_NODE){
							elemento2 = (Element) emple2;
							System.out.println("ID"+getNodo("id",elemento2));
							System.out.println("Apellido"+getNodo("apellido",elemento2));
							System.out.println("Dep"+getNodo("dep",elemento2));
							System.out.println("Salario"+getNodo("salario",elemento2));
						}
						b++;
					}
				}
					
						
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		private static String getNodo(String etiqueta,Element elem)
		{
			NodeList  nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
			Node valornodo = (Node) nodo.item(0);
			return valornodo.getNodeValue();
		}
		static void CrearElemento(String datoEmple,String valor,Element raiz, Document document){
			Element elem = document.createElement(datoEmple);
			Text text = document.createTextNode(valor);
			raiz.appendChild(elem);
			elem.appendChild(text);
		}
}
	
