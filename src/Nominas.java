import nominas.gui.AltaEmpleado;
import nominas.gui.LoginFrame;
import nominas.gui.MainWindow;

public class Nominas {

    public static void main(String[] args) throws InterruptedException {
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
        
        LoginFrame login = new LoginFrame();
        java.awt.EventQueue.invokeLater(() -> {
            login.setVisible(true);
        });
        int i = 0;
        while(login.isGuess){
            Thread.sleep(1000);
        }
        login.setVisible(false);
        java.awt.EventQueue.invokeLater(() -> {
            new MainWindow().setVisible(true);
        });
        System.out.println("Ya entro");
    }
}
