using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Listbox
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string items = "";
            for(int i = 0; i < listBox1.SelectedItems.Count; i++)
            {
                if(i == 0)
                {
                    items = "" + listBox1.SelectedItems[i];
                }
                else if(i < listBox1.SelectedItems.Count - 1)
                {
                    items = items + ", " + listBox1.SelectedItems[i];
                }
                else
                {
                    items = items + " y " + listBox1.SelectedItems[i] + ".";
                }
            }
            if (listBox1.SelectedItems.Count == 0)
            {
                DialogResult r = MessageBox.Show("No has seleccionado ningún item.", "Items", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
            {
                DialogResult r = MessageBox.Show("Has seleccionado " + listBox1.SelectedItems.Count + " items: " + items, "Items", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
        }
    }
}
