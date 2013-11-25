namespace Negrita_Cursiva
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
            this.checkNegrita = new System.Windows.Forms.CheckBox();
            this.checkCursiva = new System.Windows.Forms.CheckBox();
            this.label1 = new System.Windows.Forms.Label();
            this.checkTachado = new System.Windows.Forms.CheckBox();
            this.checkSub = new System.Windows.Forms.CheckBox();
            this.SuspendLayout();
            // 
            // checkNegrita
            // 
            this.checkNegrita.AutoSize = true;
            this.checkNegrita.Location = new System.Drawing.Point(12, 63);
            this.checkNegrita.Name = "checkNegrita";
            this.checkNegrita.Size = new System.Drawing.Size(60, 17);
            this.checkNegrita.TabIndex = 1;
            this.checkNegrita.Text = "Negrita";
            this.checkNegrita.UseVisualStyleBackColor = true;
            this.checkNegrita.CheckedChanged += new System.EventHandler(this.checkNegrita_CheckedChanged);
            // 
            // checkCursiva
            // 
            this.checkCursiva.AutoSize = true;
            this.checkCursiva.Location = new System.Drawing.Point(95, 63);
            this.checkCursiva.Name = "checkCursiva";
            this.checkCursiva.Size = new System.Drawing.Size(61, 17);
            this.checkCursiva.TabIndex = 2;
            this.checkCursiva.Text = "Cursiva";
            this.checkCursiva.UseVisualStyleBackColor = true;
            this.checkCursiva.CheckedChanged += new System.EventHandler(this.checkCursiva_CheckedChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(40, 21);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(85, 13);
            this.label1.TabIndex = 3;
            this.label1.Text = "Texto de prueba";
            // 
            // checkTachado
            // 
            this.checkTachado.AutoSize = true;
            this.checkTachado.Location = new System.Drawing.Point(95, 86);
            this.checkTachado.Name = "checkTachado";
            this.checkTachado.Size = new System.Drawing.Size(69, 17);
            this.checkTachado.TabIndex = 5;
            this.checkTachado.Text = "Tachado";
            this.checkTachado.UseVisualStyleBackColor = true;
            this.checkTachado.CheckedChanged += new System.EventHandler(this.checkTachado_CheckedChanged);
            // 
            // checkSub
            // 
            this.checkSub.AutoSize = true;
            this.checkSub.Location = new System.Drawing.Point(12, 86);
            this.checkSub.Name = "checkSub";
            this.checkSub.Size = new System.Drawing.Size(77, 17);
            this.checkSub.TabIndex = 4;
            this.checkSub.Text = "Subrayado";
            this.checkSub.UseVisualStyleBackColor = true;
            this.checkSub.CheckedChanged += new System.EventHandler(this.checkSub_CheckedChanged);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(172, 118);
            this.Controls.Add(this.checkTachado);
            this.Controls.Add(this.checkSub);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.checkCursiva);
            this.Controls.Add(this.checkNegrita);
            this.Name = "Form1";
            this.Text = "NCST";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.CheckBox checkNegrita;
        private System.Windows.Forms.CheckBox checkCursiva;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.CheckBox checkTachado;
        private System.Windows.Forms.CheckBox checkSub;
    }
}

