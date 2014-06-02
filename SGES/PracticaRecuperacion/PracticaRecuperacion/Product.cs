using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Drawing;

namespace PracticaRecuperacion
{
    class Product
    {
        private string name;
        private string description;
        private Image photo;
        private Image tpv_image;
        private double prize;
        private int iva;
        private int units;

        public Product(string name, string description, Image photo, Image tpv_image, double prize, int iva, int units)
        {
            this.name = name;
            this.description = description;
            this.photo = photo;
            this.tpv_image = tpv_image;
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
}
