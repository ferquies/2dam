using System;

namespace Parametros
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			for(int i = 0; i < args.Length; i++) {
				Console.WriteLine(args[i]);
				Console.ReadLine();
			}
		}
	}
}
