package nominas.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import nominas.control.SalarioController;
import nominas.entity.Deduccion;
import nominas.entity.Empleado;
import nominas.entity.Percepcion;

public class SalarioManager extends javax.swing.JInternalFrame {
    private Empleado empleado;

    public SalarioManager(Empleado empleado) {
        this.empleado = empleado;
        initComponents();
        loadEmployee(empleado);
        btnDeleteDedu.setEnabled(false);
        btnDeletePerce.setEnabled(false);
        btnFinDedu.setEnabled(false);
        btnFinPerce.setEnabled(false);
        btnDeletePerce.setVisible(false);
        btnDeleteDedu.setVisible(false);
        
        //Se inician los manejadores de eventos de las listas
        listDeducciones.addListSelectionListener(getListDeduListener());
        listPercepciones.addListSelectionListener(getListPerceListener());
        
        //Se ajusta el tamaño del calendario
        Dimension size = chooserFecha.getCalendarPreferredSize();
        size.height += 35;
        size.width += 90;
        chooserFecha.setCalendarPreferredSize(size);
    }
    
    private void loadEmployee(Empleado emp){
        //Se crea una instancia del controlador
        SalarioController control = new SalarioController();
        
        //Se registra el nombre del empleado
        labelEmpleado.setText(emp.toString());
        
        //Se obtienen sus percepciones y se rellena la lista correspondiente
        List<Percepcion> percepciones = control.getAllCurrentPercepcionesOf(emp);
        if(percepciones != null)
            listPercepciones.setListData(percepciones.toArray());
        
        //Se obtienen sus percepciones y se rellena la lista correspondiente
        List<Deduccion> deducciones = control.getAllCurrentDeduccionesOf(emp);
        if(deducciones != null)
            listDeducciones.setListData(deducciones.toArray());        
    }
    
    private ListSelectionListener getListDeduListener(){
        ListSelectionListener listener = (ListSelectionEvent e) -> {
            if(listDeducciones.isSelectionEmpty()){
                btnDeleteDedu.setEnabled(false);
                btnFinDedu.setEnabled(false);
            }
            else {
                btnDeleteDedu.setEnabled(true);
                btnFinDedu.setEnabled(true);
            }
        };
        return listener;
    }
    
