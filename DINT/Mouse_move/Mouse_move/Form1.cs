using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Mouse_move
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        int aux = 0;
        bool pinta = false;

        private void Form1_MouseMove(object sender, MouseEventArgs e)
        {
            label1.Text = "El ratón esta en X: " + e.X + " Y: " + e.Y;
            if (pinta)
            {
                Graphics g = this.CreateGraphics();
                g.FillEllipse(new SolidBrush(Color.Red), e.X, e.Y, 170, 170);
                g.Dispose();
            }
        }

        private void Form1_MouseDown(object sender, MouseEventArgs e)
        {
            label2.Text = "El ratón se ha pulsado";
            pinta = true;
        }

        private void Form1_MouseUp(object sender, MouseEventArgs e)
        {
            label2.Text = "El ratón se ha soltado";
            pinta = false;
        }

        private void Form1_MouseClick(object sender, MouseEventArgs e)
        {
            aux++;
            label3.Text = "Clicks: " + aux;
        }
    }
}
