package nominas.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import nominas.control.DeptoController;
import nominas.control.EmpleadoController;
import nominas.control.ListaNominaController;
import nominas.control.PuestoController;
import nominas.entity.Departamento;
import nominas.entity.Empleado;
import nominas.entity.ListaNomina;
import nominas.entity.Puesto;

public class FormEmpleado extends javax.swing.JInternalFrame {
    private boolean isNewEmployee = true;
    private Empleado empleado = null;
    public FormEmpleado() {
        //Se inicializan los componentes
        initComponents();
        //Se oculta el panel de baja porque es usuario nuevo
        tabbedPanel.remove(2);
        
        //Se rellenan los puestos
        comboPuestos.removeAllItems();
        List<Puesto> puestos = new PuestoController().getAllPuestos();
        puestos.stream().forEach((puesto) -> {
            comboPuestos.addItem(puesto);
        });
        //Se rellenan los departamentos
        comboDepartamentos.removeAllItems();
        List<Departamento> deptos = new DeptoController().getAllDepartamentos();
        deptos.stream().forEach((depto) -> {
            comboDepartamentos.addItem(depto);
        });
        //Se rellena el combobox de las nominas
        comboNominas.removeAllItems();
        List<ListaNomina> nomis = new ListaNominaController().getAllTypesOfNomina();
        nomis.stream().forEach((nomi) -> {
            comboNominas.addItem(nomi);
        });
        
        // Se ajusta el tamaño del calendario
        chooserDateIngreso.setCurrent(Calendar.getInstance());
        Dimension size = chooserDateIngreso.getCalendarPreferredSize();
        size.height += 35;
        size.width += 90;
        chooserDateIngreso.setCalendarPreferredSize(size);
    }
    
    public FormEmpleado(Empleado empleado) {
        //Se inicializan los componentes
        initComponents();
        isNewEmployee = false;
        this.empleado = empleado;
        buttonSave.setText("Guardar");
        this.setTitle("Modificar empleado");
        //Se cargan los datos del empleado
        loadEmployee(empleado);
        chooserDateBaja.setEnabled(checkBaja.isSelected());
    }
    
