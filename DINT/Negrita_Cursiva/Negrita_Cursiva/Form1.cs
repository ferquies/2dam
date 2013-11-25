using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Negrita_Cursiva
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        Font inicial;

        private void checkNegrita_CheckedChanged(object sender, EventArgs e)
        {
            inicial = label1.Font;
            label1.Font = new System.Drawing.Font(inicial, label1.Font.Style ^ FontStyle.Bold);
        }

        private void checkCursiva_CheckedChanged(object sender, EventArgs e)
        {
            inicial = label1.Font;
            label1.Font = new System.Drawing.Font(inicial, label1.Font.Style ^ FontStyle.Italic);
        }

        private void checkSub_CheckedChanged(object sender, EventArgs e)
        {
            inicial = label1.Font;
            label1.Font = new System.Drawing.Font(inicial, label1.Font.Style ^ FontStyle.Underline);
        }

        private void checkTachado_CheckedChanged(object sender, EventArgs e)
        {
            inicial = label1.Font;
            label1.Font = new System.Drawing.Font(inicial, label1.Font.Style ^ FontStyle.Strikeout);
        }
    }
}
