using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace LeerFichero
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            StreamReader sr = new StreamReader(@"C:\borrame\hola.txt");

            while(!sr.EndOfStream)
            {
                textBox1.AppendText("" + (char) sr.Read());
            }

            sr.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            StreamWriter sw = new StreamWriter(@"C:\borrame\hola.txt");
            for (int i = 0; i < textBox1.Lines.Length; i++)
            {
                sw.WriteLine(textBox1.Lines[i]);
            }
            sw.Close();
        }
    }
}
