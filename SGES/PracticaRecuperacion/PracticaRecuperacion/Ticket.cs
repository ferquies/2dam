using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PracticaRecuperacion
{
    class Ticket
    {
        private List<Product> products;
        private bool opened = true;

        public Ticket() { products = new List<Product>(); }

        public bool Opened
        {
            get { return this.opened; }
            set { this.opened = value; }
        }
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
}
