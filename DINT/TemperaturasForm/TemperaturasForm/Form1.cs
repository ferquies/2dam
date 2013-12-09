using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace TemperaturasForm
{
    public partial class Form1 : Form
    {
        temp tp = new temp();
        public Form1()
        {
            InitializeComponent();
        }

        

        private void button1_Click(object sender, EventArgs e)
        {
            if (panel1Celsius.Checked == true)
            {
                if (panel2Celsius.Checked == true)
                {
                    tp.C = Convert.ToInt16(textBox1.Text);
                    textBox2.Text = Convert.ToString(tp.C);
                }
                else if (panel2Kelvin.Checked == true)
                {
                    tp.C = Convert.ToInt16(textBox1.Text);
                    textBox2.Text = Convert.ToString(tp.K);
                }

                else if (panel2Fh.Checked == true)
                {
                    tp.C = Convert.ToInt16(textBox1.Text);
                    textBox2.Text = Convert.ToString(tp.F);
                }

            }
            else if (panel1Kelvin.Checked == true)
            {
                if (panel2Celsius.Checked == true)
                {
                    tp.K = Convert.ToInt16(textBox1.Text);
                    textBox2.Text = Convert.ToString(tp.C);
                }
                else if (panel2Kelvin.Checked == true)
                {
                    tp.K = Convert.ToInt16(textBox1.Text);
                    textBox2.Text = Convert.ToString(tp.K);
                }

                else if (panel2Fh.Checked == true)
                {
                    tp.K = Convert.ToInt16(textBox1.Text);
                    textBox2.Text = Convert.ToString(tp.F);
                }

            }
            else if (panel1Fh.Checked == true)
            {
                if (panel2Celsius.Checked == true)
                {
                    tp.F = Convert.ToInt16(textBox1.Text);
                    textBox2.Text = Convert.ToString(tp.C);
                }
                else if (panel2Kelvin.Checked == true)
                {
                    tp.F = Convert.ToInt16(textBox1.Text);
                    textBox2.Text = Convert.ToString(tp.K);
                }

                else if (panel2Fh.Checked == true)
                {
                    tp.F = Convert.ToInt16(textBox1.Text);
                    textBox2.Text = Convert.ToString(tp.F);
                }

            }
        }
    }
    class temp
    {
        protected double grados;//Se trabajara con Kelvin

        public double K
        {
            set
            {
                grados = value;
            }
            get
            {
                return grados;
            }
        }
        public double C
        {
            set
            {
                grados = value + 273.15;
            }
            get
            {
                return grados - 273.15;
            }
        }
        public double F
        {
            set
            {
                this.C = (value - 32) / 1.8;
            }
            get
            {
                return (this.C * 1.8) + 32;
            }

        }
    }
}
