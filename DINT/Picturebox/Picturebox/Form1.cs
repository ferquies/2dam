using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Picturebox
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        bool pinta = false;
        string brocha;

        private void pictureBox1_MouseMove(object sender, MouseEventArgs e)
        {
            if (brocha == "pincel")
            {
                if (pinta)
                {
                    Graphics g = pictureBox1.CreateGraphics();
                    g.FillEllipse(new SolidBrush(Color.Azure), e.X, e.Y, 10, 10);
                    g.Dispose();
                }
            }
        }

        private void pictureBox1_MouseDown(object sender, MouseEventArgs e)
        {
            pinta = true;
        }

        private void pictureBox1_MouseUp(object sender, MouseEventArgs e)
        {
            pinta = false;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            brocha = "pincel";
        }
    }
}
