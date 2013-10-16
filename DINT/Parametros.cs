using System;

namespace Application
{
	public class Parametros
	{
		public static void Main (string[] args)
		{
			int n = args.Length();
			for(int i = 0; i < n; i++) {
				Console.WriteLine(args[i]);
				Console.ReadLine();
			}
		}
	}
}

