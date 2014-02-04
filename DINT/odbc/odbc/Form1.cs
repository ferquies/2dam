using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
//using System.Data.Odbc;
using System.Data.OleDb;

namespace odbc
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        //OdbcConnection connect = new OdbcConnection("DSN=pruebas");
        OleDbConnection connect = new OleDbConnection("Provider=Microsoft.ACE.OLEDB.12.0;Data Source=C:/Users/Fernando/Documents/GitHub/2dam/DINT/prueba.accdb");

        private void button1_Click(object sender, EventArgs e)
        {
            if (connect.State == ConnectionState.Open)
            {
                connect.Close();
                button1.Text = "Conectar";
            }
            else
            {
                connect.Open();
                button1.Text = "Desconectar";
            }
        }
    }
}
