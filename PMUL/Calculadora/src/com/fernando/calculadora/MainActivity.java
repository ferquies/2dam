package com.fernando.calculadora;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	String num1, num2, operacion, operacions, nums, num_ant, result, cadena;
	int resultado, cambio;
	boolean paso, punto;
	TextView display;
	int estado;
	
    private View.OnClickListener gestor = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(estado == 0) {
				estado = 1;
				display.setText("");
			} else if(estado == 2) {
				estado = 3;
				display.setText("");
			} else {	
				if(estado == 5) {
					estado = 1;
					num1 = "";
					num2 = "";
					display.setText("");
				}
			}
		
			if(estado == 1) {
				cadena = ((Button)v).getText().toString();
				num1 = num1 + Integer.parseInt(cadena);
				display.setText(display.getText() + cadena);	
			} else if(estado==3) {
				cadena = ((Button)v).getText().toString();
				num2 = num2 + Integer.parseInt(cadena);
				display.setText(display.getText() + cadena);
			}
		}
	};	
							
	private View.OnClickListener gestor_operacion = new View.OnClickListener() {
					
		@Override
		public void onClick(View v) {
			punto = false;
			
			if(estado == 1) {
				estado = 2;
				display.setText("");
			} else if(estado == 3) {
					estado = 4;
					display.setText("");
			}	
			
			if(estado == 4) {
				operacions = operacion;
				operacion = ((Button)v).getText().toString();
				if(operacion.equals("+")) {
					if(operacions.equals("+")) {
						resultado = Integer.parseInt(num1) + Integer.parseInt(num2);
						num1 = String.valueOf(resultado);
						resultado = 0;
					} else {
						if(operacions.equals("-")) {
							resultado = Integer.parseInt(num1) - Integer.parseInt(num2);
							num1 = String.valueOf(resultado);
							resultado = 0;
						} else {
							if((operacions.equals("*")) && (nums == "")) {
								resultado = Integer.parseInt(num1) * Integer.parseInt(num2);
								num1 = String.valueOf(resultado);
								resultado = 0;
							} else if((operacions.equals("*")) && (nums != "")) {
									if(num_ant.equals("+")) {
										resultado = Integer.parseInt(nums) + (Integer.parseInt(num1) * Integer.parseInt(num2));
										num1 = String.valueOf(resultado);
										resultado = 0;
										nums = "";
									} else {
										resultado = Integer.parseInt(nums) - (Integer.parseInt(num1) * Integer.parseInt(num2));
										num1 = String.valueOf(resultado);
										resultado = 0;
										nums = "";
									}
								} else {
									if(num2.equals("0"))
										display.setText("Error: Division by 0");
									else {
										if((operacions.equals("/")) && (nums == "")) {
											resultado = Integer.parseInt(num1) / Integer.parseInt(num2);
											num1 = String.valueOf(resultado);
											resultado = 0;
										} else {
											if(num_ant.equals("+")) {
												resultado = Integer.parseInt(nums) + (Integer.parseInt(num1) * Integer.parseInt(num2));
												num1 = String.valueOf(resultado);
												resultado = 0;
												nums = "";
											} else {
												resultado = Integer.parseInt(nums) - (Integer.parseInt(num1) * Integer.parseInt(num2));
												num1 = String.valueOf(resultado);
												resultado = 0;
												nums = "";
											}
										}
									}
								}
							}
						}
					display.setText(display.getText() + operacion);
				} if(operacion.equals("-")) {
					if(operacions.equals("+")) {
						resultado = Integer.parseInt(num1) + Integer.parseInt(num2);
						num1 = String.valueOf(resultado);
						resultado = 0;
					} else {
						if(operacions.equals("-")) {
							resultado = Integer.parseInt(num1) - Integer.parseInt(num2);
							num1 = String.valueOf(resultado);
							resultado = 0;
						} else {
							if((operacions.equals("*")) && (nums != "")) {
								if(num_ant.equals("+")) {
									resultado = Integer.parseInt(nums) + (Integer.parseInt(num1) * Integer.parseInt(num2));
									num1 = String.valueOf(resultado);
									resultado = 0;
									nums = "";
								} else {
									resultado = Integer.parseInt(nums) - (Integer.parseInt(num1) * Integer.parseInt(num2));
									num1 = String.valueOf(resultado);
									resultado = 0;
									nums = "";
								}
							} else {
								if((operacions.equals("/")) && (nums == "")) {
									resultado = Integer.parseInt(num1) / Integer.parseInt(num2);
									num1 = String.valueOf(resultado);
									resultado = 0;
								} else {
									if(num_ant.equals("+")) {
										resultado = Integer.parseInt(nums) + (Integer.parseInt(num1) * Integer.parseInt(num2));
										num1 = String.valueOf(resultado);
										resultado = 0;
										nums = "";
									} else {
										resultado = Integer.parseInt(nums) - (Integer.parseInt(num1) * Integer.parseInt(num2));
										num1 = String.valueOf(resultado);
										resultado = 0;
										nums = "";
									}
								}
							}
						}
					}
					display.setText(display.getText() + operacion);
				}
				if(operacion.equals("*")) {
					if(operacions.equals("+") || operacions.equals("-")) {	
						nums = num1;
						num1 = num2;
						num_ant = operacions;
					} else {
						if(operacions.equals("/")) {
							resultado = Integer.parseInt(num1) / Integer.parseInt(num2);
							num1 = String.valueOf(resultado);
							resultado = 0;
						} else {
							resultado = Integer.parseInt(num1) * Integer.parseInt(num2);
							num1 = String.valueOf(resultado);
							resultado = 0;
						}
					}
					display.setText(display.getText()+operacion);
				} if(operacion.equals("/")) {
					if(num2.equals("0"))
						display.setText("Error: Division by 0");
					else {
						if(operacions.equals("+") || operacions.equals("-")) {	
							nums = num1;
							num1 = num2;
							num_ant = operacions;
						} else {
							if(operacions.equals("*")) {
								resultado = Integer.parseInt(num1) * Integer.parseInt(num2);
								num1 = String.valueOf(resultado);
								resultado = 0;
							} else {
								resultado = Integer.parseInt(num1) / Integer.parseInt(num2);
								num1 = String.valueOf(resultado);
								resultado = 0;
							}
						}
						display.setText(display.getText()+operacion);
					}
				}
				num2 = "";					
				estado = 3;
			}
			
			if(estado == 2) {
				operacion=(String)((Button)v).getText();				
				display.setText(display.getText() + operacion);
			}
			
			if(estado == 5) {
				operacion = ((Button)v).getText().toString();				
				num1 = result;
				num2 = "";
				display.setText(operacion);
				estado = 2;
			}
		}
	};
    
	private View.OnClickListener gestor_igual = new View.OnClickListener() {
			
		@Override
		public void onClick(View v) {
			if(estado == 3)
				estado = 5;
			if(estado == 5) {
				if(operacion.equals("+")) {
					resultado = Integer.parseInt(num1) + Integer.parseInt(num2);
					result = String.valueOf(resultado);						
					display.setText(result);
				} if(operacion.equals("-")) {
					resultado = Integer.parseInt(num1) - Integer.parseInt(num2);
					result = String.valueOf(resultado);						
					display.setText(result);
				} if(operacion.equals("*")) {
						if(operacions.equals("") || operacions.equals("*") || operacions.equals("/"))
							resultado = Integer.parseInt(num1) * Integer.parseInt(num2);
						else {
							if(operacions.equals("+"))
								resultado = Integer.parseInt(nums) + (Integer.parseInt(num1) * Integer.parseInt(num2));
							if(operacions.equals("-"))
								resultado = Integer.parseInt(nums) - (Integer.parseInt(num1) * Integer.parseInt(num2));
						}	
						result = String.valueOf(resultado);						
						display.setText(result);
				}
				if(operacion.equals("/")) {
						if(num2.equals("0"))
							display.setText("Error: Division by 0");
						else {
							if(operacions.equals("") || operacions.equals("*") || operacions.equals("/"))
								resultado = Integer.parseInt(num1) / Integer.parseInt(num2);
							else {
								if(operacions.equals("+"))
									resultado = Integer.parseInt(nums) + (Integer.parseInt(num1) / Integer.parseInt(num2));
								if(operacions.equals("-"))
									resultado = Integer.parseInt(nums) - (Integer.parseInt(num1) / Integer.parseInt(num2));
							}
							result = String.valueOf(resultado);						
							display.setText(result);
						}
					}
				}
			}
		};
		
		private View.OnClickListener gestor_clear = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				estado = 0;
				num1 = "";
				num2 = "";
				operacion = "";
				operacions = "";
				nums = "";
				num_ant = "";
				display.setText("");
			}
		};
		
		private View.OnClickListener gestor_cambio = new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(estado == 1) {
					cambio = Integer.parseInt(num1.toString());
					cambio = cambio * -1;
					num1 = Integer.toString(cambio);
					display.setText(num1);
				} if(estado == 3) {
					cambio = Integer.parseInt(num2.toString());
					cambio = cambio * -1;
					num2 = Integer.toString(cambio);
					display.setText(num2);
				} if(estado == 5) {
					cambio = Integer.parseInt(result.toString());
					cambio = cambio * -1;
					result = Integer.toString(cambio);
					display.setText(result);
				}
			}
		};
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        findViewById(R.id.Button00).setOnClickListener(gestor);
	        findViewById(R.id.Button01).setOnClickListener(gestor);        
	        findViewById(R.id.Button02).setOnClickListener(gestor);        
	        findViewById(R.id.Button03).setOnClickListener(gestor);
	        findViewById(R.id.Button03).setOnClickListener(gestor);
	        findViewById(R.id.Button04).setOnClickListener(gestor);
	        findViewById(R.id.Button05).setOnClickListener(gestor);
	        findViewById(R.id.Button06).setOnClickListener(gestor);
	        findViewById(R.id.Button07).setOnClickListener(gestor);
	        findViewById(R.id.Button08).setOnClickListener(gestor);
	        findViewById(R.id.Button09).setOnClickListener(gestor);
	        findViewById(R.id.ButtonIgu).setOnClickListener(gestor_igual);
	        findViewById(R.id.ButtonCam).setOnClickListener(gestor_cambio);
	        findViewById(R.id.ButtonClear).setOnClickListener(gestor_clear);
	        findViewById(R.id.ButtonRes).setOnClickListener(gestor_operacion);
	        findViewById(R.id.ButtonSum).setOnClickListener(gestor_operacion);
	        findViewById(R.id.ButtonMul).setOnClickListener(gestor_operacion);
	        findViewById(R.id.ButtonDiv).setOnClickListener(gestor_operacion);
	        
	        display = (TextView) findViewById(R.id.display);
	    	operacion = "";
	        operacions = "";
	        num1 = "";
	        num2 = "";
	        nums = "";
	        num_ant = "";
	    	result = "";
	    	cadena = "";
	    	resultado = 0;
	    	cambio = 0;
	    	paso = false;
	    	punto = false;
	    	estado = 0;
	    }
}
