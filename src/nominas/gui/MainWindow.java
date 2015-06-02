package nominas.gui;

import com.itextpdf.text.DocumentException;
import java.awt.Component;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import nominas.control.DeptoController;
import nominas.control.EmpleadoController;
import nominas.control.InstitucionController;
import nominas.control.ListaNominaController;
import nominas.control.PDFController;
import nominas.control.PuestoController;
import nominas.entity.Departamento;
import nominas.entity.Empleado;
import nominas.entity.ListaNomina;
import nominas.entity.Puesto;
import nominas.util.BackImage;

public class MainWindow extends javax.swing.JFrame {
    public String usr;
    public MainWindow(String usr) throws IOException {
        try {
            this.usr = usr;
            //Se comprueba que se puedan obtener datos de la base de  datos
            List<Empleado> lista = new EmpleadoController().getAllEmpleados();
            //Se inicializan los componentes
            this.setIconImage(Toolkit.getDefaultToolkit().getImage("res/icon.png"));
            initComponents();
            desktopPane.setBorder(new BackImage());
            this.setExtendedState(MainWindow.MAXIMIZED_BOTH);
            this.setTitle("Sistema de Nominas ("+new InstitucionController().get().getName()+")");
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
        m = new javax.swing.JMenuItem();
        mExit = new javax.swing.JMenuItem();
        menuVer = new javax.swing.JMenu();
        mStat = new javax.swing.JMenuItem();
        menuGenerar = new javax.swing.JMenu();
        mListaRaya = new javax.swing.JMenuItem();
        menuReciboDeNominas = new javax.swing.JMenu();
        mReciboUnico = new javax.swing.JMenuItem();
        mReciboPorNomina = new javax.swing.JMenuItem();
        mReciboGlobal = new javax.swing.JMenuItem();
        menuEmpleados = new javax.swing.JMenu();
        mViewEmployee = new javax.swing.JMenuItem();
        mAddEmployee = new javax.swing.JMenuItem();
        mModify = new javax.swing.JMenu();
        menuInst = new javax.swing.JMenuItem();
        mModifyDepartment = new javax.swing.JMenuItem();
        mModifyPuesto = new javax.swing.JMenuItem();
        mModifyNominas = new javax.swing.JMenuItem();
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
            .addGap(0, 537, Short.MAX_VALUE)
        );

        menuBar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        menuBar.setMaximumSize(new java.awt.Dimension(60, 32769));

        menuInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/arrow.png"))); // NOI18N
        menuInicio.setText("Inicio");
        menuInicio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        m.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        m.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/edit.png"))); // NOI18N
        m.setText("Editar Perfil");
        m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mActionPerformed(evt);
            }
        });
        menuInicio.add(m);

        mExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/off.png"))); // NOI18N
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

        mStat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mStat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/stat.png"))); // NOI18N
        mStat.setText("Estadisticas Gráficas");
        mStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mStatActionPerformed(evt);
            }
        });
        menuVer.add(mStat);

        menuBar.add(menuVer);

        menuGenerar.setText("Generar");

        mListaRaya.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mListaRaya.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/lista.png"))); // NOI18N
        mListaRaya.setText("Listas de Raya");
        mListaRaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mListaRayaActionPerformed(evt);
            }
        });
        menuGenerar.add(mListaRaya);

        menuReciboDeNominas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/tabla.png"))); // NOI18N
        menuReciboDeNominas.setText("Recibos de Nomina");

        mReciboUnico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
        mReciboUnico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/view.png"))); // NOI18N
        mReciboUnico.setText("Empleado");
        mReciboUnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mReciboUnicoActionPerformed(evt);
            }
        });
        menuReciboDeNominas.add(mReciboUnico);

        mReciboPorNomina.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK));
        mReciboPorNomina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/group-users.png"))); // NOI18N
        mReciboPorNomina.setText("Nomina");
        mReciboPorNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mReciboPorNominaActionPerformed(evt);
            }
        });
        menuReciboDeNominas.add(mReciboPorNomina);

        mReciboGlobal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.SHIFT_MASK));
        mReciboGlobal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/users2.png"))); // NOI18N
        mReciboGlobal.setText("Global");
        mReciboGlobal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mReciboGlobalActionPerformed(evt);
            }
        });
        menuReciboDeNominas.add(mReciboGlobal);

        menuGenerar.add(menuReciboDeNominas);

        menuBar.add(menuGenerar);

        menuEmpleados.setText("Empleados");

        mViewEmployee.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
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

        menuInst.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        menuInst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/empresa.png"))); // NOI18N
        menuInst.setText("Empresa");
        menuInst.setToolTipText("Cambia los daos básicos de la empresa que usa este software");
        menuInst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInstActionPerformed(evt);
            }
        });
        mModify.add(menuInst);

        mModifyDepartment.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        mModifyDepartment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/department.png"))); // NOI18N
        mModifyDepartment.setText("Departamentos");
        mModifyDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mModifyDepartmentActionPerformed(evt);
            }
        });
        mModify.add(mModifyDepartment);

        mModifyPuesto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mModifyPuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/chair.png"))); // NOI18N
        mModifyPuesto.setText("Puestos");
        mModifyPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mModifyPuestoActionPerformed(evt);
            }
        });
        mModify.add(mModifyPuesto);

        mModifyNominas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mModifyNominas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/money.png"))); // NOI18N
        mModifyNominas.setText("Nóminas");
        mModifyNominas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mModifyNominasActionPerformed(evt);
            }
        });
        mModify.add(mModifyNominas);

        menuBar.add(mModify);

        menuAyuda.setText("Ayuda");

        mAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
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
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAddEmployeeActionPerformed
        FormEmpleado employeeForm = new FormEmpleado();
        employeeForm.setVisible(true);
        desktopPane.add(employeeForm);
        employeeForm.moveToFront();
    }//GEN-LAST:event_mAddEmployeeActionPerformed

    private void mViewEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mViewEmployeeActionPerformed
        EmpleadosList employeeList = new EmpleadosList(this);
        employeeList.setVisible(true);
        desktopPane.add(employeeList);
        employeeList.moveToFront();
    }//GEN-LAST:event_mViewEmployeeActionPerformed

    private void mAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAboutActionPerformed
        About about = new About();
        about.setVisible(true);
        desktopPane.add(about);
        about.moveToFront();
    }//GEN-LAST:event_mAboutActionPerformed

    private void mExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mExitActionPerformed

    private void mModifyDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mModifyDepartmentActionPerformed
        List<Departamento> lista = new DeptoController().getAllDepartamentos();
        ComponentModifier compModifierGUI = new ComponentModifier(lista, "Lista de Departamentos");
        compModifierGUI.setVisible(true);
        desktopPane.add(compModifierGUI);
        compModifierGUI.moveToFront();
    }//GEN-LAST:event_mModifyDepartmentActionPerformed

    private void mModifyPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mModifyPuestoActionPerformed
        List<Puesto> lista = new PuestoController().getAllPuestos();
        ComponentModifier compModifierGUI = new ComponentModifier(lista, "Lista de Puestos");
        compModifierGUI.setVisible(true);
        desktopPane.add(compModifierGUI);
        compModifierGUI.moveToFront();
    }//GEN-LAST:event_mModifyPuestoActionPerformed

    private void mModifyNominasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mModifyNominasActionPerformed
        List<ListaNomina> lista = new ListaNominaController().getAllTypesOfNomina();
        ComponentModifier compModifierGUI = new ComponentModifier(lista, "Lista de Nominas");
        compModifierGUI.setVisible(true);
        desktopPane.add(compModifierGUI);
        compModifierGUI.moveToFront();
    }//GEN-LAST:event_mModifyNominasActionPerformed

    private void mStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mStatActionPerformed
        StatsViewer viewer = new StatsViewer(desktopPane);
        viewer.setVisible(true);
        desktopPane.add(viewer);
        viewer.moveToFront();
    }//GEN-LAST:event_mStatActionPerformed

    private void mListaRayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mListaRayaActionPerformed
        RayaNominaSelector nomS = new RayaNominaSelector();
        nomS.setVisible(true);
        boolean flag = true;
        for(Component com : desktopPane.getComponents()){
            if(com.getName().equalsIgnoreCase("RayaNominaSelector")){
                flag = false;
                break;
            }
        }
        if(flag)
            desktopPane.add("RayaNominaSelector", nomS);
    }//GEN-LAST:event_mListaRayaActionPerformed

    private void mReciboGlobalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mReciboGlobalActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Recibos de todas las Nominas");
        int status = fileChooser.showSaveDialog(this);
        
        File file = fileChooser.getSelectedFile(); 
        if(status == JFileChooser.APPROVE_OPTION){
            String filename = file.toString();
            if(!filename.endsWith(".pdf"))
                filename = filename.concat(".pdf");
            PDFController generator = new PDFController(filename);
            try {
                generator.createPdf(PDFController.RECIBO_DE_NOMINA);
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
    }//GEN-LAST:event_mReciboGlobalActionPerformed

    private void mReciboPorNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mReciboPorNominaActionPerformed
        NominaSelector nomS = new NominaSelector();
        nomS.setVisible(true);
        boolean flag = true;
        for(Component com : desktopPane.getComponents()){
            if(com.getName().equalsIgnoreCase("NominaSelector")){
                flag = false;
                break;
            }
        }
        if(flag)
            desktopPane.add("NominaSelector", nomS);
    }//GEN-LAST:event_mReciboPorNominaActionPerformed

    private void mReciboUnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mReciboUnicoActionPerformed
        EmpleadoSelector empS = new EmpleadoSelector();
        empS.setVisible(true);
        boolean flag = true;
        for(Component com : desktopPane.getComponents()){
            if(com.getName().equalsIgnoreCase("EmpleadoSelector")){
                flag = false;
                break;
            }
        }
        if(flag)
            desktopPane.add("EmpleadoSelector", empS);
    }//GEN-LAST:event_mReciboUnicoActionPerformed

    private void menuInstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInstActionPerformed
        InstModifier mod = new InstModifier();
        mod.setVisible(true);
        boolean flag = true;
        for(Component com : desktopPane.getComponents()){
            if(com.getName().equalsIgnoreCase("InstModifier")){
                flag = false;
                break;
            }
        }
        if(flag)
            desktopPane.add("InstModifier", mod);
    }//GEN-LAST:event_menuInstActionPerformed

    private void mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mActionPerformed
        IDModifier idm = new IDModifier(usr);
        idm.setVisible(true);
        idm.setName("idm");
        for(Component com : desktopPane.getComponents()){
            if(com.getName().equalsIgnoreCase("idm")){
                return;
            }
        }
        desktopPane.add(idm);
        idm.moveToFront();
    }//GEN-LAST:event_mActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem m;
    private javax.swing.JMenuItem mAbout;
    private javax.swing.JMenuItem mAddEmployee;
    private javax.swing.JMenuItem mExit;
    private javax.swing.JMenuItem mListaRaya;
    private javax.swing.JMenu mModify;
    private javax.swing.JMenuItem mModifyDepartment;
    private javax.swing.JMenuItem mModifyNominas;
    private javax.swing.JMenuItem mModifyPuesto;
    private javax.swing.JMenuItem mReciboGlobal;
    private javax.swing.JMenuItem mReciboPorNomina;
    private javax.swing.JMenuItem mReciboUnico;
    private javax.swing.JMenuItem mStat;
    private javax.swing.JMenuItem mViewEmployee;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuEmpleados;
    private javax.swing.JMenu menuGenerar;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenuItem menuInst;
    private javax.swing.JMenu menuReciboDeNominas;
    private javax.swing.JMenu menuVer;
    // End of variables declaration//GEN-END:variables
}
