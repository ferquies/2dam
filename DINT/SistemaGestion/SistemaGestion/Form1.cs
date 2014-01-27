using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SistemaGestion
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private List<int> lista_unidades = new List<int>();
        private List<int> lista_precios = new List<int>();

        private void button1_Click(object sender, EventArgs e)
        {
            if(TextBoxPrecio.Text != null && TextBoxUnidad.Text != null)
            {
                lista_precios.Add(Convert.ToInt32(TextBoxPrecio.Text.Trim()));
                lista_unidades.Add(Convert.ToInt32(TextBoxUnidad.Text.Trim()));
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {

        }
    }
}
