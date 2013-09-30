/*Generar un fichero xml empleando DOM*/

import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class ej18{
	public static void main(String args[])
	{	try{
		
			File fichero = new File("f_ej14.txt");
			RandomAccessFile raf = new RandomAccessFile(fichero,"r");
			
			int id,dep,pos = 0;
			double salario;
			char apellido[] = new char[10],aux;
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			try{
				DocumentBuilder db = dbf.newDocumentBuilder();
				DOMImplementation imple = db.getDOMImplementation();
				Document document =  imple.createDocument(null,"Empleados",null);
				document.setXmlVersion("1.0");
				
				for(;;){
					raf.seek(pos);
					id = raf.readInt();
					for(int i = 0; i < apellido.length; i++)
					{
						aux = raf.readChar();
						apellido[i] = aux;
					}
					String ap = new String(apellido);
					dep = raf.readInt();
					salario = raf.readDouble();
					
					if(id > 0){
						Element raiz = document.createElement("empleado");
						document.getDocumentElement().appendChild(raiz);
						
						CrearElemento("id",Integer.toString(id),raiz,document);
						CrearElemento("apellido",ap.trim(),raiz,document);
						CrearElemento("dep",Integer.toString(dep),raiz,document);
						CrearElemento("salario",Double.toString(salario),raiz,document);
					}
					pos = pos + 36;
					if(raf.getFilePointer() == raf.length()) break;
				}
				
				Source source = new DOMSource(document);
				Result result = new StreamResult(new java.io.File("Empleados2.xml"));
				Transformer transform =  TransformerFactory.newInstance().newTransformer();
				transform.transform(source,result);
			}catch(FileNotFoundException fnfe){fnfe.printStackTrace();}
			}catch(Exception e){
				e.printStackTrace();
			}
		
	}
	static void CrearElemento(String datoEmple,String valor,Element raiz,Document document){
		Element elem = document.createElement(datoEmple);
		Text text = document.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(text);
	}
}

					
