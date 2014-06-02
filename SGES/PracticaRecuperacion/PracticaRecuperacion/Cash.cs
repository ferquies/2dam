using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PracticaRecuperacion
{
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

        public bool Status
        {
            get { return this.status; }
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
                this.status = false;
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
            if (allow)
                this.amount += ticket.BillTax();
            return result;
        }
    }
}
