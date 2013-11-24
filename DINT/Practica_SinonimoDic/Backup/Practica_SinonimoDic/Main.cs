using System;
using System.Collections;

namespace Practica_SinonimoDic
{
	class SinonimoDic
	{
	    class Palabra
	    {
		protected string clave;
		protected ArrayList sinonimos = new ArrayList();
		    protected int indice;
		
		public Palabra(String clave)
		{
		    this.clave = clave;
			    this.indice = 0;
		}
		
		public void insertSin(string sin)
		{
		    sinonimos.Add(sin);
		}
		
		public string getClave()
		{
		    return this.clave;
		}
		
		public object getSin()
		{
		    if(indice < sinonimos.Count - 1)
		    {
			indice++;
		    }
			    else if(indice == sinonimos.Count -1)
			    {
				    indice = 0;
			    }
		    return sinonimos[indice];
		}
	    }
    	
    	private Palabra[] arraypalabra = new Palabra[5];
    	
    	public string this [string pal]
    	{
    	    get
    	    {
    	        for(int i = 0; i < arraypalabra.Length; i++)
    	        {
    	            if(!arraypalabra[i].Equals(null))
					{
						if(pal.Equals(arraypalabra[i].getClave()))
	    	            {
	    	                if(arraypalabra[i].getSin() != null)
	    	                {
	    	                    return (string) arraypalabra[i].getSin();
	    	                }
	    	                else
	    	                {
	    	                    Console.WriteLine("No existe sinonimo para esta palabra.");
	    	                }
	    	            }
	    	            else
	    	            {
	    	                Console.WriteLine("No existe la palabra.");
	    	                Palabra p = new Palabra(pal);
	    	                arraypalabra[i] = p;
	    	            }
					}
    	        }
				return null;
    	    }
    	    
    	    set
    	    {
    	        for(int i = 0; i < arraypalabra.Length; i++)
    	        {
    	            if(pal.Equals(arraypalabra[i].getClave()))
    	            {
    	                if(arraypalabra[i].getSin() != null)
    	                {
    	                    Console.WriteLine(arraypalabra[i].getSin());
    	                }
    	                else
    	                {
    	                    Console.WriteLine("No existe sinonimo para esta palabra.");
    	                    arraypalabra[i].insertSin(value);
    	                }
    	            }
    	            else
    	            {
    	                Console.WriteLine("No existe la palabra.");
    	                Palabra p = new Palabra(pal);
    	                arraypalabra[i] = p;
    	            }
    	        }
    	    }
    	}
    }
	
	class MainClass
	{
		public static void Main (string[] args)
		{
			SinonimoDic sd = new SinonimoDic();
			sd["moto"] = "ciclomotor";
			Console.WriteLine(sd["moto"]);
		}
	}
}