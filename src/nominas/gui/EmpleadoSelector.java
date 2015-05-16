package nominas.gui;

import com.itextpdf.text.DocumentException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import nominas.control.EmpleadoController;
import nominas.control.ListaNominaController;
import nominas.control.PDFController;
import nominas.control.StatController;
import nominas.entity.Empleado;
import nominas.entity.ListaNomina;
import org.jfree.chart.ChartPanel;

public class EmpleadoSelector extends javax.swing.JInternalFrame {
    private boolean graphics;
    public EmpleadoSelector() {
        initComponents();
        new ListaNominaController().getAllTypesOfNomina().stream().forEach((nom) -> {
            nominasBox.addItem(nom);
        });
        
        ListaNomina nomina = (ListaNomina)nominasBox.getSelectedItem();
        List<Empleado> empleados = new EmpleadoController().getAllActualEmpleados();
        List<Empleado> emps = new ArrayList<>();
        empleados.stream().filter((emp) -> (emp.getNomina() == nomina.getId())).forEach((emp) -> {
            emps.add(emp);
        });
        empList.setListData(emps.toArray());
        
        generateButton.setEnabled(false);
        graphics = false;
    }
    
    public EmpleadoSelector(String tite) {
        initComponents();
        new ListaNominaController().getAllTypesOfNomina().stream().forEach((nom) -> {
            nominasBox.addItem(nom);
        });
        
        ListaNomina nomina = (ListaNomina)nominasBox.getSelectedItem();
        List<Empleado> empleados = new EmpleadoController().getAllActualEmpleados();
        List<Empleado> emps = new ArrayList<>();
        empleados.stream().filter((emp) -> (emp.getNomina() == nomina.getId())).forEach((emp) -> {
            emps.add(emp);
        });
        empList.setListData(emps.toArray());
        
        generateButton.setEnabled(false);
        this.setTitle(title);
        graphics = true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nominasBox = new javax.swing.JComboBox();
        labelInst = new javax.swing.JLabel();
        toolBar = new javax.swing.JToolBar();
        generateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        empList = new javax.swing.JList();
        labelInst1 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Recibos por Empleado");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/view.png"))); // NOI18N

        nominasBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nominasBoxItemStateChanged(evt);
            }
        });
        nominasBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nominasBoxActionPerformed(evt);
            }
        });

        labelInst.setText("Elige la nomina:");

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

        empList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                empListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(empList);

        labelInst1.setText("Elige el(los) usuario(s) para generar su recibo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelInst, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nominasBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelInst1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelInst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nominasBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelInst1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        List<Empleado> sel = empList.getSelectedValuesList();
        if(graphics) {
            ChartPanel panel = new StatController().getEmployeeStatGraphic(sel);
            createGraphicWindow(panel);
            return;
        }
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Recibos de Empleados");
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

    private void empListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_empListValueChanged
        if(empList.isSelectionEmpty())
            generateButton.setEnabled(false);
        else
            generateButton.setEnabled(true);
    }//GEN-LAST:event_empListValueChanged

    private void nominasBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nominasBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nominasBoxActionPerformed

    private void nominasBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nominasBoxItemStateChanged
        ListaNomina nomina = (ListaNomina)nominasBox.getSelectedItem();
        List<Empleado> empleados = new EmpleadoController().getAllActualEmpleados();
        List<Empleado> emps = new ArrayList<>();
        empleados.stream().filter((emp) -> (emp.getNomina() == nomina.getId())).forEach((emp) -> {
            emps.add(emp);
        });
        empList.setListData(emps.toArray());
    }//GEN-LAST:event_nominasBoxItemStateChanged


    private void createGraphicWindow(ChartPanel panel) {
        JInternalFrame graphicWindow = new JInternalFrame();
        graphicWindow.getContentPane().add(panel);
        graphicWindow.setClosable(true);
        graphicWindow.setMaximizable(true);
        graphicWindow.setResizable(true);
        graphicWindow.setTitle("Estadísticas Gráficas");
        graphicWindow.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/stat.png")));
        graphicWindow.pack();
        graphicWindow.setVisible(true);
        this.getParent().add(graphicWindow);
        graphicWindow.moveToFront();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList empList;
    private javax.swing.JButton generateButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelInst;
    private javax.swing.JLabel labelInst1;
    private javax.swing.JComboBox nominasBox;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
