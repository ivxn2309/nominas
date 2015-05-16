package nominas.gui;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import nominas.control.InstitucionController;
import nominas.entity.Institucion;

public class InstModifier extends javax.swing.JInternalFrame {
    private JTextField [] fields = new JTextField[4];
    private Institucion inst;
    public InstModifier() {
        initComponents();
        inst = new InstitucionController().get();
        txtNombre.setText(inst.getName());
        txtDireccion.setText(inst.getAddress());
        txtImss.setText(inst.getImss());
        txtRfc.setText(inst.getRfc());
        fields[0] = txtNombre;
        fields[1] = txtDireccion;
        fields[2] = txtImss;
        fields[3] = txtRfc;
        enableComponents(false);
    }
    
    private void enableComponents(boolean enable){
        for(JTextField txt : fields){
            txt.setEnabled(enable);
        }
        btnSave.setEnabled(enable);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        lblname = new javax.swing.JLabel();
        lbladdr = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblImss = new javax.swing.JLabel();
        txtImss = new javax.swing.JTextField();
        lblRfc = new javax.swing.JLabel();
        txtRfc = new javax.swing.JTextField();
        btnLock = new javax.swing.JToggleButton();
        btnSave = new javax.swing.JButton();

        setClosable(true);
        setTitle("Datos de la Institución");

        lblname.setText("Nombre");

        lbladdr.setText("Dirección");

        lblImss.setText("IMSS");

        lblRfc.setText("RFC");

        btnLock.setSelected(true);
        btnLock.setText("Desbloquear");
        btnLock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLockActionPerformed(evt);
            }
        });

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtRfc, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(txtDireccion)
                            .addComponent(lblname, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addComponent(lbladdr, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImss, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtImss)
                            .addComponent(lblRfc, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLock, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblname)
                .addGap(4, 4, 4)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbladdr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblImss)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtImss, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRfc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLock, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLockActionPerformed
        enableComponents(!btnLock.isSelected());
        if(btnLock.isSelected()) {
            btnLock.setText("Desbloquear");
            return;
        }
        btnLock.setText("Bloquear");
    }//GEN-LAST:event_btnLockActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        //Comprobaciones
        for (JTextField jtf : fields) {
            if(jtf.getText().trim().length() < 5) {
                JOptionPane.showMessageDialog(this, "Hay campos con datos inválidos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        String nombre = txtNombre.getText();
        String direccion = txtDireccion.getText();
        String imss = txtImss.getText();
        String rfc = txtRfc.getText();
        
        inst.setName(nombre);
        inst.setAddress(direccion);
        inst.setImss(imss);
        inst.setRfc(rfc);
        new InstitucionController().updateInstitucion(inst);
        inst = new InstitucionController().get();
        txtNombre.setText(inst.getName());
        txtDireccion.setText(inst.getAddress());
        txtImss.setText(inst.getImss());
        txtRfc.setText(inst.getRfc());
        enableComponents(false);
        btnLock.setSelected(true);
        btnLock.setText("Desbloquear");
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnLock;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblImss;
    private javax.swing.JLabel lblRfc;
    private javax.swing.JLabel lbladdr;
    private javax.swing.JLabel lblname;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtImss;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRfc;
    // End of variables declaration//GEN-END:variables
}
