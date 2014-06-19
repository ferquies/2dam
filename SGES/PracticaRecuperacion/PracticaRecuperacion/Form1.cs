using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.OleDb;

namespace PracticaRecuperacion
{
    public partial class Form1 : Form
    {
        public static Cash cash;
        List<Form> form_ticket = new List<Form>();
        List<Product> stock = new List<Product>();
        OleDbConnection conn;
        OleDbCommand cmd;

        public Form1()
        {
            InitializeComponent();

            cash = new Cash(200);
            string connection = @"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=|DataDirectory|\products.mdb";
            string query = "Select * from products";
            conn = new OleDbConnection(connection);
            cmd = new OleDbCommand(query, conn);
            try
            {
                conn.Open();
                cmd.CommandType = CommandType.Text;
                OleDbDataAdapter odda = new OleDbDataAdapter(cmd);
                DataTable stock = new DataTable();
                odda.Fill(stock);
                dataGridView1.DataSource = stock;
                conn.Close();
            }
            catch
            {
                MessageBox.Show("Se ha producido un error al conectar con la base de datos.",
                    "TPV", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
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
            for (int i = 0; i < 13; i++)
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
                int tag;
                if (label.Tag.ToString() != "Barra")
                    tag = int.Parse(label.Tag.ToString());
                else
                    tag = 12;
                try
                {
                    form_ticket[tag].Show();
                }
                catch
                {
                    form_ticket[tag] = new Form2();
                    if(tag != 12)
                        form_ticket[tag].Text = "Mesa " + (tag + 1);
                    else
                        form_ticket[tag].Text = "Barra";
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

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            conn.Close();
            if (cash.Amount > cash.Default_Amount)
                MessageBox.Show("Hay que sacar " + (cash.Amount - cash.Default_Amount) + "€");
        }

        private void button2_Click(object sender, EventArgs e)
        {
            OleDbCommand cmd_insert = new OleDbCommand();
            cmd_insert.Connection = conn;
            conn.Open();
            MessageBox.Show("Insert Into Products(Name, Description, Photo, TPV_Image, Prize, IVA, Units) Values('" + textBoxName.Text + "', '" + textBoxDesc.Text + "', '" + textBoxPhoto.Text + "', '" + textBoxImage.Text + "', " + Convert.ToDouble(textBoxPrize.Text) + ", " + int.Parse(textBoxIVA.Text) + ", " + int.Parse(textBoxUnits.Text) + ")");
            cmd_insert.CommandText = "Insert Into Products(Name, Description, Photo, TPV_Image, Prize, IVA, Units) Values('" + textBoxName.Text + "', '" + textBoxDesc.Text + "', '" + textBoxPhoto.Text + "', '" + textBoxImage.Text + "', " + double.Parse(textBoxPrize.Text) + ", " + int.Parse(textBoxIVA.Text) + ", " + int.Parse(textBoxUnits.Text) + ")";
            cmd_insert.ExecuteNonQuery();
            conn.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string connection = @"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=|DataDirectory|\products.mdb";
            string query = "Select * from products";
            conn = new OleDbConnection(connection);
            cmd = new OleDbCommand(query, conn);
            try
            {
                conn.Open();
                cmd.CommandType = CommandType.Text;
                OleDbDataAdapter odda = new OleDbDataAdapter(cmd);
                DataTable stock = new DataTable();
                odda.Fill(stock);
                dataGridView1.DataSource = stock;
                conn.Close();
            }
            catch
            {
                MessageBox.Show("Se ha producido un error al conectar con la base de datos.",
                    "TPV", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
    }
}
