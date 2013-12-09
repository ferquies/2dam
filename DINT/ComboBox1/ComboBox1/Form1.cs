using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace ComboBox1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            panel1.Location = new Point(174, 38);
            panel2.Location = new Point(174, 38);
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if(comboBox1.SelectedItem.Equals("PERSONA"))
            {                
                panel1.Visible = true;
                panel2.Visible = false;
            }
            else if (comboBox1.SelectedItem.Equals("EMPRESA"))
            {
                panel2.Visible = true;
                panel1.Visible = false;
            }
        }
    }
}