    private void loadEmployee(Empleado empleado){
        //Se rellenan los puestos
        comboPuestos.removeAllItems();
        List<Puesto> puestos = new PuestoController().getAllPuestos();
        puestos.stream().forEach((puesto) -> {
            comboPuestos.addItem(puesto);
        });
        
        //Se selecciona el puesto adecuado
        comboPuestos.setSelectedItem(
            new PuestoController().getPuesto(
                    empleado.getPuesto()
            )
        );
        
        //Se rellenan los departamentos
        comboDepartamentos.removeAllItems();
        List<Departamento> deptos = new DeptoController().getAllDepartamentos();
        deptos.stream().forEach((depto) -> {
            comboDepartamentos.addItem(depto);
        });
        
        //Se selecciona el departamento adecuado
        comboDepartamentos.setSelectedItem(
            new DeptoController().getDepartamento(
                    empleado.getDepartamento()
            )
        );
        
        //Se rellena el combobox de las nominas
        comboNominas.removeAllItems();
        List<ListaNomina> nomis = new ListaNominaController().getAllTypesOfNomina();
        nomis.stream().forEach((nomi) -> {
            comboNominas.addItem(nomi);
        });
        
        //Se selecciona el departamento adecuado
        comboNominas.setSelectedItem(
            new ListaNominaController().getListaNomina(
                    empleado.getNomina()
            )
        );
        
        // Se ajusta el tamaño de los calendarios
        Dimension size = chooserDateIngreso.getCalendarPreferredSize();
        size.height += 35;
        size.width += 90;
        chooserDateIngreso.setCalendarPreferredSize(size);
        chooserDateBaja.setCalendarPreferredSize(size);
        
        //Se ajusta la fecha mostrada
        Calendar cal = Calendar.getInstance();
        cal.setTime(empleado.getFechaIngreso());
        chooserDateIngreso.setSelectedDate(cal);
        if(empleado.getFechaSalida() != null) {
            cal.setTime(empleado.getFechaSalida());
            checkBaja.setSelected(true);
        }
        chooserDateBaja.setSelectedDate(cal);
        
        //Se completan los campos de texto con los datos del empleado
        txtNombre.setText(empleado.getNombre());
        txtApellido.setText(empleado.getApellido());
        txtEmail.setText(empleado.getEmail());
        txtRFC.setText(empleado.getRfc());
        txtCURP.setText(empleado.getCurp());
        txtIMSS.setText(empleado.getImss());
        spinnerDias.setValue(empleado.getDias_jornada());
        spinnerHoras.setValue(empleado.getHoras_dia());
        spinnerSalario.setValue(empleado.getSalario());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPanel = new javax.swing.JTabbedPane();
        panelBasico = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        labelApellidos = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtRFC = new javax.swing.JTextField();
        labelRFC = new javax.swing.JLabel();
        txtIMSS = new javax.swing.JTextField();
        labelIMSS = new javax.swing.JLabel();
        labelCURP = new javax.swing.JLabel();
        txtCURP = new javax.swing.JTextField();
        panelTrabajo = new javax.swing.JPanel();
        labelDep = new javax.swing.JLabel();
        labelPuesto = new javax.swing.JLabel();
        comboDepartamentos = new javax.swing.JComboBox();
        comboPuestos = new javax.swing.JComboBox();
        chooserDateIngreso = new datechooser.beans.DateChooserCombo();
        labelFecha = new javax.swing.JLabel();
        labelHoras = new javax.swing.JLabel();
        labelDias = new javax.swing.JLabel();
        spinnerHoras = new javax.swing.JSpinner();
        spinnerDias = new javax.swing.JSpinner();
        comboNominas = new javax.swing.JComboBox();
        labelNominas = new javax.swing.JLabel();
        spinnerSalario = new javax.swing.JSpinner();
        labelSalario = new javax.swing.JLabel();
        panelBajaEmpleado = new javax.swing.JPanel();
        checkBaja = new javax.swing.JCheckBox();
        chooserDateBaja = new datechooser.beans.DateChooserCombo();
        panelFin = new javax.swing.JPanel();
        btnCalcularFiniquito = new javax.swing.JButton();
        lblFiniquito = new javax.swing.JLabel();
        lblTitleFin = new javax.swing.JLabel();
        buttonSave = new javax.swing.JButton();
        statusBar = new javax.swing.JLabel();

        setClosable(true);
        setForeground(java.awt.Color.darkGray);
        setIconifiable(true);
        setTitle("Nuevo Empleado");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/add_.png"))); // NOI18N
        setName("formRegistroEmpleado"); // NOI18N

        tabbedPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelNombre.setText("*Nombre(s):");

        labelApellidos.setText("*Apellidos:");

        labelEmail.setText("E-mail:");

        labelRFC.setText("R.F.C.:");

        labelIMSS.setText("I.M.S.S.:");

        labelCURP.setText("*C.U.R.P.");

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
                    .addComponent(labelNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelApellidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRFC)
                    .addComponent(txtIMSS)
                    .addGroup(panelBasicoLayout.createSequentialGroup()
                        .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelIMSS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 109, Short.MAX_VALUE))
                    .addComponent(txtCURP))
                .addContainerGap())
        );
        panelBasicoLayout.setVerticalGroup(
            panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBasicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(labelRFC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRFC, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelApellidos)
                    .addComponent(labelCURP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(txtCURP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmail)
                    .addComponent(labelIMSS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIMSS))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tabbedPanel.addTab("Datos Básicos", panelBasico);

        labelDep.setText("Departamento:");

        labelPuesto.setText("Puesto:");

        comboDepartamentos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboPuestos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelFecha.setText("Fecha de Ingreso:");

        labelHoras.setText("Horas al día");

        labelDias.setText("Días de jornada");

        spinnerHoras.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        spinnerDias.setModel(new javax.swing.SpinnerNumberModel(1, 1, 15, 1));

        comboNominas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelNominas.setText("Nominas");

        spinnerSalario.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 10000.0d, 1.0d));

        labelSalario.setText("Salario Diario");

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
                            .addComponent(labelDep, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPuesto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chooserDateIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(spinnerSalario)
                            .addGroup(panelTrabajoLayout.createSequentialGroup()
                                .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelTrabajoLayout.createSequentialGroup()
                        .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboNominas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNominas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelDias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinnerDias, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelTrabajoLayout.setVerticalGroup(
            panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTrabajoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDep)
                    .addComponent(labelFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chooserDateIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboDepartamentos, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPuesto)
                    .addComponent(labelSalario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTrabajoLayout.createSequentialGroup()
                        .addComponent(comboPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelNominas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboNominas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTrabajoLayout.createSequentialGroup()
                        .addComponent(spinnerSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelHoras)
                            .addComponent(labelDias))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spinnerDias, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(spinnerHoras))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tabbedPanel.addTab("Datos de Trabajo", panelTrabajo);

        checkBaja.setText("Establecer fecha de baja");
        checkBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBajaActionPerformed(evt);
            }
        });

        panelFin.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnCalcularFiniquito.setText("Calcular Finiquito");
        btnCalcularFiniquito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularFiniquitoActionPerformed(evt);
            }
        });

        lblFiniquito.setFont(new java.awt.Font("Monaco", 1, 14)); // NOI18N
        lblFiniquito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFiniquito.setText("_____________");

        lblTitleFin.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        lblTitleFin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleFin.setText("Finqiuito");

        javax.swing.GroupLayout panelFinLayout = new javax.swing.GroupLayout(panelFin);
        panelFin.setLayout(panelFinLayout);
        panelFinLayout.setHorizontalGroup(
            panelFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFinLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(btnCalcularFiniquito, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(panelFinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFiniquito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelFinLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(lblTitleFin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFinLayout.setVerticalGroup(
            panelFinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitleFin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(lblFiniquito, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCalcularFiniquito, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelBajaEmpleadoLayout = new javax.swing.GroupLayout(panelBajaEmpleado);
        panelBajaEmpleado.setLayout(panelBajaEmpleadoLayout);
        panelBajaEmpleadoLayout.setHorizontalGroup(
            panelBajaEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBajaEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBajaEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBaja)
                    .addComponent(chooserDateBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(panelFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBajaEmpleadoLayout.setVerticalGroup(
            panelBajaEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBajaEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBaja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBajaEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBajaEmpleadoLayout.createSequentialGroup()
                        .addComponent(chooserDateBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabbedPanel.addTab("Dar de baja", panelBajaEmpleado);

        buttonSave.setText("Crear");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedPanel)
                    .addComponent(statusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        //Si es empleado nuevo, se crea una nueva instancia
        if(isNewEmployee) empleado = new Empleado();
        //De lo contrario se utiliza el empleado obtenido
        //Se comprueba la integridad de los campos
        if(validateFields()){
            empleado.setNombre(txtNombre.getText());
            empleado.setApellido(txtApellido.getText());
            empleado.setEmail(txtEmail.getText().trim().toLowerCase());
            empleado.setImss(txtIMSS.getText().trim().toUpperCase());
            empleado.setRfc(txtRFC.getText().trim().toUpperCase());
            empleado.setCurp(txtCURP.getText().trim().toUpperCase());
            empleado.setHoras_dia((Integer)spinnerHoras.getValue());
            empleado.setDias_jornada((Integer)spinnerDias.getValue());
            empleado.setSalario((Double)(spinnerSalario.getValue()));
            empleado.setFechaIngreso(chooserDateIngreso.getSelectedDate().getTime());
            empleado.setDepartamento(((Departamento)comboDepartamentos.getSelectedItem()).getId_dep());
            empleado.setPuesto(((Puesto)comboPuestos.getSelectedItem()).getId_puesto());
            empleado.setNomina(((ListaNomina)comboNominas.getSelectedItem()).getId());
            
            //Si se va a especificar fecha de salida
            if(checkBaja.isSelected()){
                empleado.setFechaSalida(chooserDateBaja.getSelectedDate().getTime());
            }
            else
                empleado.setFechaSalida(null);
            
            //Si es nuevo empleado, se guarda un nuevo registro
            if(isNewEmployee){
                new EmpleadoController().saveNewEmpleado(empleado);
                JOptionPane.showMessageDialog(this, "Registrado correctamente", "Exito", JOptionPane.PLAIN_MESSAGE);
            }
            //De lo contrario se actualiza
            else{
                new EmpleadoController().updateEmpleado(empleado);
                JOptionPane.showMessageDialog(this, "Actualizado correctamente", "Exito", JOptionPane.PLAIN_MESSAGE);
            }

            //Se notifica, se limpia, y se cierra
            statusBar.setText("Empleado guardado correctamente");
            clearFields();
            this.setVisible(false);
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void checkBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBajaActionPerformed
        boolean status = checkBaja.isSelected();
        chooserDateBaja.setEnabled(status);
    }//GEN-LAST:event_checkBajaActionPerformed

    private void btnCalcularFiniquitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularFiniquitoActionPerformed
        double money = empleado.getSalario() * empleado.getDias_jornada() * 6.0;
        Calendar yearAgo = Calendar.getInstance();
        int year = yearAgo.get(Calendar.YEAR);
        yearAgo.set(Calendar.YEAR, year-1);
        
        Calendar ing = Calendar.getInstance();
        ing.setTime(empleado.getFechaIngreso());
        if(ing.before(yearAgo))
            money += empleado.getSalario() * empleado.getDias_jornada();
        
        money = Math.round(money * 100) / 100;
        String result = "$" + money + " MXN";
        lblFiniquito.setText(result);
    }//GEN-LAST:event_btnCalcularFiniquitoActionPerformed

    private boolean validateFields(){
        if(txtNombre.getText().trim().length() < 2)
            statusBar.setText("Debes introducir un nombre válido.");
        else if(txtApellido.getText().trim().length() < 2)
            statusBar.setText("Debes introducir un apellido válido.");
        else if(txtCURP.getText().trim().length() < 18)
            statusBar.setText("La CURP introducida no es valida.");
        else if(txtEmail.getText().trim().length() > 0 && 
                (!txtEmail.getText().contains("@") || 
                 !txtEmail.getText().contains(".") ||
                 txtEmail.getText().contains(" ")))
            statusBar.setText("El e-mail no es válido.");
        else if(txtIMSS.getText().trim().length() > 0 && 
                (txtIMSS.getText().trim().length() < 2 || 
                txtIMSS.getText().trim().length() > 24))
            statusBar.setText("El numero de seguro no es válido.");
        //Valida si la fecha especificada es en el futuro
        else if(chooserDateIngreso.getSelectedDate().getTime().after(Calendar.getInstance().getTime()))
            statusBar.setText("La fecha de ingreso no puede ser en el futuro.");
        else if(checkBaja.isSelected() && 
                chooserDateBaja.getSelectedDate().getTime().
                        before(chooserDateIngreso.getSelectedDate().getTime()))
            statusBar.setText("La fecha de salida no puede ser antes del ingreso."); 
        else {
            return true;
        }
        statusBar.setForeground(Color.RED);
        statusBar.setFont(Font.decode("Century Gothic-BOLD-12"));
        return false;
    }
    
    private void clearFields(){
        txtApellido.setText("");
        txtEmail.setText("");
        txtIMSS.setText("");
        txtNombre.setText("");
        txtRFC.setText("");
        txtCURP.setText("");
        spinnerDias.setValue(1);
        spinnerHoras.setValue(1);
        spinnerSalario.setValue(0);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcularFiniquito;
    private javax.swing.JButton buttonSave;
    private javax.swing.JCheckBox checkBaja;
    private datechooser.beans.DateChooserCombo chooserDateBaja;
    private datechooser.beans.DateChooserCombo chooserDateIngreso;
    private javax.swing.JComboBox comboDepartamentos;
    private javax.swing.JComboBox comboNominas;
    private javax.swing.JComboBox comboPuestos;
    private javax.swing.JLabel labelApellidos;
    private javax.swing.JLabel labelCURP;
    private javax.swing.JLabel labelDep;
    private javax.swing.JLabel labelDias;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelHoras;
    private javax.swing.JLabel labelIMSS;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNominas;
    private javax.swing.JLabel labelPuesto;
    private javax.swing.JLabel labelRFC;
    private javax.swing.JLabel labelSalario;
    private javax.swing.JLabel lblFiniquito;
    private javax.swing.JLabel lblTitleFin;
    private javax.swing.JPanel panelBajaEmpleado;
    private javax.swing.JPanel panelBasico;
    private javax.swing.JPanel panelFin;
    private javax.swing.JPanel panelTrabajo;
    private javax.swing.JSpinner spinnerDias;
    private javax.swing.JSpinner spinnerHoras;
    private javax.swing.JSpinner spinnerSalario;
    private javax.swing.JLabel statusBar;
    private javax.swing.JTabbedPane tabbedPanel;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCURP;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIMSS;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
}
