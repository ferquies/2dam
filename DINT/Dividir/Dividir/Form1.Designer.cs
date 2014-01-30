namespace Dividir
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
            this.textBoxDividendo = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.textBoxDivisor = new System.Windows.Forms.TextBox();
            this.textBoxResultado = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // textBoxDividendo
            // 
            this.textBoxDividendo.Location = new System.Drawing.Point(93, 15);
            this.textBoxDividendo.Name = "textBoxDividendo";
            this.textBoxDividendo.Size = new System.Drawing.Size(128, 20);
            this.textBoxDividendo.TabIndex = 0;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(227, 65);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 2;
            this.button1.Text = "Dividir";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // textBoxDivisor
            // 
            this.textBoxDivisor.Location = new System.Drawing.Point(93, 41);
            this.textBoxDivisor.Name = "textBoxDivisor";
            this.textBoxDivisor.Size = new System.Drawing.Size(128, 20);
            this.textBoxDivisor.TabIndex = 1;
            // 
            // textBoxResultado
            // 
            this.textBoxResultado.Location = new System.Drawing.Point(93, 67);
            this.textBoxResultado.Name = "textBoxResultado";
            this.textBoxResultado.Size = new System.Drawing.Size(128, 20);
            this.textBoxResultado.TabIndex = 3;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(32, 18);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(55, 13);
            this.label1.TabIndex = 4;
            this.label1.Text = "Dividendo";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(48, 44);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(39, 13);
            this.label2.TabIndex = 5;
            this.label2.Text = "Divisor";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(32, 70);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(55, 13);
            this.label3.TabIndex = 6;
            this.label3.Text = "Resultado";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(335, 100);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.textBoxResultado);
            this.Controls.Add(this.textBoxDivisor);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.textBoxDividendo);
            this.Name = "Form1";
            this.Text = "Dividir";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textBoxDividendo;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.TextBox textBoxDivisor;
        private System.Windows.Forms.TextBox textBoxResultado;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
    }
}

