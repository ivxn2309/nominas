package nominas.gui;

import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import nominas.control.DeptoController;
import nominas.control.EmpleadoController;
import nominas.control.ListaNominaController;
import nominas.control.PuestoController;
import nominas.entity.Departamento;
import nominas.entity.Empleado;
import nominas.entity.ListaNomina;
import nominas.entity.Puesto;

public class EmpleadosList extends javax.swing.JInternalFrame {

    public EmpleadosList() {
        initComponents();
        reloadEmployees();
        listEmployees.addListSelectionListener(getListListener());        
    }
    
    private ListSelectionListener getListListener(){
        ListSelectionListener listener = (ListSelectionEvent e) -> {
            Empleado emp = (Empleado)listEmployees.getSelectedValue();
            loadEmployee(emp);
        };
        return listener;
    }
    
    private void reloadEmployees(){
        List<Empleado> lista = new EmpleadoController().getAllEmpleados();
        System.out.println(lista);
        listEmployees.setModel(new javax.swing.AbstractListModel() {
            @Override
            public int getSize() { return lista.size(); }
            @Override
            public Empleado getElementAt(int i) { return lista.get(i); }
        });
        
        if (lista != null && lista.size() > 0){
            listEmployees.setSelectedIndex(0);
            loadEmployee(lista.get(0));
        }
    }
    
    private void loadEmployee(Empleado emp) {
        //Para completar todos los campos con los datos del empleado
        lblFolio.setText("Folio: " + emp.getId_empleado());
        lblNombre.setText("Nombre: " + emp);
        lblEmail.setText("Email: " + emp.getEmail());
        lblRFC.setText("RFC: " + emp.getRfc());
        lblIMSS.setText("IMSS: " + emp.getImss());
        lblIngreso.setText("Ingreso: " + emp.getFechaIngreso());
        lblHoras.setText("Horas al día: " + emp.getHoras_dia());
        lblDias.setText("Dias de Jornada: " + emp.getDias_jornada());
        lblSalario.setText("Salario diario: " + emp.getSalario());
        //Datos provenientes de campos foraneos
        Departamento depto = new DeptoController().getDepartamento(emp.getDepartamento());
        lblDepa.setText("Departamento: " + depto);
        
        Puesto puesto = new PuestoController().getPuesto(emp.getPuesto());
        lblPuesto.setText("Puesto: " + puesto);
        
        ListaNomina nomina = new ListaNominaController().getListaNomina(emp.getNomina());
        lblNomina.setText("Nómina: " + nomina);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        listEmployees = new javax.swing.JList();
        lblEmp = new javax.swing.JLabel();
        panelData = new javax.swing.JPanel();
        lblFolio = new javax.swing.JLabel();
        panelBasico = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblRFC = new javax.swing.JLabel();
        lblIMSS = new javax.swing.JLabel();
        lblIngreso = new javax.swing.JLabel();
        panelTrabajo = new javax.swing.JPanel();
        lblNomina = new javax.swing.JLabel();
        lblDepa = new javax.swing.JLabel();
        lblPuesto = new javax.swing.JLabel();
        lblHoras = new javax.swing.JLabel();
        lblDias = new javax.swing.JLabel();
        lblSalario = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();
        statusBar = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Empleados");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/view.png"))); // NOI18N

        listEmployees.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        scrollPane.setViewportView(listEmployees);

        lblEmp.setText("Lista de Empleados");

        panelData.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblFolio.setText("Folio: XXXXXXX");

        panelBasico.setBorder(javax.swing.BorderFactory.createTitledBorder("Básico"));

        lblNombre.setText("Nombre: __________________________________________");

        lblEmail.setText("E-mail: __________________________________________");

        lblRFC.setText("RFC: __________________________________________");

        lblIMSS.setText("IMSS: __________________________________________");

        lblIngreso.setText("Ingreso: __________________________________________");

        javax.swing.GroupLayout panelBasicoLayout = new javax.swing.GroupLayout(panelBasico);
        panelBasico.setLayout(panelBasicoLayout);
        panelBasicoLayout.setHorizontalGroup(
            panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBasicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIMSS, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBasicoLayout.setVerticalGroup(
            panelBasicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBasicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRFC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIMSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIngreso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTrabajo.setBorder(javax.swing.BorderFactory.createTitledBorder("Trabajo"));

        lblNomina.setText("Nómina: __________________________________________");

        lblDepa.setText("Departamento: ___________________________________");

        lblPuesto.setText("Puesto: ______________________________________");

        lblHoras.setText("Horas al dia: _____________________________________");

        lblDias.setText("Dias de jornada: _____________________________________");

        lblSalario.setText("Salario Diario: _____________________________________");

        javax.swing.GroupLayout panelTrabajoLayout = new javax.swing.GroupLayout(panelTrabajo);
        panelTrabajo.setLayout(panelTrabajoLayout);
        panelTrabajoLayout.setHorizontalGroup(
            panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTrabajoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDepa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoras)
                    .addComponent(lblDias)
                    .addComponent(lblSalario))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        panelTrabajoLayout.setVerticalGroup(
            panelTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTrabajoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDepa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPuesto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHoras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSalario)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDataLayout = new javax.swing.GroupLayout(panelData);
        panelData.setLayout(panelDataLayout);
        panelDataLayout.setHorizontalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDataLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelBasico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDataLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelDataLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelTrabajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDataLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );
        panelDataLayout.setVerticalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFolio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBasico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        statusBar.setForeground(new java.awt.Color(102, 102, 102));
        statusBar.setText("Listo.");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmp)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(statusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEmp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusBar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        reloadEmployees();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        EmpleadoController control = new EmpleadoController();
        Empleado empleado = (Empleado)listEmployees.getSelectedValue();
        listEmployees.setSelectedIndex(0);
        control.deleteEmpleado(empleado);
        reloadEmployees();        
    }//GEN-LAST:event_btnBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JLabel lblDepa;
    private javax.swing.JLabel lblDias;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmp;
    private javax.swing.JLabel lblFolio;
    private javax.swing.JLabel lblHoras;
    private javax.swing.JLabel lblIMSS;
    private javax.swing.JLabel lblIngreso;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNomina;
    private javax.swing.JLabel lblPuesto;
    private javax.swing.JLabel lblRFC;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JList listEmployees;
    private javax.swing.JPanel panelBasico;
    private javax.swing.JPanel panelData;
    private javax.swing.JPanel panelTrabajo;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel statusBar;
    // End of variables declaration//GEN-END:variables
}
