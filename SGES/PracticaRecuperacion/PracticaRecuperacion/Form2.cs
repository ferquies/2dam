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
    public partial class Form2 : Form
    {
        Ticket ticket = new Ticket();
        OleDbConnection conn = null;
        OleDbCommand cmd;
        OleDbCommand cmd_update;

        public Form2()
        {
            InitializeComponent();
            if(this.Tag != null)
                labelMesa.Text = "Mesa " + this.Tag.ToString();

            string connection = @"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=|DataDirectory|\products.mdb";
            conn = new OleDbConnection(connection);
            try
            {
                conn.Open();
            }
            catch
            {
                MessageBox.Show("Se ha producido un error al conectar con la base de datos.",
                    "TPV", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void buttonProduct_Click(object sender, EventArgs e)
        {
            if (ticket.Opened)
            {
                if (ticket != null)
                {
                    Button button = (Button)sender;
                    int tag;
                    if (button.Tag != null)
                        tag = int.Parse(button.Tag.ToString());
                    else
                        tag = -1;
                    cmd = new OleDbCommand();
                    cmd.Connection = conn;
                    cmd.CommandText = "Select * from Products where Id = " + tag.ToString();
                    OleDbDataReader dataReader = cmd.ExecuteReader();
                    if (dataReader.HasRows)
                    {
                        dataReader.Read();
                        if (int.Parse(dataReader["units"].ToString()) > 0)
                        {
                            dataGridView1.Rows.Add(dataReader["name"], dataReader["prize"]);
                            ticket.Add(new Product(dataReader["name"].ToString(),
                                dataReader["description"].ToString(),
                                Image.FromFile(dataReader["photo"].ToString()),
                                Image.FromFile(dataReader["tpv_image"].ToString()),
                                double.Parse(dataReader["prize"].ToString()),
                                int.Parse(dataReader["iva"].ToString()),
                                int.Parse(dataReader["units"].ToString())));
                            cmd_update = new OleDbCommand();
                            cmd_update.Connection = conn;
                            cmd_update.CommandText = "Update Products Set Units = " + (int.Parse(dataReader["units"].ToString()) - 1) + " Where Id = " + tag.ToString();
                            cmd_update.ExecuteNonQuery();
                        }
                        else
                        {
                            MessageBox.Show("No quedan unidades de este producto",
                                "TPV", MessageBoxButtons.OK,
                                MessageBoxIcon.Exclamation);
                        }
                    }
                }
            }
        }

        private void btnCerrarPedido_Click(object sender, EventArgs e)
        {
            if (ticket != null)
            {
                btnCerrarPedido.Enabled = false;
                labelTotal.Text = ticket.BillTax().ToString();
                ticket.Opened = false;
                conn.Close();
                Form1.cash.Charge(ticket);
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
/*Hola*/