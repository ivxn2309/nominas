package nominas.gui;

import java.awt.Panel;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import nominas.control.StatController;
import org.jfree.chart.ChartPanel;

public class StatsViewer extends javax.swing.JInternalFrame {
    private StatController generator;
    public StatsViewer() {
        generator = new StatController();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolBar = new javax.swing.JToolBar();
        btnGeneralStat = new javax.swing.JButton();
        btnEmpStat = new javax.swing.JButton();
        btnEmpsStat = new javax.swing.JButton();
        btnNomStat = new javax.swing.JButton();
        btnDepaStat = new javax.swing.JButton();

        setClosable(true);
        setTitle("Estadisticas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/stat.png"))); // NOI18N

        toolBar.setFloatable(false);
        toolBar.setBorderPainted(false);

        btnGeneralStat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/stat.png"))); // NOI18N
        btnGeneralStat.setText("Generales");
        btnGeneralStat.setToolTipText("Ver estadísticas generales");
        btnGeneralStat.setFocusable(false);
        btnGeneralStat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGeneralStat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGeneralStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneralStatActionPerformed(evt);
            }
        });
        toolBar.add(btnGeneralStat);

        btnEmpStat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/view.png"))); // NOI18N
        btnEmpStat.setText("Empleado");
        btnEmpStat.setFocusable(false);
        btnEmpStat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmpStat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnEmpStat);

        btnEmpsStat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/users.png"))); // NOI18N
        btnEmpsStat.setText("Empleados");
        btnEmpsStat.setToolTipText("Ver estadísticas de empleados");
        btnEmpsStat.setFocusable(false);
        btnEmpsStat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmpsStat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnEmpsStat);

        btnNomStat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/money.png"))); // NOI18N
        btnNomStat.setText("Nominas");
        btnNomStat.setFocusable(false);
        btnNomStat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNomStat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnNomStat);

        btnDepaStat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/empresa.png"))); // NOI18N
        btnDepaStat.setText("Departamentos");
        btnDepaStat.setFocusable(false);
        btnDepaStat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDepaStat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnDepaStat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGeneralStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneralStatActionPerformed
        ChartPanel panel = generator.getGeneralStatGraphic();
        JInternalFrame graphicWindow = new JInternalFrame();
        graphicWindow.getContentPane().add(panel);
        graphicWindow.setClosable(true);
        graphicWindow.setResizable(true);
        graphicWindow.setTitle("Estadísticas Generales");
        graphicWindow.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/ico/stat.png")));
        graphicWindow.pack();
        graphicWindow.setVisible(true);
        this.getParent().add(graphicWindow);
        graphicWindow.moveToFront();
    }//GEN-LAST:event_btnGeneralStatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDepaStat;
    private javax.swing.JButton btnEmpStat;
    private javax.swing.JButton btnEmpsStat;
    private javax.swing.JButton btnGeneralStat;
    private javax.swing.JButton btnNomStat;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
