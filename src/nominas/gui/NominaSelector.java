package nominas.gui;

import com.itextpdf.text.DocumentException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import nominas.control.ListaNominaController;
import nominas.control.PDFController;
import nominas.entity.ListaNomina;

public class NominaSelector extends javax.swing.JInternalFrame {

    public NominaSelector() {
        initComponents();
        new ListaNominaController().getAllTypesOfNomina().stream().forEach((nom) -> {
            nominasBox.addItem(nom);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nominasBox = new javax.swing.JComboBox();
        labelInst = new javax.swing.JLabel();
        toolBar = new javax.swing.JToolBar();
        generateButton = new javax.swing.JButton();

        setClosable(true);
        setTitle("Recibos por Nomina");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/group-users.png"))); // NOI18N

        labelInst.setText("Elige la nomina para generar el recibo:");

        toolBar.setFloatable(false);
        toolBar.setBorderPainted(false);

        generateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/good.png"))); // NOI18N
        generateButton.setText("Generar");
        generateButton.setFocusable(false);
        generateButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        generateButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });
        toolBar.add(generateButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nominasBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelInst, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelInst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nominasBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        ListaNomina sel = (ListaNomina)nominasBox.getSelectedItem();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Recibos de " + sel.getNombre());
        int status = fileChooser.showSaveDialog(this);
        
        File file = fileChooser.getSelectedFile(); 
        if(status == JFileChooser.APPROVE_OPTION){
            String filename = file.toString();
            if(!filename.endsWith(".pdf"))
                filename = filename.concat(".pdf");
            PDFController generator = new PDFController(filename);
            try {
                generator.createPdf(PDFController.RECIBO_DE_NOMINA, sel);
                JOptionPane.showMessageDialog(this, "El PDF fue generado correctamente", "Guardado", JOptionPane.INFORMATION_MESSAGE);
            }
            catch(FileNotFoundException fnfe) {
                JOptionPane.showMessageDialog(this, "El archivo se encuentra abierto", "Error al escribir", JOptionPane.ERROR_MESSAGE);
            }
            catch (IOException | DocumentException ex) {
                //Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "El archivo se encuentra abierto", "Error al escribir", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_generateButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton generateButton;
    private javax.swing.JLabel labelInst;
    private javax.swing.JComboBox nominasBox;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
