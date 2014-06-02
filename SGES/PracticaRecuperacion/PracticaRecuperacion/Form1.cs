using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace PracticaRecuperacion
{
    public partial class Form1 : Form
    {
        Cash cash;
        List<Form> form_ticket = new List<Form>();
        List<Product> stock = new List<Product>();

        public Form1()
        {
            InitializeComponent();
            cash = new Cash(200);
            stock.Add(new Product("Coca-cola", "Refresco de cola", Image.FromFile(@"C:\Documents and Settings\Fer\mis documentos\visual studio 2010\Projects\PracticaRecuperacion\PracticaRecuperacion\images\cocacola.gif"), Image.FromFile(@"C:\Documents and Settings\Fer\mis documentos\visual studio 2010\Projects\PracticaRecuperacion\PracticaRecuperacion\images\cocacola.gif"), 1.25, 21, 40));
            stock.Add(new Product("Coca-cola Light", "Refresco de cola light", Image.FromFile(@"C:\Documents and Settings\Fer\mis documentos\visual studio 2010\Projects\PracticaRecuperacion\PracticaRecuperacion\images\cocacola.gif"), Image.FromFile(@"C:\Documents and Settings\Fer\mis documentos\visual studio 2010\Projects\PracticaRecuperacion\PracticaRecuperacion\images\cocacola.gif"), 1.5, 21, 20));
            DialogResult open = MessageBox.Show("¿Abrir caja ahora?",
                "TPV", MessageBoxButtons.YesNo);
            if (open == DialogResult.Yes)
            {
                if (!cash.Open())
                {
                    MessageBox.Show("Error al abrir la caja",
                        "TPV", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
                else
                {
                    btnOpenCash.Enabled = false;
                }
            }
            else
            {
                btnCloseCash.Enabled = false;
            }
            for (int i = 0; i < 12; i++)
            {
                form_ticket.Add(new Form2());
                form_ticket[i].Text = "Mesa " + (i + 1);
                form_ticket[i].Tag = (i + 1).ToString();
            }
        }

        private void label_Click(object sender, EventArgs e)
        {
            if (cash.Status)
            {
                Label label = (Label)sender;
                int tag = int.Parse(label.Tag.ToString());
                try
                {
                    form_ticket[tag].Show();
                }
                catch
                {
                    form_ticket[tag] = new Form2();
                    form_ticket[tag].Text = "Mesa " + (tag + 1);
                    form_ticket[tag].Show();
                }
            }
            else
            {
                DialogResult result = MessageBox.Show("La caja esta cerrada.\n¿Desea abrirla?",
                    "TPV", MessageBoxButtons.YesNo, MessageBoxIcon.Hand);
                if (result == DialogResult.Yes)
                {
                    cash.Open();
                    btnOpenCash.Enabled = false;
                    btnCloseCash.Enabled = true;
                }
            }
        }

        private void btnOpenCash_Click(object sender, EventArgs e)
        {
            if (!cash.Open())
            {
                MessageBox.Show("Error al abrir la caja",
                    "TPV", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                btnOpenCash.Enabled = false;
                btnCloseCash.Enabled = true;
            }
        }

        private void btnCloseCash_Click(object sender, EventArgs e)
        {
            if (!cash.Close())
            {
                MessageBox.Show("Error al cerrar la caja",
                    "TPV", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                btnOpenCash.Enabled = true;
                btnCloseCash.Enabled = false;
            }
        }
    }
}
