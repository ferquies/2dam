namespace TemperaturasForm
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
        /// <param name="disposing">true si los recursos administrados se deben eliminar; false en caso contrario, false.</param>
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
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.panel1Celsius = new System.Windows.Forms.RadioButton();
            this.panel1Kelvin = new System.Windows.Forms.RadioButton();
            this.panel1Fh = new System.Windows.Forms.RadioButton();
            this.panel2Celsius = new System.Windows.Forms.RadioButton();
            this.panel2Kelvin = new System.Windows.Forms.RadioButton();
            this.panel2Fh = new System.Windows.Forms.RadioButton();
            this.panel1 = new System.Windows.Forms.Panel();
            this.panel2 = new System.Windows.Forms.Panel();
            this.panel1.SuspendLayout();
            this.panel2.SuspendLayout();
            this.SuspendLayout();
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(-3, 126);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(100, 20);
            this.textBox1.TabIndex = 0;
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(191, 126);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(100, 20);
            this.textBox2.TabIndex = 1;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(119, 123);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(50, 23);
            this.button1.TabIndex = 2;
            this.button1.Text = "<>";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // panel1Celsius
            // 
            this.panel1Celsius.AutoSize = true;
            this.panel1Celsius.Location = new System.Drawing.Point(3, 0);
            this.panel1Celsius.Name = "panel1Celsius";
            this.panel1Celsius.Size = new System.Drawing.Size(58, 17);
            this.panel1Celsius.TabIndex = 3;
            this.panel1Celsius.TabStop = true;
            this.panel1Celsius.Text = "Celsius";
            this.panel1Celsius.UseVisualStyleBackColor = true;
            // 
            // panel1Kelvin
            // 
            this.panel1Kelvin.AutoSize = true;
            this.panel1Kelvin.Location = new System.Drawing.Point(3, 23);
            this.panel1Kelvin.Name = "panel1Kelvin";
            this.panel1Kelvin.Size = new System.Drawing.Size(54, 17);
            this.panel1Kelvin.TabIndex = 4;
            this.panel1Kelvin.TabStop = true;
            this.panel1Kelvin.Text = "Kelvin";
            this.panel1Kelvin.UseVisualStyleBackColor = true;
            // 
            // panel1Fh
            // 
            this.panel1Fh.AutoSize = true;
            this.panel1Fh.Location = new System.Drawing.Point(2, 46);
            this.panel1Fh.Name = "panel1Fh";
            this.panel1Fh.Size = new System.Drawing.Size(37, 17);
            this.panel1Fh.TabIndex = 5;
            this.panel1Fh.TabStop = true;
            this.panel1Fh.Text = "Fh";
            this.panel1Fh.UseVisualStyleBackColor = true;
            // 
            // panel2Celsius
            // 
            this.panel2Celsius.AutoSize = true;
            this.panel2Celsius.Location = new System.Drawing.Point(3, 0);
            this.panel2Celsius.Name = "panel2Celsius";
            this.panel2Celsius.Size = new System.Drawing.Size(58, 17);
            this.panel2Celsius.TabIndex = 6;
            this.panel2Celsius.TabStop = true;
            this.panel2Celsius.Text = "Celsius";
            this.panel2Celsius.UseVisualStyleBackColor = true;
            // 
            // panel2Kelvin
            // 
            this.panel2Kelvin.AutoSize = true;
            this.panel2Kelvin.Location = new System.Drawing.Point(3, 23);
            this.panel2Kelvin.Name = "panel2Kelvin";
            this.panel2Kelvin.Size = new System.Drawing.Size(54, 17);
            this.panel2Kelvin.TabIndex = 7;
            this.panel2Kelvin.TabStop = true;
            this.panel2Kelvin.Text = "Kelvin";
            this.panel2Kelvin.UseVisualStyleBackColor = true;
            // 
            // panel2Fh
            // 
            this.panel2Fh.AutoSize = true;
            this.panel2Fh.Location = new System.Drawing.Point(3, 46);
            this.panel2Fh.Name = "panel2Fh";
            this.panel2Fh.Size = new System.Drawing.Size(37, 17);
            this.panel2Fh.TabIndex = 8;
            this.panel2Fh.TabStop = true;
            this.panel2Fh.Text = "Fh";
            this.panel2Fh.UseVisualStyleBackColor = true;
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.panel1Kelvin);
            this.panel1.Controls.Add(this.panel1Celsius);
            this.panel1.Controls.Add(this.panel1Fh);
            this.panel1.Location = new System.Drawing.Point(-3, 1);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(87, 100);
            this.panel1.TabIndex = 9;
            // 
            // panel2
            // 
            this.panel2.Controls.Add(this.panel2Celsius);
            this.panel2.Controls.Add(this.panel2Kelvin);
            this.panel2.Controls.Add(this.panel2Fh);
            this.panel2.Location = new System.Drawing.Point(212, 1);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(79, 100);
            this.panel2.TabIndex = 10;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(292, 273);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.textBox2);
            this.Controls.Add(this.textBox1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.panel2.ResumeLayout(false);
            this.panel2.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.RadioButton panel1Celsius;
        private System.Windows.Forms.RadioButton panel1Kelvin;
        private System.Windows.Forms.RadioButton panel1Fh;
        private System.Windows.Forms.RadioButton panel2Celsius;
        private System.Windows.Forms.RadioButton panel2Kelvin;
        private System.Windows.Forms.RadioButton panel2Fh;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panel2;
    }
}

