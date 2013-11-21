import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class ejercicio1 {
    public static void main(String[] args) {
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	try {
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("AUTORES_con_errores.xml"));
		document.getDocumentElement().normalize();
		
		String fichero = "fichero_aleatorio.dat";
		File f = new File(fichero);
		RandomAccessFile raf = new RandomAccessFile(f, "rw");
		StringBuffer buffer = null;
		
		NodeList autores = document.getElementsByTagName("AUTORES");
		for(int i = 0 ; i < autores.getLength(); i++) {
		    Node autor = autores.item(i);
		    if(autor.getNodeType() == Node.ELEMENT_NODE) {
			Element elemento = (Element) autor;
			// 2 enteros, todos de 20 menos codigo que es de 4
			System.out.println("-----------Autor-----------");
			// ID AUTOR
			raf.writeInt(i + 1);
			
			// CODIGO
			String codigo = String.valueOf(getNodo("CODIGO",elemento));
			buffer = new StringBuffer(codigo);
			buffer.setLength(4);
			raf.writeChars(buffer.toString());
			System.out.println("Codigo: " + codigo);
			
			// NOMBRE
			String nombre = String.valueOf(getNodo("NOMBRE",elemento));
			buffer = new StringBuffer(nombre);
			buffer.setLength(20);
			raf.writeChars(buffer.toString());
			System.out.println("Nombre: " + nombre);
			
			// APELLIDO
			String apellido = String.valueOf(getNodo("_x0031_er_x0020_APELLIDO",elemento));
			buffer = new StringBuffer(apellido);
			buffer.setLength(20);
			raf.writeChars(buffer.toString());
			System.out.println("Apellido: " + apellido);
			
			// PAIS
			String pais = String.valueOf(getNodo("PAIS",elemento));
			buffer = new StringBuffer(pais);
			buffer.setLength(20);
			raf.writeChars(buffer.toString());
			System.out.println("Pais: " + pais);
			
			//NACIMIENTO
			int nacimiento = Integer.valueOf(getNodo("AÑO_x0020_NACIMIENTO",elemento));
			raf.writeInt(nacimiento);
			System.out.println("Año de nacimiento: " + nacimiento);
			
			//CIUDAD
			String ciudad = String.valueOf(getNodo("CIUDAD",elemento));
			buffer = new StringBuffer(ciudad);
			buffer.setLength(20);
			raf.writeChars(buffer.toString());
			System.out.println("Ciudad: " + ciudad);
			
			// FALLECIMIENTO (que se ignora)
			// Solucionado error con la fecha de fallecimiento que no siempre aparece en el xml para cada autor
			if(getNodo("FALLECIMIENTO", elemento) != null) {
			    // String fallecimiento = String.valueOf(getNodo("AÑO_x0020_FALLECIMIENTO",elemento));
			    // System.out.println("Fallecimiento: " + fallecimiento);
			}
			
			// ESTUDIOS
			String estudios = String.valueOf(getNodo("CENTRO_x0020_ESTUDIOS",elemento));
			buffer = new StringBuffer(estudios);
			buffer.setLength(20);
			raf.writeChars(buffer.toString());
			System.out.println("Estudios: " + estudios);
			
			// INFLUENCIA (que se ignora)
			// Solucionado error con la influencia que no siempre aparece en el xml para cada autor
			if(getNodo("INFLUENCIA",elemento) != null) {
			    // String influencia = String.valueOf(getNodo("INFLUENCIA",elemento));
			    // System.out.println("Influencia: " + influencia);
			}
		    }
		}
		raf.close();	
	} catch(Exception e){ e.printStackTrace(); }
    }
	
    private static String getNodo(String etiqueta, Element elem) {
	try {
	    NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
	    Node valornodo = (Node) nodo.item(0);
	    return valornodo.getNodeValue();
	} catch(NullPointerException e) { return null; }
    }
}
