using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Messagebox
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            DialogResult r = DialogResult.No;
            while (r != DialogResult.OK)
            {
                r = MessageBox.Show("Probando", "Prueba", MessageBoxButtons.OKCancel, MessageBoxIcon.Information);
            }
        }
    }
}
