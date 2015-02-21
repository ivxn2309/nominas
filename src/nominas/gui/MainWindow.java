package nominas.gui;

import java.awt.Toolkit;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import nominas.control.EmpleadoController;
import nominas.entity.Empleado;

public class MainWindow extends javax.swing.JFrame {

    public MainWindow() throws IOException {
        try {
            //Se comprueba que se puedan obtener datos de la base de  datos
            List<Empleado> lista = new EmpleadoController().getAllEmpleados();
            //Se inicializan los componentes
            this.setIconImage(Toolkit.getDefaultToolkit().getImage("res/icon.png"));
            initComponents();
        }
        catch(ExceptionInInitializerError eie){
            //Si no se pudo obtener acceso a la base de datos se manda un aviso
            JOptionPane.showMessageDialog(null, "No se pudo encontrar la base de datos", 
                    "Error en la conexion con BD", 2);
            //Y se termina la ejecucion
            System.exit(1);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        mExit = new javax.swing.JMenuItem();
        menuVer = new javax.swing.JMenu();
        mGralStat = new javax.swing.JMenuItem();
        menuEmpleados = new javax.swing.JMenu();
        mViewEmployee = new javax.swing.JMenuItem();
        mAddEmployee = new javax.swing.JMenuItem();
        mModify = new javax.swing.JMenu();
        mModifyDepartment = new javax.swing.JMenuItem();
        mModifyPuesto = new javax.swing.JMenuItem();
        mModifyNominas = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        menuAyuda = new javax.swing.JMenu();
        mAbout = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Nominas");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("mainWindow"); // NOI18N

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1082, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );

        menuBar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        menuBar.setMaximumSize(new java.awt.Dimension(60, 32769));

        menuInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/icon_min.png"))); // NOI18N
        menuInicio.setText("Inicio");
        menuInicio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        mExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/exit.png"))); // NOI18N
        mExit.setText("Salir");
        mExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mExitActionPerformed(evt);
            }
        });
        menuInicio.add(mExit);

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

        mModify.setText("Administrar");

        mModifyDepartment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/department.png"))); // NOI18N
        mModifyDepartment.setText("Departamentos");
        mModify.add(mModifyDepartment);

        mModifyPuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/puesto.png"))); // NOI18N
        mModifyPuesto.setText("Puestos");
        mModify.add(mModifyPuesto);

        mModifyNominas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/coins.png"))); // NOI18N
        mModifyNominas.setText("Nóminas");
        mModify.add(mModifyNominas);

        menuBar.add(mModify);

        menuReportes.setText("Reportes");
        menuBar.add(menuReportes);

        menuAyuda.setText("Ayuda");

        mAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/info.png"))); // NOI18N
        mAbout.setText("Acerca de...");
        mAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAboutActionPerformed(evt);
            }
        });
        menuAyuda.add(mAbout);

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
        f.moveToFront();
    }//GEN-LAST:event_mAddEmployeeActionPerformed

    private void mViewEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mViewEmployeeActionPerformed
        EmpleadosList e = new EmpleadosList(this);
        e.setVisible(true);
        desktopPane.add(e);
        e.moveToFront();
    }//GEN-LAST:event_mViewEmployeeActionPerformed

    private void mAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAboutActionPerformed
        About a = new About();
        a.setVisible(true);
        desktopPane.add(a);
        a.moveToFront();
    }//GEN-LAST:event_mAboutActionPerformed

    private void mExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem mAbout;
    private javax.swing.JMenuItem mAddEmployee;
    private javax.swing.JMenuItem mExit;
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
