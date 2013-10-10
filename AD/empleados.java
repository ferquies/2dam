import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class empleados {
	public static void main(String args[]) throws Exception {
		String stylesheet = "empleados.xsl";
		String emple = "Empleados.xml";
		File html = new File("empleados.html");
		FileOutputStream fos = new FileOutputStream(html);
		Source styles = new StreamSource(stylesheet);
		Source datos = new StreamSource(emple);
		Result result = new StreamResult(fos);
		
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer(styles);
			transformer.transform(datos, result);
		} catch(Exception e) { System.err.println("Error: " + e); }
		
		fos.close();
	}
}
