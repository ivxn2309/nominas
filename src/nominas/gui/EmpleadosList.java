/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nominas.gui;

import java.util.List;
import nominas.control.EmpleadoController;
import nominas.entity.Empleado;

/**
 *
 * @author Ivan Tovar
 */
public class EmpleadosList extends javax.swing.JInternalFrame {

    public EmpleadosList() {
        initComponents();
        reloadEmployees();
    }
    
    private void reloadEmployees(){
        List<Empleado> lista = new EmpleadoController().getAllEmpleados();
        System.out.println(lista);
        listEmployees.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return lista.size(); }
            public Object getElementAt(int i) { return lista.get(i); }
        });
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusBar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
