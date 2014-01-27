namespace LoboConejo
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador requerida.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén utilizando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido del método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.labelLobo = new System.Windows.Forms.Label();
            this.labelConejo = new System.Windows.Forms.Label();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.SuspendLayout();
            // 
            // labelLobo
            // 
            this.labelLobo.AutoSize = true;
            this.labelLobo.Location = new System.Drawing.Point(67, 55);
            this.labelLobo.Name = "labelLobo";
            this.labelLobo.Size = new System.Drawing.Size(31, 13);
            this.labelLobo.TabIndex = 0;
            this.labelLobo.Text = "Lobo";
            // 
            // labelConejo
            // 
            this.labelConejo.AutoSize = true;
            this.labelConejo.Location = new System.Drawing.Point(237, 197);
            this.labelConejo.Name = "labelConejo";
            this.labelConejo.Size = new System.Drawing.Size(40, 13);
            this.labelConejo.TabIndex = 1;
            this.labelConejo.Text = "Conejo";
            // 
            // timer1
            // 
            this.timer1.Enabled = true;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(556, 406);
            this.Controls.Add(this.labelConejo);
            this.Controls.Add(this.labelLobo);
            this.Name = "Form1";
            this.Text = "LoboConejo";
            this.KeyDown += new System.Windows.Forms.KeyEventHandler(this.Form1_KeyDown);
            this.KeyUp += new System.Windows.Forms.KeyEventHandler(this.Form1_KeyUp);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelLobo;
        private System.Windows.Forms.Label labelConejo;
        private System.Windows.Forms.Timer timer1;
    }
}

