using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace LoboConejo
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private bool up = false;
        private bool down = false;
        private bool left = false;
        private bool right = false;

        private void timer1_Tick(object sender, EventArgs e)
        {
            int xlobo = labelLobo.Location.X;
            int ylobo = labelLobo.Location.Y;
            int wlobo = labelLobo.Width;
            int hlobo = labelLobo.Height;
            int xconejo = labelConejo.Location.X;
            int yconejo = labelConejo.Location.Y;
            int wconejo = labelConejo.Width;
            int hconejo = labelConejo.Height;

            if (labelLobo.Location.X < labelConejo.Location.X) { xlobo++; }
            if (labelLobo.Location.X > labelConejo.Location.X) { xlobo--; }
            if (labelLobo.Location.Y < labelConejo.Location.Y) { ylobo++; }
            if (labelLobo.Location.Y > labelConejo.Location.Y) { ylobo--; }

            if (up) { yconejo -= 2; }
            if (down) { yconejo += 2; }
            if (left) { xconejo -= 2; }
            if (right) { xconejo += 2; }

            if (xlobo <= xconejo + wconejo && xlobo + wlobo > xconejo && ylobo < yconejo + hconejo && ylobo + hlobo > yconejo) { timer1.Stop(); MessageBox.Show("Perdiste"); }

            labelLobo.Location = new Point(xlobo, ylobo);
            labelConejo.Location = new Point(xconejo, yconejo);
        }

        private void Form1_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Up) { up = true; }
            if (e.KeyCode == Keys.Down) { down = true; }
            if (e.KeyCode == Keys.Left) { left = true; }
            if (e.KeyCode == Keys.Right) { right = true; }
        }

        private void Form1_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Up) { up = false; }
            if (e.KeyCode == Keys.Down) { down = false; }
            if (e.KeyCode == Keys.Left) { left = false; }
            if (e.KeyCode == Keys.Right) { right = false; }
        }
    }
}
