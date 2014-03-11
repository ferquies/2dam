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
        Personaje personaje;
        List<Enemigo> enemigo = new List<Enemigo>();
        Enemigo finalboss;
        Disparo d;
        bool disparo = false, vivo = false;
        Bitmap fondo;
        int xf, yf, xf1, NE = 10;
        int cont_enemigos;
        bool doble, final = false;

        protected override void OnPaint(PaintEventArgs p)
        {
            p.Graphics.DrawImage(fondo, xf, yf);
            if (doble)
                p.Graphics.DrawImage(fondo, xf1, yf);
            if (disparo)
            {
                p.Graphics.DrawImage(d.imagen(), d.getX(), d.getY());
                base.OnPaint(p);
            }
            for (int i = 0; i < NE; i++)
            {
                if (enemigo[i].getVivo())
                    p.Graphics.DrawImage(enemigo[i].imagen(), enemigo[i].getX(), enemigo[i].getY());
            }
            if (final)
            {
                p.Graphics.DrawImage(finalboss.imagen(), finalboss.getX(), finalboss.getY());
            }
            p.Graphics.DrawImage(personaje.imagen(), personaje.getX(), personaje.getY());
            base.OnPaint(p);
        }

        public Form1()
        {
            InitializeComponent();
            personaje = new Personaje();
            cont_enemigos = NE;
            for (int i = 1; i <= NE; i++)
            {
                enemigo.Add(new Enemigo(i * 300, false));
            }
            finalboss = new Enemigo(750, true);
            d = new Disparo(personaje.getX(), personaje.getY());
            fondo = new Bitmap("C:/Users/Fernando/Documents/GitHub/2dam/DINT/Game/Game/res/fondo.jpg");
            yf = -700;
        }

        private void Form1_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Right) { personaje.set_der(true); }
            if (e.KeyCode == Keys.Left) { personaje.set_izq(true); }
            if (e.KeyCode == Keys.Space)
            {
                if (!disparo)
                {
                    disparo = true;
                    d.setX(personaje.getX());
                    d.setY(personaje.getY());
                }
            }
            if (e.KeyCode == Keys.Space) vivo = true;   
            personaje.mover(e);
        }
        private void Form1_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Right) { personaje.set_der(false); }
            if (e.KeyCode == Keys.Left) { personaje.set_izq(false); }
            personaje.parar(e);
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            if (cont_enemigos == 0)
            {
                final = true;
            }

            if(vivo)
            {
                if (!final)
                {
                    xf -= 3;
                    xf1 -= 3;

                    if (xf + fondo.Size.Width <= this.Size.Width)
                    {
                        xf1 = xf;
                        xf = xf + fondo.Size.Width;
                        doble = true;
                    }
                    if (xf < 0)
                        doble = false;
                }
                else
                {
                    finalboss.mover();
                    if (d.getX() <= finalboss.getX() + finalboss.imagen().Width && d.getX() + d.imagen().Width > finalboss.getX())
                    {
                        finalboss.damage();
                        disparo = false;
                        if(finalboss.getVida() == 0)
                        {
                            timer1.Stop();
                            MessageBox.Show("¡Has ganado!");
                        }
                    }

                    if (personaje.getX() <= finalboss.getX() + finalboss.imagen().Width && personaje.getX() + personaje.imagen().Width > finalboss.getX())
                    {
                        timer1.Stop();
                        vivo = false;
                        MessageBox.Show("¡Has perdido!");
                    }
                }

                if (disparo)
                {
                    if ((d.getX() > 0 && d.getX() < Form1.ActiveForm.Width))
                    {
                        d.mover();
                    }
                    else
                    {
                        disparo = false;
                        d = new Disparo(personaje.getX(), personaje.getY());
                    }
                }

                for (int i = 0; i < NE; i++ )
                {
                    enemigo[i].mover();
                }

                for (int i = 0; i < NE; i++)
                {
                    if (enemigo[i].getVivo())
                    {
                        if (d.getX() <= enemigo[i].getX() + enemigo[i].imagen().Width && d.getX() + d.imagen().Width > enemigo[i].getX())
                        {
                            enemigo[i].damage();
                            disparo = false;
                            cont_enemigos--;
                        }
                    }
                }

                for (int i = 0; i < NE; i++)
                {
                    if (enemigo[i].getVivo())
                    {
                        if (personaje.getX() <= enemigo[i].getX() + enemigo[i].imagen().Width && personaje.getX() + personaje.imagen().Width > enemigo[i].getX())
                        {
                            if (personaje.getVida() == 0)
                            {
                                timer1.Stop();
                                vivo = false;
                                MessageBox.Show("¡Has perdido!");
                            }
                            else
                            {
                                enemigo[i].damage();
                                personaje.damage();
                            }
                        }
                    }
                }
                this.Invalidate();
            }
        }

    }

    class Disparo
    {
        Bitmap disparo;
        int velocidad, x, y;

        public Disparo(int x, int y)
        {
            this.disparo = new Bitmap("C:/Users/Fernando/Documents/GitHub/2dam/DINT/Game/Game/res/disparo.png");
            this.velocidad = 20;
            this.x = x; this.y = y;
        }

        internal Bitmap imagen()
        {
            return disparo;
        }

        internal void mover() { this.x += velocidad; }
            
        internal int getX() { return this.x; }
        internal int getY() { return this.y; }
        internal void setX(int x) { this.x = x; }
        internal void setY(int y) { this.y = y; }
    }

    class Personaje
    {
        Bitmap personaje;
        bool der, izq;
        int x, y, cont_izq, cont_der, vida;
        int velocidad = 3;
        Bitmap[] mov_left = new Bitmap[5];
        Bitmap[] mov_right = new Bitmap[5];

        public Personaje()
        {
            for (int i = 0; i < 5; i++)
            {
                mov_left[i] = new Bitmap("C:/Users/Fernando/Documents/GitHub/2dam/DINT/Game/Game/res/personaje3" + i + ".png");
                mov_right[i] = new Bitmap("C:/Users/Fernando/Documents/GitHub/2dam/DINT/Game/Game/res/personaje4" + i + ".png");
            }
            x = 20; y = 330;
            cont_izq = 0; cont_der = 0;
            der = false; izq = false;
            personaje = mov_right[0];
            vida = 2;
        }
        internal void parar(KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Right) { der = false; personaje = mov_right[0]; }
            if (e.KeyCode == Keys.Left) { izq = false; personaje = mov_left[0]; }
        }
        internal void mover(KeyEventArgs e)
        {
            if (izq)
            {
                if (this.x > 10)
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
            }

            if (der)
            {
                if (this.x < 640)
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
            }
        }
        internal Bitmap imagen() { return personaje; }
        internal int getX() { return x; }
        internal int getY() { return y; }
        internal int getVida() { return this.vida; }
        internal void damage() { this.vida--; }
        internal void set_der(bool bol) { this.der = bol; }
        internal void set_izq(bool bol) { this.izq = bol; }
    }

    class Enemigo
    {
        Bitmap enemigo;
        Bitmap[] enemy = new Bitmap[4];
        int x, y, cont = 0, vida = 4;
        bool vivo = true, finalboss;

        public Enemigo(int x, bool finalboss)
        {
            this.finalboss = finalboss;
            this.x = x;
            if(this.finalboss)
            {
                this.y = 200;
                this.vida = 4;
                for (int i = 0; i < 4; i++)
                {
                    enemy[i] = new Bitmap("C:/Users/Fernando/Documents/GitHub/2dam/DINT/Game/Game/res/finalboss" + i + ".png");
                }
            }
            else
            {
                this.y = 330;
                for (int i = 0; i < 4; i++)
                {
                    enemy[i] = new Bitmap("C:/Users/Fernando/Documents/GitHub/2dam/DINT/Game/Game/res/enemy" + i + ".png");
                }
            }
            enemigo = enemy[0];
        }
        internal void mover()
        {
            if (cont == 3)
                cont = 0;
            else
                cont++;

            enemigo = enemy[cont];
            x -= 7;
        }
        internal int getVida() { return this.vida; }
        internal void damage()
        {
            if(this.finalboss)
            {
                this.vida--;
            }
            else
            {
                this.vivo = false;
                enemigo.Dispose();
            }
        }
        internal int getX() { return this.x; }
        internal int getY() { return this.y; }
        internal bool getVivo() { return this.vivo; }
        internal Bitmap imagen() { return enemigo; }
    }
}
