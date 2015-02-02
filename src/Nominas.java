import nominas.gui.AltaEmpleado;
import nominas.gui.LoginFrame;
import nominas.gui.MainWindow;

public class Nominas {

    public static void main(String[] args) throws InterruptedException {
        // Se configura Look and Feel con Nimbus
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //Muestra el formulario de identifiación
        LoginFrame login = new LoginFrame();
        java.awt.EventQueue.invokeLater(() -> {
            login.setVisible(true);
        });
        
        //Se pausa hasta que se hayan ingresado datos correctos
        while(login.isGuess){
            Thread.yield();
        }
        
        //Se oculta el formulario de identificaión
        login.setVisible(false);
        
        //Se muestra la ventana principal
        java.awt.EventQueue.invokeLater(() -> {
            new MainWindow().setVisible(true);
        });
    }
}