    private ListSelectionListener getListPerceListener(){
        ListSelectionListener listener = (ListSelectionEvent e) -> {
            if(listPercepciones.isSelectionEmpty()){
                btnDeletePerce.setEnabled(false);
                btnFinPerce.setEnabled(false);
            }
            else {
                btnDeletePerce.setEnabled(true);
                btnFinPerce.setEnabled(true);
            }
        };
        return listener;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listDeducciones = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listPercepciones = new javax.swing.JList();
        panelData = new javax.swing.JPanel();
        labelEmpleado = new javax.swing.JLabel();
        txtRazon = new javax.swing.JTextField();
        labelRazon = new javax.swing.JLabel();
        labelCantidad = new javax.swing.JLabel();
        spinCantidad = new javax.swing.JSpinner();
        labelFecha = new javax.swing.JLabel();
        chooserFecha = new datechooser.beans.DateChooserCombo();
        btnDeducir = new javax.swing.JButton();
        btnPercibir = new javax.swing.JButton();
        btnDeleteDedu = new javax.swing.JButton();
        btnDeletePerce = new javax.swing.JButton();
        btnFinDedu = new javax.swing.JButton();
        btnFinPerce = new javax.swing.JButton();
        btnCalcPrima = new javax.swing.JButton();

        setClosable(true);
        setTitle("Deducciones y Percepciones");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/updown.png"))); // NOI18N

        listDeducciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Deducciones Actuales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11))); // NOI18N
        jScrollPane1.setViewportView(listDeducciones);

        listPercepciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Percepciones Actuales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 11))); // NOI18N
        jScrollPane2.setViewportView(listPercepciones);

        panelData.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        labelEmpleado.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        labelEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEmpleado.setText("Empleado");

        labelRazon.setText("Razón");

        labelCantidad.setText("Cantidad");

        spinCantidad.setModel(new javax.swing.SpinnerNumberModel(0.01d, 0.01d, 10000.0d, 1.0d));

        labelFecha.setText("Fecha");

        btnDeducir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/l_arrow.png"))); // NOI18N
        btnDeducir.setText("Deducir");
        btnDeducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeducirActionPerformed(evt);
            }
        });

        btnPercibir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/r_arrow.png"))); // NOI18N
        btnPercibir.setText("Percibir");
        btnPercibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPercibirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDataLayout = new javax.swing.GroupLayout(panelData);
        panelData.setLayout(panelDataLayout);
        panelDataLayout.setHorizontalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRazon, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelRazon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spinCantidad)
                    .addComponent(labelFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chooserFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDataLayout.createSequentialGroup()
                        .addComponent(btnDeducir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPercibir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelDataLayout.setVerticalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelRazon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRazon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeducir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPercibir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnDeleteDedu.setText("Eliminar");
        btnDeleteDedu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDeduActionPerformed(evt);
            }
        });

        btnDeletePerce.setText("Eliminar");
        btnDeletePerce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePerceActionPerformed(evt);
            }
        });

        btnFinDedu.setText("Finalizar");
        btnFinDedu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinDeduActionPerformed(evt);
            }
        });

        btnFinPerce.setText("Finalizar");
        btnFinPerce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinPerceActionPerformed(evt);
            }
        });

        btnCalcPrima.setText("Calcular Prima Vacacional");
        btnCalcPrima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcPrimaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFinDedu, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteDedu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCalcPrima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDeletePerce, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFinPerce, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeletePerce, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteDedu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFinDedu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFinPerce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCalcPrima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeducirActionPerformed
        if(txtRazon.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, 
                    "Se debe completar la razón de la deducción", 
                    "Incompleto", JOptionPane.ERROR_MESSAGE);
            labelRazon.setForeground(Color.RED);
        }
        else {
            labelRazon.setForeground(Color.BLACK);
            Deduccion dedu = new Deduccion();
            dedu.setNombre(txtRazon.getText());        
            dedu.setCantidad((Double)spinCantidad.getValue());
            dedu.setEmpleado(empleado.getId_empleado());
            dedu.setFecha(chooserFecha.getSelectedDate().getTime());
            new SalarioController().saveDeduccion(dedu);
            loadEmployee(empleado);
            clearFields();
        }            
    }//GEN-LAST:event_btnDeducirActionPerformed

    private void btnPercibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPercibirActionPerformed
        if(txtRazon.getText().trim().isEmpty())
            JOptionPane.showMessageDialog(this, 
                    "Se debe completar la razón de la deducción", 
                    "Incompleto", JOptionPane.ERROR_MESSAGE);
        else {
            Percepcion perce = new Percepcion();
            perce.setNombre(txtRazon.getText());
            perce.setCantidad((double) spinCantidad.getValue());
            perce.setEmpleado(empleado.getId_empleado());
            perce.setFecha(chooserFecha.getSelectedDate().getTime());
            new SalarioController().savePercepcion(perce);
            loadEmployee(empleado);
            clearFields();
        }            
    }//GEN-LAST:event_btnPercibirActionPerformed
    
    private void clearFields(){
        txtRazon.setText("");
        spinCantidad.setValue(0.01);
        chooserFecha.setCurrent(Calendar.getInstance());
    }
    
    private void btnDeleteDeduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDeduActionPerformed
        int ans = JOptionPane.showConfirmDialog(this, 
                "Se descartará por completo la percepción incluyendo registros pasados", 
                "Eliminación de Deducción", 2, 1);
        if(ans == 0){
            Deduccion deduccion = (Deduccion)listDeducciones.getSelectedValue();
            new SalarioController().deleteDeduccion(deduccion);
            loadEmployee(empleado);
        }
    }//GEN-LAST:event_btnDeleteDeduActionPerformed

    private void btnDeletePerceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePerceActionPerformed
        int ans = JOptionPane.showConfirmDialog(this, 
                "Se descartará por completo la percepción incluyendo registros pasados", 
                "Eliminación de Percepción", 2, 1);
        if(ans == 0){
            Percepcion percepcion = (Percepcion)listPercepciones.getSelectedValue();
            new SalarioController().deletePercepcion(percepcion);
            loadEmployee(empleado);
        }
    }//GEN-LAST:event_btnDeletePerceActionPerformed

    private void btnFinDeduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinDeduActionPerformed
        int ans = JOptionPane.showConfirmDialog(this, 
                "La deducción ya no se hará para esta ni para las próximas quincenas", 
                "Finalizar Deducción", 2, 1);
        if(ans == 0){
            Deduccion deduccion = (Deduccion)listDeducciones.getSelectedValue();
            deduccion.setFin(Calendar.getInstance().getTime());
            new SalarioController().updateDeduccion(deduccion);
            loadEmployee(empleado);
        }
    }//GEN-LAST:event_btnFinDeduActionPerformed

    private void btnFinPerceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinPerceActionPerformed
        int ans = JOptionPane.showConfirmDialog(this, 
                "La percepción ya no se hará para esta ni para las próximas quincenas", 
                "Finalizar Percepción", 2, 1);
        if(ans == 0){
            Percepcion percepcion = (Percepcion)listPercepciones.getSelectedValue();
            percepcion.setFin(Calendar.getInstance().getTime());
            new SalarioController().updatePercepcion(percepcion);
            loadEmployee(empleado);
        }
    }//GEN-LAST:event_btnFinPerceActionPerformed

    private void btnCalcPrimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcPrimaActionPerformed
        double sueldo = empleado.getSalario()*empleado.getDias_jornada();
        double prima = sueldo/15*0.3033*10;
        Calendar cal = Calendar.getInstance();
        int actualYear = cal.get(Calendar.YEAR);
        cal.setTime(empleado.getFechaIngreso());
        int startYear = cal.get(Calendar.YEAR);
        if(actualYear-startYear > 10)
            prima = sueldo/15*0.3033*15;
        // La prima ya esta calculada
        String prime = prima+"";
        int idx = prime.indexOf(".");
        idx += 3;
        prime = prime.substring(0, idx);
        
        JOptionPane.showMessageDialog(this, "Empleado de " + (actualYear-startYear) + " años\n"
                + "Prima vacional: $"+ prime, "Cálculo de prima vacacional", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnCalcPrimaActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcPrima;
    private javax.swing.JButton btnDeducir;
    private javax.swing.JButton btnDeleteDedu;
    private javax.swing.JButton btnDeletePerce;
    private javax.swing.JButton btnFinDedu;
    private javax.swing.JButton btnFinPerce;
    private javax.swing.JButton btnPercibir;
    private datechooser.beans.DateChooserCombo chooserFecha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelEmpleado;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelRazon;
    private javax.swing.JList listDeducciones;
    private javax.swing.JList listPercepciones;
    private javax.swing.JPanel panelData;
    private javax.swing.JSpinner spinCantidad;
    private javax.swing.JTextField txtRazon;
    // End of variables declaration//GEN-END:variables
}
