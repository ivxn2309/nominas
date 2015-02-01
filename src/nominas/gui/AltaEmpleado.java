package nominas.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import nominas.control.DeptoController;
import nominas.control.EmpleadoController;
import nominas.control.ListaNominaController;
import nominas.control.PuestoController;
import nominas.entity.Departamento;
import nominas.entity.Empleado;
import nominas.entity.ListaNomina;
import nominas.entity.Puesto;

public class AltaEmpleado extends javax.swing.JFrame {
    public AltaEmpleado() {
        //Se inicializan los componentes
        initComponents();
        //Se rellenan los puestos
        comboPuestos.removeAllItems();
        List<Puesto> puestos = new PuestoController().getAllPuestos();
        for(int i = 0; i < puestos.size(); i++)
            comboPuestos.addItem(puestos.get(i));
        //Se rellenan los departamentos
        comboDepartamentos.removeAllItems();
        List<Departamento> deptos = new DeptoController().getAllDepartamentos();
        for(int i = 0; i < deptos.size(); i++)
            comboDepartamentos.addItem(deptos.get(i));
        //Se rellena el combobox de las nominas
        comboNominas.removeAllItems();
        List<ListaNomina> nomis = new ListaNominaController().getAllTypesOfNomina();
        for(int i = 0; i < nomis.size(); i++)
            comboNominas.addItem(nomis.get(i));
        //Se configuran los spinners
        
        // Se ajusta el tamaño del calendario
        chooserDateIngreso.setCurrent(Calendar.getInstance());
        Dimension size = chooserDateIngreso.getCalendarPreferredSize();
        size.height += 35;
        size.width += 90;
        chooserDateIngreso.setCalendarPreferredSize(size);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPanel = new javax.swing.JTabbedPane();
        panelBasico = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtRFC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIMSS = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        panelTrabajo = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboDepartamentos = new javax.swing.JComboBox();
        comboPuestos = new javax.swing.JComboBox();
        chooserDateIngreso = new datechooser.beans.DateChooserCombo();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        spinnerHoras = new javax.swing.JSpinner();
        spinnerDias = new javax.swing.JSpinner();
        comboNominas = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        spinnerSalario = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        buttonSave = new javax.swing.JButton();
        statusBar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabbedPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("*Nombre(s):");

        jLabel2.setText("*Apellidos:");

        jLabel3.setText("E-mail:");

        jLabel5.setText("R.F.C.:");

        jLabel6.setText("I.M.S.S.:");

        javax.swing.GroupLayout panelBasicoLayout = new javax.swing.GroupLayout(panelBasico);
        panelBasico.setLayout(panelBasicoLayout);
        panelBasicoLayout.setHorizontalGroup(
            panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBasicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtNombre)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRFC)
                    .addComponent(txtIMSS)
                    .addGroup(panelBasicoLayout.createSequentialGroup()
                        .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 129, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBasicoLayout.setVerticalGroup(
            panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBasicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRFC, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIMSS, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(txtApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tabbedPanel.addTab("Datos Básicos", panelBasico);

        jLabel7.setText("Departamento:");

        jLabel8.setText("Puesto:");

        comboDepartamentos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboPuestos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Fecha de Ingreso:");

        jLabel10.setText("Horas al día");

        jLabel11.setText("Días de jornada");

        spinnerHoras.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        spinnerDias.setModel(new javax.swing.SpinnerNumberModel(1, 1, 15, 1));

        comboNominas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Nominas");

        spinnerSalario.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 10000.0d, 1.0d));

        jLabel12.setText("Salario Diario");

        javax.swing.GroupLayout panelTrabajoLayout = new javax.swing.GroupLayout(panelTrabajo);
        panelTrabajo.setLayout(panelTrabajoLayout);
        panelTrabajoLayout.setHorizontalGroup(
            panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTrabajoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTrabajoLayout.createSequentialGroup()
                        .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboPuestos, 0, 200, Short.MAX_VALUE)
                            .addComponent(comboDepartamentos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chooserDateIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(spinnerSalario)
                            .addGroup(panelTrabajoLayout.createSequentialGroup()
                                .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelTrabajoLayout.createSequentialGroup()
                        .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboNominas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinnerDias, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelTrabajoLayout.setVerticalGroup(
            panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTrabajoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chooserDateIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboDepartamentos, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTrabajoLayout.createSequentialGroup()
                        .addComponent(comboPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboNominas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTrabajoLayout.createSequentialGroup()
                        .addComponent(spinnerSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spinnerDias, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(spinnerHoras))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tabbedPanel.addTab("Datos de Trabajo", panelTrabajo);

        buttonSave.setText("Registrar");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        statusBar.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        statusBar.setForeground(new java.awt.Color(102, 102, 102));
        statusBar.setText("Listo.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tabbedPanel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(statusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusBar, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
        );

        tabbedPanel.getAccessibleContext().setAccessibleName("tab");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        Empleado empleado = new Empleado();
        if(txtNombre.getText().trim().length() < 2)
            statusBar.setText("Debes introducir un nombre válido.");
        else if(txtApellido.getText().trim().length() < 2)
            statusBar.setText("Debes introducir un apellido válido.");
        else {
            empleado.setNombre(txtNombre.getText());
            empleado.setApellido(txtApellido.getText());
            empleado.setEmail(txtEmail.getText());
            empleado.setImss(txtIMSS.getText());
            empleado.setRfc(txtRFC.getText());
            empleado.setHoras_dia((Integer)spinnerHoras.getValue());
            empleado.setDias_jornada((Integer)spinnerDias.getValue());
            empleado.setSalario((Integer)spinnerSalario.getValue());
            empleado.setFechaIngeso(toDate(chooserDateIngreso.getText()));
            empleado.setDepartamento(((Departamento)comboDepartamentos.getSelectedItem()).getId_dep());
            empleado.setPuesto(((Puesto)comboPuestos.getSelectedItem()).getId_puesto());
            empleado.setNomina(((ListaNomina)comboNominas.getSelectedItem()).getId());
            String id = new EmpleadoController().saveNewEmpleado(empleado).toString();
            statusBar.setText("Empleado guardado correctamente con el id " + id);
            txtNombre.setText("");
            txtApellido.setText("");
            txtEmail.setText("");
            txtIMSS.setText("");
            txtRFC.setText("");
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    private Date toDate(String value) {
        String [] values = value.split("/");
        int dia = Integer.parseInt(values[0]);
        int mes = Integer.parseInt(values[1]);
        int year = Integer.parseInt(values[2]);
        Calendar cal = Calendar.getInstance();
        cal.set(year, mes, dia);
        return new Date(cal.getTimeInMillis());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSave;
    private datechooser.beans.DateChooserCombo chooserDateIngreso;
    private javax.swing.JComboBox comboDepartamentos;
    private javax.swing.JComboBox comboNominas;
    private javax.swing.JComboBox comboPuestos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel panelBasico;
    private javax.swing.JPanel panelTrabajo;
    private javax.swing.JSpinner spinnerDias;
    private javax.swing.JSpinner spinnerHoras;
    private javax.swing.JSpinner spinnerSalario;
    private javax.swing.JLabel statusBar;
    private javax.swing.JTabbedPane tabbedPanel;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIMSS;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
}
