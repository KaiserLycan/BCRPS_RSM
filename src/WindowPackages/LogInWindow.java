/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package WindowPackages;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import User.Admin;
import User.FileManager;
import User.Login;
import User.User;
/**
 *
 * @author Dinel
 */
public class LogInWindow extends javax.swing.JFrame {
    File userFile = new File("./src/TextFiles/users.txt");
    Admin master = new Admin("master", "master");
    Login logger;
        
    
    /**
     * Creates new form LogInWindow
     */
    public LogInWindow() {
        
        master.setUserFm(new FileManager(userFile));
        master.refreshUsers();
        logger = new Login(master);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        LogIn = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        usernameInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordInput = new JPasswordField();
        loginButton = new javax.swing.JButton();
        jLabel1_Image = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Design2 = new javax.swing.JLabel();
        Design1 = new javax.swing.JLabel();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1536, 864);
        getContentPane().setLayout(null);

        LogIn.setAlignmentX(0.0F);
        LogIn.setAlignmentY(0.0F);
        LogIn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LogIn.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        LogIn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        LogIn.setOpaque(false);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Username");
        jLabel3.setAutoscrolls(true);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Password");

        loginButton.setBackground(new java.awt.Color(0, 0, 0));
        loginButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Log In");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LogInLayout = new javax.swing.GroupLayout(LogIn);
        LogIn.setLayout(LogInLayout);
        LogInLayout.setHorizontalGroup(
            LogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogInLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordInput)
                    .addGroup(LogInLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(loginButton))
                    .addComponent(usernameInput)
                    .addGroup(LogInLayout.createSequentialGroup()
                        .addGroup(LogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 294, Short.MAX_VALUE)))
                .addContainerGap())
        );
        LogInLayout.setVerticalGroup(
            LogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogInLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginButton)
                .addContainerGap())
        );

        getContentPane().add(LogIn);
        LogIn.setBounds(570, 430, 400, 180);
        LogIn.getAccessibleContext().setAccessibleDescription("");

        jLabel1_Image.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1_Image.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel1_Image.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1_Image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1_Image.setIcon(new javax.swing.ImageIcon (new javax.swing.ImageIcon(getClass().getResource("/Images/bilog.gif")).getImage().getScaledInstance(375, 250, Image.SCALE_DEFAULT)));
        jLabel1_Image.setDoubleBuffered(true);
        jLabel1_Image.setName(""); // NOI18N
        getContentPane().add(jLabel1_Image);
        jLabel1_Image.setBounds(650, 170, 240, 250);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LogInBg.png"))); // NOI18N
        jLabel1.setText("Hello");
        jLabel1.setMaximumSize(new java.awt.Dimension(1536, 864));
        jLabel1.setMinimumSize(new java.awt.Dimension(1536, 864));
        jLabel1.setPreferredSize(new java.awt.Dimension(1536, 864));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1530, 864);

        jLabel10.setBackground(new java.awt.Color(51, 0, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("LOGO");
        jLabel10.setOpaque(true);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 0, 70, 33);

        Design2.setBackground(new java.awt.Color(209, 200, 185));
        Design2.setForeground(new java.awt.Color(153, 255, 255));
        Design2.setOpaque(true);
        getContentPane().add(Design2);
        Design2.setBounds(0, 0, 0, 0);

        Design1.setBackground(new java.awt.Color(255, 101, 0));
        Design1.setForeground(new java.awt.Color(153, 255, 255));
        Design1.setOpaque(true);
        getContentPane().add(Design1);
        Design1.setBounds(0, 0, 0, 0);
    }// </editor-fold>//GEN-END:initComponents

    /*FACTORY DIAGRAM **APPLICABLE HEHE*/
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        String username = usernameInput.getText();
        String password = passwordInput.getText();


        User user = logger.login(username, password);

    if (user != null){
        JOptionPane.showMessageDialog(this, username + " Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        
        if(user.getType().equals("admin")) {
            AdminWindow adWindow = new AdminWindow();
            adWindow.setVisible(true);
            this.dispose();

        }
        else if(user.getType().equals("client")) {
            ClientWindow2 clWindow = new ClientWindow2();
            System.out.println("Passed");
            clWindow.setVisible(true);
            this.dispose();
        }

    } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Invalid Username or Password! Would you like to try again?", "Login Failed", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.NO_OPTION) {
            System.out.println("User logged out.");
            System.exit(0); // Closes the application
            }
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Design1;
    private javax.swing.JLabel Design2;
    private javax.swing.JPanel LogIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel1_Image;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginButton;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JTextField passwordInput;
    private javax.swing.JTextField usernameInput;
    // End of variables declaration//GEN-END:variables
}
