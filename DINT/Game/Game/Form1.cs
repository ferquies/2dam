using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Game
{
    public partial class Form1 : Form
    {
        Bitmap fondo, personaje;
        bool der = false, izq = false, arr = false, aba = false;
        int x = 250, y = 100, cont_aba = 0, cont_arr = 0, cont_izq = 0, cont_der = 0;
        int velocidad = 5;
        Bitmap[] mov_down = new Bitmap[5];
        Bitmap[] mov_up = new Bitmap[5];
        Bitmap[] mov_left = new Bitmap[5];
        Bitmap[] mov_right = new Bitmap[5];

        protected void mover_personaje()
        {
            if (izq)
            {
                if (cont_izq == 4)
                {
                    cont_izq = 0;
                }
                else
                {
                    cont_izq++;
                }
                personaje = mov_left[cont_izq];
                x -= velocidad;
            }

            if (der)
            {
                if (cont_der == 4)
                {
                    cont_der = 0;
                }
                else
                {
                    cont_der++;
                }
                personaje = mov_right[cont_der];
                x += velocidad;
            }

            if (arr)
            {
                if (cont_arr == 4)
                {
                    cont_arr = 0;
                }
                else
                {
                    cont_arr++;
                }
                personaje = mov_up[cont_arr];
                y -= velocidad;
            }

            if (aba)
            {
                if (cont_aba == 4)
                {
                    cont_aba = 0;
                }
                else
                {
                    cont_aba++;
                }
                personaje = mov_down[cont_aba];
                y += velocidad;
            }

            this.Invalidate();
        }

        protected override void OnPaint(PaintEventArgs p)
        {
            //p.Graphics.DrawImage(fondo, 0, 0);
            p.Graphics.DrawImage(personaje, x, y);
        }

        public Form1()
        {
            InitializeComponent();
            //fondo = new Bitmap("fondo.png");
            for (int i = 0; i < 5; i++) { mov_down[i] = new Bitmap("C:/Users/Fernando/Documents/GitHub/2dam/DINT/Game/Game/res/personaje1" + i + ".png"); }
            for (int i = 0; i < 5; i++) { mov_up[i] = new Bitmap("C:/Users/Fernando/Documents/GitHub/2dam/DINT/Game/Game/res/personaje2" + i + ".png"); }
            for (int i = 0; i < 5; i++) { mov_left[i] = new Bitmap("C:/Users/Fernando/Documents/GitHub/2dam/DINT/Game/Game/res/personaje3" + i + ".png"); }
            for (int i = 0; i < 5; i++) { mov_right[i] = new Bitmap("C:/Users/Fernando/Documents/GitHub/2dam/DINT/Game/Game/res/personaje4" + i + ".png"); }
            personaje = mov_down[0];
        }

        private void Form1_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Right) { der = true; }
            if (e.KeyCode == Keys.Left) { izq = true; }
            if (e.KeyCode == Keys.Up) { arr = true; }
            if (e.KeyCode == Keys.Down) { aba = true; }
        }

        private void Form1_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Right) { der = false; personaje = mov_right[0]; }
            if (e.KeyCode == Keys.Left) { izq = false; personaje = mov_left[0]; }
            if (e.KeyCode == Keys.Up) { arr = false; personaje = mov_up[0]; }
            if (e.KeyCode == Keys.Down) { aba = false; personaje = mov_down[0]; }
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            mover_personaje();
        }
    }
}
