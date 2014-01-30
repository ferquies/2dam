using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Dividir
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                int a = Convert.ToInt32(textBoxDividendo.Text);
                int b = Convert.ToInt32(textBoxDivisor.Text);
                int resul = a / b;
                textBoxResultado.Text = resul.ToString();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                throw new MyException("Fallaco!");
            }
            finally
            {
                MessageBox.Show("Estoy en la seccion finally!");
            }
        }
    }

    class MyException : Exception
    {
        public MyException() { }
        public MyException(string s) : base(s) { }
        public MyException(string s, Exception i) : base(s, i) { }
    }
}
