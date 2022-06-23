package auth;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RegisterFormCustomer extends javax.swing.JFrame {

    BufferedReader msgFromServer;
    DataOutputStream msgToServer;

    public RegisterFormCustomer() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);
        try {
            //buat penerima dan pengirim dari socket
            msgFromServer = new BufferedReader(new InputStreamReader(LoginForm.s.getInputStream()));
            msgToServer = new DataOutputStream(LoginForm.s.getOutputStream());
        } catch (Exception ex) {
            System.out.println("FormRegisterCustomer Constructor, Error: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRegister = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblRePassword = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtRePassword = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        lblBackToLogin = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(430, 520));
        setSize(new java.awt.Dimension(450, 520));
        getContentPane().setLayout(null);

        lblRegister.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblRegister.setForeground(new java.awt.Color(255, 255, 255));
        lblRegister.setText("REGISTER");
        getContentPane().add(lblRegister);
        lblRegister.setBounds(160, 20, 134, 32);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 70, 51, 24);

        lblUsername.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("Username");
        getContentPane().add(lblUsername);
        lblUsername.setBounds(50, 150, 90, 24);

        lblPassword.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Password");
        getContentPane().add(lblPassword);
        lblPassword.setBounds(50, 230, 100, 24);

        lblRePassword.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblRePassword.setForeground(new java.awt.Color(255, 255, 255));
        lblRePassword.setText("Re-type Password");
        getContentPane().add(lblRePassword);
        lblRePassword.setBounds(50, 320, 160, 24);

        txtName.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        getContentPane().add(txtName);
        txtName.setBounds(50, 100, 330, 30);

        txtUsername.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        getContentPane().add(txtUsername);
        txtUsername.setBounds(50, 180, 330, 30);

        txtPassword.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        getContentPane().add(txtPassword);
        txtPassword.setBounds(50, 260, 330, 30);

        txtRePassword.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        getContentPane().add(txtRePassword);
        txtRePassword.setBounds(50, 350, 330, 30);

        btnRegister.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRegister.setText("REGISTER");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegister);
        btnRegister.setBounds(230, 420, 150, 38);

        lblBackToLogin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblBackToLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblBackToLogin.setText("Back To Login");
        lblBackToLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBackToLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackToLoginMouseClicked(evt);
            }
        });
        getContentPane().add(lblBackToLogin);
        lblBackToLogin.setBounds(50, 420, 100, 34);

        lblBackground.setForeground(new java.awt.Color(255, 255, 255));
        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auth/images/backg.png"))); // NOI18N
        lblBackground.setPreferredSize(new java.awt.Dimension(430, 520));
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, 0, 450, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        try {
            if (txtPassword.getText().equals(txtRePassword.getText())) {
                // kirim Request Data (REGISTER <username> <password> <role>)
                msgToServer.writeBytes("REGISTER//" + txtName.getText() + ";-;" + txtUsername.getText() + ";-;" + txtPassword.getText() + ";-;customer" + "\n");

                String result;
                result = msgFromServer.readLine();

                String[] messages = null;
                messages = result.split(";-;");

                String status = "";
                status = messages[0];

                if (status.equals("RegSuccess")) {
                    JOptionPane.showMessageDialog(this, "Registration Successful, Welcome to ezbooking " + messages[1]);
                } else if (status.equals("RegFailed")) {
                    JOptionPane.showMessageDialog(this, "Sorry " + messages[1] + ", Your Registration Failed, Your username has been taken.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Your passwords are not the same!!");
            }
        } catch (Exception e) {
            System.out.println("RegisterForm btnRegister, Error; " + e);
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void lblBackToLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackToLoginMouseClicked
        new LoginForm(LoginForm.s).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblBackToLoginMouseClicked

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(RegisterFormCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RegisterFormCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RegisterFormCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RegisterFormCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RegisterFormCustomer().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBackToLogin;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRePassword;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtRePassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
