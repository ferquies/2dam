import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.*;

public class Pantalla extends JFrame implements ActionListener
{   
    private static final long serialVersionUID = 1L;
    JLabel etiqueta=new JLabel("");
    JLabel label = new JLabel("Introduce numero de departamento:");
    JTextField depar = new JTextField(2);    
    JButton boton = new JButton("Consultar");
    
    // contenedor para botones
    public void iniciar() {
      getContentPane().setLayout(new GridLayout(10, 1));       
      // contenedor para botones
      JPanel panelBotones = new JPanel(new FlowLayout());
      panelBotones.add(label);
      panelBotones.add(depar);
      panelBotones.add(boton);   
      
      getContentPane().add(panelBotones);
      getContentPane().add(etiqueta);
      setVisible(true);
      pack();
      boton.addActionListener(this);  //pulsamos el boton    
    }

    //accion cuando pulsamos botones 
    public void actionPerformed(ActionEvent e)    {
      if (e.getSource() == boton) { //SE PULSA EL BOTON    	
      etiqueta.setText(" Departamento a consultar: "+depar.getText());    		
      int dep;
      try {
    		dep=Integer.parseInt(depar.getText());
    		VisualizarDep(dep);//visualiza datos del departamento
       } catch(java.lang.NumberFormatException ex){
      	  etiqueta.setText(" DEPARTAMENTO ERRONEO");
    	}
      }      
    } 
    
    //LOCALIZAR DATOS DEL DEPARTAMENTO
    void VisualizarDep (int dep) { //pinto datos del dep
    	SessionFactory sesion= SessionFactoryUtil.getSessionFactory();		
		Session session = sesion.openSession();
	
		Departamentos depart = (Departamentos) session.createQuery(
				 "from Departamentos as de " +
		  		 "where de.deptNo = ?").setInteger(0, dep).uniqueResult();
		if (depart != null){			
		  etiqueta.setText(" Nombre Departamento: "+depart.getDnombre());
		  VisualizarEmp(dep); //visualizo los empleados	  
		}
		else
			etiqueta.setText(" NO EXISTE EL DEPARTAMENTO.....");		
		session.close();
		
     }//fin VisualizarDep

     //LOCALIZAR DATOS DE LOS EMPLEADOS
     void VisualizarEmp (int dep)  //pinto datos de los empleados del depart
     {    	
      JTextArea  area = new JTextArea(); 
      JScrollPane scroll= new  JScrollPane(area);
      //preparo el area para escribir los empleados
      area.setBounds(new Rectangle(20,70,250,400));
      scroll.setBounds(new Rectangle(20,70,250,400));
  	  area.setEditable(false);
  	  getContentPane().add(scroll,null);
   	  getContentPane().setLayout(null);
   	  area.setForeground(Color.blue);
   	  //  
      SessionFactory sesion= SessionFactoryUtil.getSessionFactory();		
	  Session session = sesion.openSession();
		
      Query q = session.createQuery(" from Empleados e where e.deptNo = :ndep");  	    
  	  q.setInteger("ndep",dep);
  	  Empleados emple = new Empleados(); 
  	  List <Empleados> lista = q.list();  	 
  	    
  	  area.append(" Numero de empleados: " + lista.size()+ "\n");	
  	  area.append(" -------------------------------------");
  	  area.append("\n APELLIDO\tOFICIO");
  	  area.append("\n ===========================");
  	  Iterator <Empleados> iter = lista.iterator();
  	  while (iter.hasNext())
  		 {
  		  emple = (Empleados) iter.next();  		
  		  String cad ="\n "+emple.getApellido() + "\t"+emple.getOficio();
  		  area.append(cad);		   
  		 }
  	  session.close();
  	  
      }//fin VisualizarEmp          
}//fin de la clase Pantalla
