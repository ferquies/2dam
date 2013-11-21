using System;

namespace practica1
{	
	class SinonimoDic{
		//## COMIENZO CLASE PALABRA ##\\
		//CLASE PALABRA,esta clase controlará la palabra y los sinonimos que contiene
		class Palabra
		{			
			protected string pclave;
			protected int pos_sin_devuelto; //Con esta variable controlo la posicion del sinonimo a devolver
			protected int num_sinonimos = 0;//Con esta variable controlaré la posicion de los sinonimos			
			protected string[] sinonimos = new string[5];
			//CONSTRUCTOR, este constructor recibe la palabra y le da valor a la palabra clave de la clase 
			public Palabra(string pcla){
				this.pclave = pcla;
			}
			//METODO,este metodo nos devolverá la palabra clave
			public string getPalabra(){
				return this.pclave;
			}
			//METODO,este metodo recibirá el sinonimo y lo insertará en el array
			public void inserSinonimo(string s)
			{
				//Inserto en el array el sinonimo recibido  en la posicion determinada por el valor de num_sinonimos
				sinonimos[num_sinonimos] = s;
				//Despues de insertarlo el numero de sinonimos se incrementa en 1
				num_sinonimos+=1;
			}
			//METODO,este método se encargara de devolver el sinonimo según el valor de la variable pos_sin_devuelto
			
			public string getSinonimo()
			{
				//En esta condicion miro si la posicion a devolver tiene el mismo valor que el numero de sinonimos -1
				if(pos_sin_devuelto == num_sinonimos - 1)
				{
					//Al cumplirse la condicion indico que el valor de la posicion será 0 y 
					//por tanto devolverá el primer sinonimo
					pos_sin_devuelto = 0;
				}
				//Si no se cumple la condicion anterior la posicion a devolver será esa posicion mas 1
				else{
					pos_sin_devuelto += 1;
										
				}
				//Retorna el sinonimo que este en la posición indicada
				return sinonimos[pos_sin_devuelto];
			}
		}//## FINALIZADA  CLASE PALABRA ##\\
		protected Palabra[] arr_palabras = new Palabra[5];
		protected int num_palabra;
		protected int num_sin;
		protected int pos_palabra;
		protected string sino;
		protected bool buscar = false;
		public string this[String pal]
		{		
			get{
				if(num_palabra == 0)
				{
					Palabra pa = new Palabra(pal);
					arr_palabras[num_palabra] = pal;
					num_palabra += 1;
					
					return "No existe la palabra";
				}
				else{
						for(int k = 0; k < num_palabra; k++)
						{
							if(pal.Equals(arr_palabras[k].getPalabra()))
							{
								pos_palabra = k;
								buscar = true;
								
							}
							else
							{
								buscar = false;
							}
						}
						if(buscar == true)
						{
							if(num_sin <= 0)
							{
								return "No existe un sínonimo para la palabra";
							}
							else{
								sino = arr_palabras[pos_palabra].getSinonimo();
								return sino;
							}
						}		
					}
				
				return 0;
				
			}
			set{
				
				
			}			
		}
	}//## COMIENZO CLASE SINONIMODIC ##\\
	
	class MainClass
	{
		public static void Main (string[] args)
		{
			SinonimoDic sin = new SinonimoDic();
				
		}
	}
}
