package nominas.gui;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import nominas.control.DeptoController;
import nominas.control.ListaNominaController;
import nominas.control.PuestoController;
import nominas.entity.Departamento;
import nominas.entity.Empleado;
import nominas.entity.ListaNomina;
import nominas.entity.Puesto;
import nominas.util.HibernateUtil;

public class ComponentModifier extends javax.swing.JInternalFrame {
    
    public ComponentModifier(List objs, String title) {
        initComponents();
        listComponents.addListSelectionListener(getListListener());
        listComponents.setListData(objs.toArray());
        this.setTitle(title);
        btnDelete.setEnabled(false);
        btnRename.setEnabled(false);
    }
    
    private ListSelectionListener getListListener(){
        ListSelectionListener listener = (ListSelectionEvent e) -> {
            if(listComponents.isSelectionEmpty()){
                btnDelete.setEnabled(false);
                btnRename.setEnabled(false);
            }
            else {
                btnDelete.setEnabled(true);
                btnRename.setEnabled(true);
            }
        };
        return listener;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        listComponents = new javax.swing.JList();
        btnDelete = new javax.swing.JButton();
        btnRename = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setClosable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/settings.png"))); // NOI18N

        listComponents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(listComponents);

        btnDelete.setText("Borrar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRename.setText("Renombrar");
        btnRename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenameActionPerformed(evt);
            }
        });

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
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
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRename, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnRename, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int ans = JOptionPane.showConfirmDialog(this, "Estas seguro de borrar", "Confirma", 2, 1);
        if(ans == 0){
            Object obj = listComponents.getSelectedValue();
            HibernateUtil.removeObject(obj);
            List list = null;
            if(obj.getClass().getSimpleName().equals("Departamento"))
                list = new DeptoController().getAllDepartamentos();
            else if(obj.getClass().getSimpleName().equals("Puesto"))
                list = new PuestoController().getAllPuestos();
            else if(obj.getClass().getSimpleName().equals("ListaNomina"))
                list = new ListaNominaController().getAllTypesOfNomina();
            listComponents.setListData(list.toArray());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenameActionPerformed
        Object obj = listComponents.getSelectedValue();
        String name = JOptionPane.showInputDialog(this, "Ingresa el nuevo nombre para este componente", 
                obj.toString());
        List list = null;
        if(name == null);
        else if(name.length() < 3) JOptionPane.showMessageDialog(this, 
                "El valor ingresado es demasiado corto", "Nombre inválido", 0);        
        else if(obj.getClass().getSimpleName().equals("Departamento")){
            Departamento dpto = (Departamento)obj;
            dpto.setNombre(name);
            new DeptoController().updateDepartamento(dpto);
            list = new DeptoController().getAllDepartamentos();
        }
        else if(obj.getClass().getSimpleName().equals("Puesto")){
            Puesto puesto = (Puesto)obj;
            puesto.setNombre(name);
            new PuestoController().updatePuesto(puesto);
            list = new PuestoController().getAllPuestos();
        }
        else if(obj.getClass().getSimpleName().equals("ListaNomina")){
            ListaNomina nomina = (ListaNomina)obj;
            nomina.setNombre(name);
            new ListaNominaController().updateNomina(nomina);
            list = new ListaNominaController().getAllTypesOfNomina();
        }
        if(list != null)
            listComponents.setListData(list.toArray());
    }//GEN-LAST:event_btnRenameActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        List list = null;
        String name = JOptionPane.showInputDialog(this, "Ingresa el nuevo nombre para este componente", "");
        //Se obtiene el objeto seleccionado para ver si es Departamento, Puesto o Nomina
        listComponents.setSelectedIndex(listComponents.getFirstVisibleIndex());
        Object obj = null;
        if(!listComponents.isSelectionEmpty())
            obj = listComponents.getSelectedValue();
        //Se valida el nuevo nombre
        if(name == null || obj == null);
        else if(name.length() < 3) JOptionPane.showMessageDialog(this, 
            "El valor ingresado es demasiado corto", "Nombre inválido", 0);
        //Se verifica de que clase es y se cre el objeto nuevo
        else if(obj.getClass().getSimpleName().equals("Departamento")){
            Departamento dpto = new Departamento();
            dpto.setNombre(name);
            new DeptoController().saveNewDepartamento(dpto);
            list = new DeptoController().getAllDepartamentos();
        }
        else if(obj.getClass().getSimpleName().equals("Puesto")){
            Puesto puesto = new Puesto();
            puesto.setNombre(name);
            new PuestoController().saveNewPuesto(puesto);
            list = new PuestoController().getAllPuestos();
        }
        else if(obj.getClass().getSimpleName().equals("ListaNomina")){
            ListaNomina nomina = new ListaNomina();
            nomina.setNombre(name);
            new ListaNominaController().saveNewNomina(nomina);
            list = new ListaNominaController().getAllTypesOfNomina();
        }
        if(list != null){
            listComponents.setListData(list.toArray());
            listComponents.setSelectedIndex(list.size()-1);
        }
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRename;
    private javax.swing.JList listComponents;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
