using System;

namespace Array1 {
	class MainClass {
		public static void Main (string[] args) {
			int n, NUM = 0;
            int[] array = new int[10];
			int[] aux = new int[NUM];
            string tecla = null;
            while (tecla != "s") {
                Console.Write("Entero (s para salir): ");
                tecla = Console.ReadLine();
                if (tecla != "s") {
					NUM++;
                    n = Convert.ToInt32(tecla);
					int salto = 0;
					array[NUM] = n;
					for(int i = 0; i < array.Length; i++) {
						if(n >= array[i]) {
							aux[i] = array[i];
						} else {
							if(salto == 0) {
								aux[i] = n;
								salto = 1;
								aux[i+1] = array[i];
							} else {
								aux[i+1] = array[i];
							}
						}
						array = aux;
					}
					for(int i = 0; i < array.Length; i++) {
						if(i == array.Length-1) {
							Console.WriteLine("->" + array[i]);
						} else {
							Console.Write("->" + array[i]);
						}
					}
				}
            }
		}
	}
}
