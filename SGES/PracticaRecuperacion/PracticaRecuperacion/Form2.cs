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
    public partial class Form2 : Form
    {
        Ticket ticket = new Ticket();
        Product cocacola = new Product("Coca-cola", "Refresco de cola", Image.FromFile(@"C:\Documents and Settings\Fer\mis documentos\visual studio 2010\Projects\PracticaRecuperacion\PracticaRecuperacion\images\cocacola.gif"), Image.FromFile(@"C:\Documents and Settings\Fer\mis documentos\visual studio 2010\Projects\PracticaRecuperacion\PracticaRecuperacion\images\cocacola.gif"), 1.5, 21, 10);
        public Form2()
        {
            InitializeComponent();
            if(this.Tag != null)
                labelMesa.Text = "Mesa " + this.Tag.ToString();
        }

        private void buttonProduct_Click(object sender, EventArgs e)
        {
            if (ticket.Opened)
            {
                if (ticket != null)
                    ticket.Add(cocacola);
                ListViewItem lvi = new ListViewItem();
                /*lvi.SubItems.Add(cocacola.Name);
                lvi.SubItems.Add(cocacola.Prize.ToString());*/
                lvi.Text = cocacola.Name;
                listBox1.Items.Add(lvi);
            }
        }

        private void btnCerrarPedido_Click(object sender, EventArgs e)
        {
            if (ticket != null)
            {
                btnCerrarPedido.Enabled = false;
                labelTotal.Text = ticket.BillTax().ToString();
                ticket.Opened = false;
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Hide();
        }

        private void Form2_FormClosing(object sender, FormClosingEventArgs e)
        {
            Form form = (Form)sender;
            DialogResult result = MessageBox.Show("Se va a cerrar el ticket.\n¿Cerrar?", "TPV", MessageBoxButtons.YesNo, MessageBoxIcon.Warning);
            if (result != DialogResult.Yes)
                e.Cancel = true;
        }
    }
}
