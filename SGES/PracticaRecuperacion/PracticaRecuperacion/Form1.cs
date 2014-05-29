using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace PracticaRecuperacion
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            /*Cash cash;
            DialogResult open = MessageBox.Show("¿Abrir caja ahora?", "TPV", MessageBoxButtons.YesNo);
            if(open == DialogResult.Yes)
            cash = new Cash(200);
            if (!cash.Open())
                MessageBox.Show("Error al abrir la caja", "TPV", MessageBoxButtons.OK, MessageBoxIcon.Error);
            */
        }

        /*Ticket ticket = new Ticket();
        Product cocacola = new Product("Coca-Cola", "Refresco de cola con gas", "C:/Documents and Settings/Fer/Mis documentos/Visual Studio 2010/Projects/PracticaRecuperacion/PracticaRecuperacion/images/cocacola.gif", "C:/Documents and Settings/Fer/Mis documentos/Visual Studio 2010/Projects/PracticaRecuperacion/PracticaRecuperacion/images/cocacola.gif", 1.5, 21, 10);
        Product cocacola2 = new Product("Coca-Cola", "Refresco de cola con gas", "C:/Documents and Settings/Fer/Mis documentos/Visual Studio 2010/Projects/PracticaRecuperacion/PracticaRecuperacion/images/cocacola.gif", "C:/Documents and Settings/Fer/Mis documentos/Visual Studio 2010/Projects/PracticaRecuperacion/PracticaRecuperacion/images/cocacola.gif", 1.7, 21, 10);
        */
    }
    class Product
    {
        private string name;
        private string description;
        private Image photo;
        private Image tpv_image;
        private double prize;
        private int iva;
        private int units;

        public Product(string name, string description, string photo, string tpv_image, double prize, int iva, int units)
        {
            this.name = name;
            this.description = description;
            this.photo = Image.FromFile(photo);
            this.tpv_image = Image.FromFile(tpv_image);
            this.prize = prize;
            this.iva = iva;
            this.units = units;
        }

        public string Name
        {
            get { return name; }
            set { name = value; }
        }
        public string Desciption
        {
            get { return description; }
            set { description = value; }
        }
        public Image Photo
        {
            get { return photo; }
            set { photo = value; }
        }
        public Image TPV_Image
        {
            get { return tpv_image; }
            set { tpv_image = value; }
        }
        public double Prize
        {
            get { return prize; }
            set { prize = value; }
        }
        public int IVA
        {
            get { return iva; }
            set { iva = value; }
        }
        public int Units
        {
            get { return units; }
            set { units = value; }
        }
    }
    class Ticket
    {
        private List<Product> products;
        private bool opened = true;

        public Ticket() { products = new List<Product>(); }
        
        public bool Add(Product product)
        {
            bool result = false;

            if (opened)
            {
                if (product.Units > 0)
                {
                    products.Add(product);
                    product.Units--;
                    result = true;
                }
            }

            return result;
        }
        public void Remove(Product product)
        {
            if (opened)
            {
                products.Remove(product);
                product.Units++;
            }
        }
        public int Count() { return products.Count; }
        public double Bill()
        {
            double bill = 0;
            for (int i = 0; i < products.Count(); i++)
            {
                bill += products[i].Prize;
            }
            return bill;
        }
        public double BillTax()
        {
            double bill = 0;
            for (int i = 0; i < products.Count(); i++)
            {
                bill += products[i].Prize;
                bill += products[i].Prize / 100 * products[i].IVA;
            }
            return bill;
        }
    }
    class Cash
    {
        private bool status;
        private double amount;
        private double default_amount;
        private List<Ticket> ticket_list = new List<Ticket>();

        public Cash(int default_amount)
        {
            this.status = false;
            this.default_amount = default_amount;
        }

        public bool Open()
        {
            bool result = false;
            if (!this.status)
            {
                this.status = true;
                this.amount = this.default_amount;
                result = true;
            }
            return result;
        }
        public bool Close()
        {
            bool result = false;
            if (this.status)
            {
                this.amount = this.default_amount;
                this.ticket_list = null;
                result = true;
            }
            return result;
        }
        public bool Charge(Ticket ticket)
        {
            bool result = false;
            bool allow = true;
            for (int t = 0; t < this.ticket_list.Count; t++)
            {
                if (this.ticket_list[t] == ticket)
                    allow = false;
            }
            if(allow)
                this.amount += ticket.BillTax();
            return result;
        }
    }
}
