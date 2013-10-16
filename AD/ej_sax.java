import java.io.*;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

    
public class ej_sax {
	public static void main(String []args) throws FileNotFoundException, IOException,SAXException {
    		Empleado empleado = new Empleado();
    	
    		XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
    		GestionContenido gestor = new GestionContenido(empleado);
    		procesadorXML.setContentHandler(gestor);
    		InputSource fileXML = new InputSource("Empleados2.xml");
    		procesadorXML.parse(fileXML);
    }
}
    
    
class GestionContenido extends DefaultHandler {
	int a=0;
    private String valor=null;
    private Empleado empleado;
    	
	public GestionContenido(Empleado empleado) {
		this.empleado=empleado;
	}
	public void startDocument() {
		System.out.println("Comienzo del documento XML: ");
	}
	public void endDocument() {
		System.out.println("Fin del Documento XML");
	}
	public void startElement(String uri, String nombre, String nombreC, Attributes atts) throws SAXException {
		valor=null;
			
		if (nombre.equals("empleado")) {
			String id=atts.getValue("id");
			empleado.setId(valor);
		}
	}
	public void endElement(String uri, String nombre, String nombreC)throws SAXException {
		if(nombre.equals("apellido")) {
			empleado.setApellido(valor);
		}
		else if (nombre.equals("dep")) {
			empleado.setDepart(valor);
		}
		else if(nombre.equals("salario")) {
			empleado.setSalario(valor);
		}
		else if(nombre.equals("id")) {
			empleado.setId(valor);
		}
		else if(nombre.equals("empleado")) {
			if(empleado.depart.equals("20")) {
				System.out.println(empleado.toString());
			}
		}
	}
	public void characters(char[] ch, int start, int length) throws SAXException {
			 valor = new String(ch,start,length);
	}
}
    
class Empleado {
   	public String id = null;  
   	public String apellido = null;  
   	public String depart = null;  
   	public String salario= null;  
  
	public Empleado() { }  
	public String getId() {  
		return id;  
    }  
    	     
    public void setId(String id) {  
		this.id = id;  
    }  
    	     
    public String getApellido() {  
		return apellido;  
    }  
    	     
    public void setApellido(String apellido) {  
		this.apellido = apellido;  
    }  
    	     
    public String getDepart() {  
		return depart;  
    }  
    	     
    public void setDepart(String depart) {  
		this.depart = depart;  
    }  
    	     
    public String getSalario() {  
		return salario;  
    }  
    	     
    public void setSalario(String salario) {  
		this.salario = salario;  
    }  
    	 
    public String toString() {  
		StringBuilder sb = new StringBuilder();  
    	sb.append("\nID: "+id);  
    	sb.append("\nApellido: "+apellido);  
    	sb.append("\nDepartamento: "+depart);  
    	sb.append("\nSalario: "+salario);  
    	return sb.toString();  
    }  
}
