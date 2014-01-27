using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;

namespace LoboConejo
{
    public partial class Form1 : Form
    {
        private Label[] zanahorias;
        private int longitud = 0, num_zanahorias = 0;

        public Form1()
        {
            InitializeComponent();

            StreamReader sr = new StreamReader(@"zanahorias.txt");
            String str_read = ""; int x = 0, y = 0;

            for(int i = 0; !sr.EndOfStream; i++) { str_read = str_read + (char)sr.Read(); }

            String[] str = str_read.Split(' ');
            longitud = str.Length;
            num_zanahorias = longitud / 2;

            int[] z_x = new int[longitud]; int[] z_y = new int[longitud];

            for (int i = 0; i < longitud; i++)
            {
                if ((i % 2) != 0) { z_y[y] = Convert.ToInt32(str[i]); y++; }
                else { z_x[x] = Convert.ToInt32(str[i]); x++; }
            }

            zanahorias = new Label[longitud];

            for (int i = 0; i < longitud/2; i++)
            {
                zanahorias[i] = new Label();
                zanahorias[i].AutoSize = true;
                zanahorias[i].Location = new System.Drawing.Point(z_x[i], z_y[i]);
                zanahorias[i].Name = "zanahoria" + i;
                zanahorias[i].Size = new System.Drawing.Size(31, 13);
                zanahorias[i].TabIndex = 0;
                zanahorias[i].Text = "Z";
                this.Controls.Add(zanahorias[i]);
            }
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

            if (xlobo <= xconejo + wconejo && xlobo + wlobo > xconejo && ylobo < yconejo + hconejo && ylobo + hlobo > yconejo)
            {
                timer1.Stop();
                if (MessageBox.Show("¡Has perdido!", "LoboConejo", MessageBoxButtons.RetryCancel) == System.Windows.Forms.DialogResult.Retry)
                {
                    xlobo = 67;
                    ylobo = 55;
                    xconejo = 237;
                    yconejo = 197;
                    up = down = left = right = false;
                    num_zanahorias = longitud / 2;
                    for (int i = 0; i < num_zanahorias; i++) { zanahorias[i].Visible = true; }
                    timer1.Start();
                }
            }

            for (int i = 0; i < longitud/2; i++)
            {
                if (zanahorias[i].Location.X <= xconejo + wconejo && zanahorias[i].Location.X + zanahorias[i].Width > xconejo && zanahorias[i].Location.Y < yconejo + hconejo && zanahorias[i].Location.Y + zanahorias[i].Height > yconejo)
                {
                    if (zanahorias[i].Visible)
                    {
                        zanahorias[i].Visible = false;
                        num_zanahorias--;
                    }
                }
            }

            if (num_zanahorias == 0)
            {
                timer1.Stop();
                if (MessageBox.Show("¡Has ganado!\n¿Volver a jugar?", "LoboConejo", MessageBoxButtons.YesNo) == System.Windows.Forms.DialogResult.Yes)
                {
                    xlobo = 67;
                    ylobo = 55;
                    xconejo = 237;
                    yconejo = 197;
                    up = down = left = right = false;
                    num_zanahorias = longitud / 2;
                    for (int i = 0; i < num_zanahorias; i++) { zanahorias[i].Visible = true; }
                    timer1.Start();
                }
            }

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
