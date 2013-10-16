package com.example.calculadora;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends Activity {

	int estado=1;
	String operador1="";
	String operador2="";
	String operacion="";
	String nombreboton="";
	int resultado=0;
	
	 private View.OnClickListener gestorboton=new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
				
				TextView texto=(TextView) findViewById(R.id.editText1);

	
				if(estado==1)
				{//=R.id.boton1;
					
					nombreboton=(String)((Button)v).getText();
							
					operador1= operador1+Integer.parseInt(nombreboton);
					
				}
				
				if(estado==2)
				{
					nombreboton=(String)((Button)v).getText();
				
					operador2= operador2+Integer.parseInt(nombreboton);
													
				}
				
				texto.setText(texto.getText()+nombreboton);

			}
		};
		
			
		private View.OnClickListener gestorbotonOPERACIONES=new View.OnClickListener() {
					
				@Override
				public void onClick(View v) {
				// TODO Auto-generated method stub
							
					TextView texto=(TextView) findViewById(R.id.editText1);
					
					estado=2;
					
					operacion=(String)((Button)v).getText();
					
					texto.setText(texto.getText()+operacion);
				}
			};
				
			
			
					
			private View.OnClickListener gestorbotonC=new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				// TODO Auto-generated method stub
								
					TextView texto=(TextView) findViewById(R.id.editText1);
					operador1="";
					operador2="";
					operacion="";
					estado=1;
					
					texto.setText("");
				}
			};
			
		
		
			
			private View.OnClickListener gestorbotonIGUAL=new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
				// TODO Auto-generated method stub
								
					TextView texto=(TextView) findViewById(R.id.editText1);
					//String resultados=operador1+operacion+operador2;

					
					//	float resultadof=0;
						//int resultado=Integer.parseInt(resultados);
						//resultados=String.valueOf(resultado);
						
					
	
						if(operacion.equals("+")){resultado=Integer.parseInt(operador1) + Integer.parseInt(operador2);}
						if(operacion.equals("-")){resultado=Integer.parseInt(operador1) - Integer.parseInt(operador2);}
						if(operacion.equals("*")){resultado=Integer.parseInt(operador1) * Integer.parseInt(operador2);}
						if(operacion.equals("/")){resultado=Integer.parseInt(operador1) / Integer.parseInt(operador2);}
					
						String resultados=String.valueOf(resultado);						
					
					texto.setText(resultados);
					estado=1;
					

					//String texto2 = String.valueOf(texto.getText());
					
					
						if(resultado!=0){operador1=resultados;}
						else{resultados="";operador1="0";}
						
						
						
					//	if(Integer.parseInt(texto2)==0){operador1=0;}
					
					
				/*	if(operacion=="/")
					{
						resultadof=operador1 / operador2;
						if(resultadof!=0){operador1=Integer.parseInt(resultados);}
						else{resultados="";}
						
						if(Float.parseFloat(texto2)==0){operador1=0;}		
					}*/
					
					
					operador2="0";
					operacion="";
			
				}
			};	
			
			

			
			
			
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
  
         
        
        //Boton1
       	Button btn1 = (Button) findViewById(R.id.button1);
    	btn1.setOnClickListener(gestorboton);
    	
        //Boton2
       	Button btn2 = (Button) findViewById(R.id.button2);
    	btn2.setOnClickListener(gestorboton);   	
 
        //Boton3
       	Button btn3 = (Button) findViewById(R.id.button3);
    	btn3.setOnClickListener(gestorboton);
   
        //BotonMAS
       	Button btnMAS = (Button) findViewById(R.id.buttonMAS);
    	btnMAS.setOnClickListener(gestorbotonOPERACIONES);
    	
        //Boton4
       	Button btn4 = (Button) findViewById(R.id.button4);
    	btn4.setOnClickListener(gestorboton);
    	
        //Boton5
       	Button btn5 = (Button) findViewById(R.id.button5);
    	btn5.setOnClickListener(gestorboton);
    	
        //Boton6
       	Button btn6 = (Button) findViewById(R.id.button6);
    	btn6.setOnClickListener(gestorboton);
    	
        //BotonMENOS
       	Button btnMENOS = (Button) findViewById(R.id.buttonMENOS);
    	btnMENOS.setOnClickListener(gestorbotonOPERACIONES);   	
    	
        //Boton7
       	Button btn7 = (Button) findViewById(R.id.button7);
    	btn7.setOnClickListener(gestorboton);
  
        //Boton8
       	Button btn8 = (Button) findViewById(R.id.button8);
    	btn8.setOnClickListener(gestorboton);
   
        //Boton9
       	Button btn9 = (Button) findViewById(R.id.button9);
    	btn9.setOnClickListener(gestorboton);
  
        //BotonPOR
       	Button btnPOR = (Button) findViewById(R.id.buttonPOR);
    	btnPOR.setOnClickListener(gestorbotonOPERACIONES);
    	
        //BotonC
       	Button btnC = (Button) findViewById(R.id.buttonC);
    	btnC.setOnClickListener(gestorbotonC);
    	
        //Boton0
       	Button btn0 = (Button) findViewById(R.id.button0);
    	btn0.setOnClickListener(gestorboton);
    	
        //Boton0
       	Button btnIGUAL = (Button) findViewById(R.id.buttonIGUAL);
    	btnIGUAL.setOnClickListener(gestorbotonIGUAL);
   
        //BotonDIVISION
       	Button btnDIVISION = (Button) findViewById(R.id.buttonDIVISION);
    	btnDIVISION.setOnClickListener(gestorbotonOPERACIONES); 
    /*	
        //BotonPUNTO
       	Button btnPUNTO = (Button) findViewById(R.id.buttonPUNTO);
    	btnPUNTO.setOnClickListener(gestorbotonPUNTO);  */   
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        
 
    	
    	getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
   
    
  
    
}
