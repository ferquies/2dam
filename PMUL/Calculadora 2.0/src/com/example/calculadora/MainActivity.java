package com.example.calculadora;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends Activity {
	
	protected int estado=0;
	protected String ope1="";
	protected String ope2="";
	protected String operando="";
	protected String nombreBoton="";
	protected int resultado=0;
	protected String resultadoS="";
	
	
	
	
	
	 private View.OnClickListener gestorBotones=new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
				
				TextView texto=(TextView) findViewById(R.id.editText1);
				//INICIAMOS, SI ESTADO ES CERO LO PASAMOS AL 1	
				if(estado==0){estado=1;}
				//VINIENDO DE ESTADO DOS NOS PASAMOS A 3 PARA SEGUIR OPERANDO
				if(estado==2){estado=3;}
				
				if(estado==4){estado=1;ope1="";ope2="";texto.setText(ope1);}
				//SI NOS ENCONTRAMOS EN ESTADO 1 GUARDAMOS EL BOTON PULSADO Y EL OPERADOR1 SERÁ ESE BOTON MAS LOS SIGUIENTES EN PULSAR
				if(estado==1)
				{				
					nombreBoton=(String)((Button)v).getText();
					ope1= ope1+nombreBoton;		
					
				}
				//CON ESTADO 3 INTRODUCIMOS EL BOTON EN EL OPERADOR 2 
				if(estado==3)
				{
					
					nombreBoton=(String)((Button)v).getText();
					ope2= ope2+nombreBoton;
																		
				}
				
				texto.setText(texto.getText()+nombreBoton);

			}
		};
		
			
		private View.OnClickListener gestorOperaciones=new View.OnClickListener() {
					
				@Override
				public void onClick(View v) {
				// TODO Auto-generated method stub
							
					TextView texto=(TextView) findViewById(R.id.editText1);
					//CUANDO PULSAMOS LA OPERACION VINIENDO DE GESTOR BOTONES PASAMOS DEL ESTADO 1 AL 2
					if(estado==1){estado=2;}
					//CON ESTADO 3 COMPROBAMOS QUE OPERACION VA A REALIZAR PARA ENCADENAR SUMA Y RESTA Y ALMACENAMOS LO SUMADO EN OPER1
					//PARA SEGUIR SUMANDO
					if(estado==3)
					{
						
						if(operando.equals("+")){resultado=Integer.parseInt(ope1) + Integer.parseInt(ope2);
						
						ope1=String.valueOf(resultado);ope2="";
						
						}
						if(operando.equals("-")){resultado=Integer.parseInt(ope1) - Integer.parseInt(ope2);
						
						ope1=String.valueOf(resultado);ope2="";
						
						}
						//SE CAMBIA A 2 PARA PODER INTRODUCIR EL OPERANDO
						estado = 2;
						
					}
					
					//CON EL ESTADO SIENDO DOS AÑADIMOS EL OPERANDO 				
					if(estado==2)
					{
			
					operando=(String)((Button)v).getText();
					texto.setText(texto.getText()+operando);
					
					}
					
				}
			};
				
			
			
					
			private View.OnClickListener gestorbotonC=new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				// TODO Auto-generated method stub
								
					TextView texto=(TextView) findViewById(R.id.editText1);
					
					//EN BOTON C LIMPIAMOS Y PASAMOS AL ESTADO 0
					
					ope1="";
					ope2="";
					operando="";
					estado=0;
					
					
					texto.setText("");
				}
			};
			
			private View.OnClickListener gestorCambioSigno = new View.OnClickListener(){
				public void onClick(View v){
					TextView texto=(TextView) findViewById(R.id.editText1);
					int cambio_signo = Integer.parseInt(texto.getText().toString());
					
					//COMPRUEBO QUE LA VARIABLE Y LA MULTIPLICO POR -1 PARA OBTENER EL NEGATIVO O POSITIVO
					if(cambio_signo > 0){
					
						cambio_signo *= -1;
						texto.setText(String.valueOf(cambio_signo));
					}
					
					else{
						cambio_signo *= -1;
						texto.setText(String.valueOf(cambio_signo));
					}
					
					
				}
			
			};
			
		
		
			
			private View.OnClickListener gestorIgual=new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				// TODO Auto-generated method stub
								
					TextView texto=(TextView) findViewById(R.id.editText1);
					//EN EL BOTON IGUAL CON ESTADO 3 PASAMOS A ESTADO 4
					if(estado==3){estado=4;}
					
					//CON ESTADO 4 REALIZAMOS LA OPERACION Y MOSTRAMOS POR PANTALLA
					
					if(estado==4)
					{	
						if(operando.equals("+")){resultado=Integer.parseInt(ope1) + Integer.parseInt(ope2);}
						if(operando.equals("-")){resultado=Integer.parseInt(ope1) - Integer.parseInt(ope2);}
						if(operando.equals("*")){resultado=Integer.parseInt(ope1) * Integer.parseInt(ope2);}
						if(operando.equals("/")){resultado=Integer.parseInt(ope1) / Integer.parseInt(ope2);}
						
					}
					//PASAMOS EL RESULTADO A STRING Y MOSTRAMOS EN PANTALLA
					resultadoS=String.valueOf(resultado);					
					texto.setText(resultadoS);
			
				}
			};	
			
			

			
			
			
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
  
        // BOTONES NUMEROS  //       
        //Boton1
       	Button btn1 = (Button) findViewById(R.id.button1);
    	btn1.setOnClickListener(gestorBotones);    	
        //Boton2
       	Button btn2 = (Button) findViewById(R.id.button2);
    	btn2.setOnClickListener(gestorBotones);   	 
        //Boton3
       	Button btn3 = (Button) findViewById(R.id.button3);
    	btn3.setOnClickListener(gestorBotones);
    	//Boton4
       	Button btn4 = (Button) findViewById(R.id.button4);
    	btn4.setOnClickListener(gestorBotones);
    	//Boton5
       	Button btn5 = (Button) findViewById(R.id.button5);
    	btn5.setOnClickListener(gestorBotones);    	
        //Boton6
       	Button btn6 = (Button) findViewById(R.id.button6);
    	btn6.setOnClickListener(gestorBotones);
    	  //Boton7
       	Button btn7 = (Button) findViewById(R.id.button7);
    	btn7.setOnClickListener(gestorBotones);  
        //Boton8
       	Button btn8 = (Button) findViewById(R.id.button8);
    	btn8.setOnClickListener(gestorBotones);   
        //Boton9
       	Button btn9 = (Button) findViewById(R.id.button9);
    	btn9.setOnClickListener(gestorBotones);
    	//Boton0
       	Button btn0 = (Button) findViewById(R.id.button0);
    	btn0.setOnClickListener(gestorBotones);
    	       
    	// BOTONES OPERACIONES  // 
        //Creacion y gestor para el boton Resta
       	Button btnResta = (Button) findViewById(R.id.buttonResta);
    	btnResta.setOnClickListener(gestorOperaciones);
    	//Creacion y gestor para el boton Suma
       	Button btnSuma = (Button) findViewById(R.id.buttonSuma);
    	btnSuma.setOnClickListener(gestorOperaciones); 
    	//Creacion y gestor para el boton Multiplicacion
       	Button btnMultiplicacion = (Button) findViewById(R.id.buttonMultiplicacion);
    	btnMultiplicacion.setOnClickListener(gestorOperaciones);
    	//Creacion y gestor para el boton Igual
       	Button btnIgual = (Button) findViewById(R.id.buttonIgual);
    	btnIgual.setOnClickListener(gestorIgual);
    	//Creacion y gestor para el boton Division
       	Button btnDivision = (Button) findViewById(R.id.buttonDividir);
    	btnDivision.setOnClickListener(gestorOperaciones); 
    	
    	// OTROS BOTONES  // 
        //Creacion y gestor para el boton C
       	Button btnClear = (Button) findViewById(R.id.buttonClear);
    	btnClear.setOnClickListener(gestorbotonC);
    	//Creacion y gestor para el boton CambioSigno
    	Button btnCambioSigno = (Button) findViewById(R.id.ButtonCambioSigno);
    	btnCambioSigno.setOnClickListener(gestorCambioSigno);
    	
      
    	
        
   
        
     
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        
 
    	
    	getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
   
    
  
    
}
