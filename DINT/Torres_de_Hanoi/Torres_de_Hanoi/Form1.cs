using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Torres_de_Hanoi
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        int movimientos = 0;

        private void button5_Click(object sender, EventArgs e)
        {
            listBox1.Items.Clear();
            listBox2.Items.Clear();
            listBox3.Items.Clear();
            movimientos = 0;
            textBox2.Text = "";
            int num = Convert.ToInt16(textBox1.Text);
            int aux = 1;

            for (int i = 0; i < num; i++)
            {
                string pieza = "";
                for (int j = 0; j < aux; j++)
                {
                    pieza = pieza + "*";
                }
                aux++;
                listBox1.Items.Add(pieza);
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (listBox1.Items.Count != 0 && (listBox2.Items.Count == 0 || listBox2.Items[0].ToString().Length > listBox1.Items[0].ToString().Length))
            {
                listBox2.Items.Insert(0, listBox1.Items[0]);
                listBox1.Items.Remove(listBox1.Items[0]);
                movimientos++;
                textBox2.Text = movimientos.ToString();
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (listBox2.Items.Count != 0 && (listBox3.Items.Count == 0 || listBox3.Items[0].ToString().Length > listBox2.Items[0].ToString().Length))
            {
                listBox3.Items.Insert(0, listBox2.Items[0]);
                listBox2.Items.Remove(listBox2.Items[0]);
                movimientos++;
                textBox2.Text = movimientos.ToString();
            }
            if (listBox3.Items.Count == Convert.ToInt16(textBox1.Text))
            {
                MessageBox.Show("Has ganado!");
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            if (listBox3.Items.Count != 0 && (listBox2.Items.Count == 0 || listBox2.Items[0].ToString().Length > listBox3.Items[0].ToString().Length))
            {
                listBox2.Items.Insert(0, listBox3.Items[0]);
                listBox3.Items.Remove(listBox3.Items[0]);
                movimientos++;
                textBox2.Text = movimientos.ToString();
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (listBox2.Items.Count != 0 && (listBox1.Items.Count == 0 || listBox1.Items[0].ToString().Length > listBox2.Items[0].ToString().Length))
            {
                listBox1.Items.Insert(0, listBox2.Items[0]);
                listBox2.Items.Remove(listBox2.Items[0]);
                movimientos++;
                textBox2.Text = movimientos.ToString();
            }
        }

        private void button7_Click(object sender, EventArgs e)
        {
            if (listBox1.Items.Count != 0 && (listBox3.Items.Count == 0 || listBox3.Items[0].ToString().Length > listBox1.Items[0].ToString().Length))
            {
                listBox3.Items.Insert(0, listBox1.Items[0]);
                listBox1.Items.Remove(listBox1.Items[0]);
                movimientos++;
                textBox2.Text = movimientos.ToString();
            }
            if (listBox3.Items.Count == Convert.ToInt16(textBox1.Text))
            {
                MessageBox.Show("Has ganado!");
            }
        }

        private void button6_Click(object sender, EventArgs e)
        {
            if (listBox3.Items.Count != 0 && (listBox1.Items.Count == 0 || listBox1.Items[0].ToString().Length > listBox3.Items[0].ToString().Length))
            {
                listBox1.Items.Insert(0, listBox3.Items[0]);
                listBox3.Items.Remove(listBox3.Items[0]);
                movimientos++;
                textBox2.Text = movimientos.ToString();
            }
        }
    }
}
