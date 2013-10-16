import java.io.File;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

class ej20 {
	private static String getNodo(String etiqueta, Element elem) {
		NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
		Node valornodo = (Node) nodo.item(0);
		return valornodo.getNodeValue();
	}
	
	static void CrearElemento(String datoEmpe, String valor, Element raiz, Document document) {
		Element elem = document.createElement(datoEmpe);
		Text text = document.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(text);
	}
	
	static void EscribirFich(Element ele) { }
	
	public static void main(String []args) {
		try {
			DocumentBuilderFactory factory1 = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder1 = factory1.newDocumentBuilder();
			Document documento1 = builder1.parse(new File("fichero1.xml"));
			
			DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder2 = factory2.newDocumentBuilder();
			Document documento2 = builder2.parse(new File("fichero2.xml"));
			
			DocumentBuilderFactory factory3 = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder3 = factory3.newDocumentBuilder();
			DOMImplementation implementation = builder3.getDOMImplementation();
			Document document3 = implementation.createDocument(null, "Empleados", null);
			document3.setXmlVersion("1.0");
			
			int i = 0, j = 0;
			
			NodeList empleados1 = documento1.getElementsByTagName("empleado");
			
			
			NodeList empleados2 = documento2.getElementsByTagName("empleado");
			
			Node emple1 = empleados1.item(i);
			Element elemento1 = (Element) emple1;
			Node emple2 = empleados2.item(j);
			Element elemento2 = (Element) emple2;
			
			
			while(i < empleados1.getLength() || j < empleados2.getLength()) {
				if(Integer.parseInt(getNodo("id", elemento1)) < Integer.parseInt(getNodo("id", elemento2))) {
					EscribirFich(elemento1);
					i++;
					emple1 = empleados1.item(i);
					elemento1 = (Element) emple1;
				} else {
					EscribirFich(elemento2);
					j++;
					emple2 = empleados2.item(j);
					elemento2 = (Element) emple2;
				}
			}
			while(i < empleados1.getLength()) {
				EscribirFich(elemento1);
				i++;
				emple1 = empleados1.item(i);
				elemento1 = (Element) emple1;
			}
			while(j < empleados2.getLength()) {
				EscribirFich(elemento2);
				j++;
				emple2 = empleados2.item(j);
				elemento2 = (Element) emple2;
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document3);
			StreamResult result = new StreamResult(new File("fichero_destino.xml"));
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
