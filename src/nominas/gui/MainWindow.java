package nominas.gui;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MainWindow extends javax.swing.JFrame {

    public MainWindow() throws IOException {
        //this.setIconImage(ImageIO.read(new File("res/icon.png"))); Toolkit.getDefaultToolkit().getImage("Icon.png")
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("res/icon.png"));
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        menuVer = new javax.swing.JMenu();
        mGralStat = new javax.swing.JMenuItem();
        menuEmpleados = new javax.swing.JMenu();
        mViewEmployee = new javax.swing.JMenuItem();
        mAddEmployee = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        mModify = new javax.swing.JMenu();
        mModifyDepartment = new javax.swing.JMenuItem();
        mModifyPuesto = new javax.swing.JMenuItem();
        mModifyNominas = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Nominas");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("mainWindow"); // NOI18N

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 946, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );

        menuBar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        menuBar.setMaximumSize(new java.awt.Dimension(60, 32769));

        menuInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/icon_min.png"))); // NOI18N
        menuInicio.setText("Inicio");
        menuInicio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        menuBar.add(menuInicio);

        menuVer.setText("Ver");
        menuVer.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        mGralStat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/stat.png"))); // NOI18N
        mGralStat.setText("Estadisticas Generales");
        menuVer.add(mGralStat);

        menuBar.add(menuVer);

        menuEmpleados.setText("Empleados");

        mViewEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/view.png"))); // NOI18N
        mViewEmployee.setText("Lista de Empleados");
        mViewEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mViewEmployeeActionPerformed(evt);
            }
        });
        menuEmpleados.add(mViewEmployee);

        mAddEmployee.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mAddEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/add_.png"))); // NOI18N
        mAddEmployee.setText("Agregar Empleado");
        mAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAddEmployeeActionPerformed(evt);
            }
        });
        menuEmpleados.add(mAddEmployee);

        menuBar.add(menuEmpleados);

        menuReportes.setText("Reportes");
        menuBar.add(menuReportes);

        mModify.setText("Modificar");

        mModifyDepartment.setText("Departamentos");
        mModify.add(mModifyDepartment);

        mModifyPuesto.setText("Puestos");
        mModify.add(mModifyPuesto);

        mModifyNominas.setText("Nóminas");
        mModify.add(mModifyNominas);

        menuBar.add(mModify);

        menuAyuda.setText("Ayuda");

        jMenuItem2.setText("Acerca de...");
        menuAyuda.add(jMenuItem2);

        menuBar.add(menuAyuda);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAddEmployeeActionPerformed
        FormEmpleado f = new FormEmpleado();
        f.setVisible(true);
        desktopPane.add(f);
    }//GEN-LAST:event_mAddEmployeeActionPerformed

    private void mViewEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mViewEmployeeActionPerformed
        EmpleadosList e = new EmpleadosList();
        e.setVisible(true);
        desktopPane.add(e);
    }//GEN-LAST:event_mViewEmployeeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem mAddEmployee;
    private javax.swing.JMenuItem mGralStat;
    private javax.swing.JMenu mModify;
    private javax.swing.JMenuItem mModifyDepartment;
    private javax.swing.JMenuItem mModifyNominas;
    private javax.swing.JMenuItem mModifyPuesto;
    private javax.swing.JMenuItem mViewEmployee;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuEmpleados;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenu menuVer;
    // End of variables declaration//GEN-END:variables
}
