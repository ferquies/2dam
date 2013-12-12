using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Prueba4_Examen
{
    public class Vector
    {
        private int[] datos;

        public Vector(int longitud)
        {
            this.datos = new int[longitud];
        }

        public int this[int num]
        {
            get
            {
                return datos[num];
            }
            set
            {
                datos[num] = value;
            }
        }

        public void eliminarRepetidos()
        {
            int[] aux = new int[datos.Length];
            int[] sin_repetir = new int[datos.Length];
            int[] repetidos = new int[500000];
            for(int i = 0; i < repetidos.Length; i++)
            {
                repetidos[i] = 0;
            }

            for (int i = 0; i < datos.Length; i++)
            {
                repetidos[datos[i]]++;
                aux[i] = datos[i];
                if (repetidos[datos[i]] < 2)
                {
                    sin_repetir[i] = datos[i];
                }
            }

            this.datos = sin_repetir;
        }

        public void mostrar()
        {
            for(int i = 0; i < datos.Length; i++)
            {
                Console.Write(datos[i] + " ");
            }
            Console.WriteLine();
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Vector v = new Vector(4);
            v[0] = 1;
            v[1] = 23;
            v[2] = 1;
            v[3] = 48;

            v.mostrar();
            v.eliminarRepetidos();
            v.mostrar();
            Console.ReadLine();
        }
    }
}
