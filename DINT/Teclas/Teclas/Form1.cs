using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Teclas
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_KeyDown(object sender, KeyEventArgs e)
        {
            label1.Text = "ALT: " + e.Alt + "\n";
            label1.Text += "CTRL: " + e.Control + "\n";
            label1.Text += "Shift: " + e.Shift + "\n";
            label1.Text += "KeyCode: " + e.KeyCode + "\n";
            label1.Text += "KeyData: " + e.KeyData + "\n";
            label1.Text += "KeyValue: " + e.KeyValue;
        }
    }
}
