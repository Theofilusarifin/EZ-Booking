package auth;

import customer.CustomerDashboard;
import restaurant.RestaurantDashboard;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginForm extends javax.swing.JFrame {

    Socket s;
    BufferedReader msgFromServer;
    DataOutputStream msgToServer;

    public LoginForm() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        try {
            s = new Socket("localhost", 6000);
            //buat penerima dan pengirim dari socket
            msgFromServer = new BufferedReader(new InputStreamReader(s.getInputStream()));
            msgToServer = new DataOutputStream(s.getOutputStream());
        } catch (Exception e) {
            System.out.println("Error LoginForm Constructor1, Error: " + e);
        }
    }

    public LoginForm(Socket clientSocket) {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        try {
            s = clientSocket;
            //buat penerima dan pengirim dari socket
            msgFromServer = new BufferedReader(new InputStreamReader(s.getInputStream()));
            msgToServer = new DataOutputStream(s.getOutputStream());
        } catch (Exception e) {
            System.out.println("Error LoginForm Constructor2, Error: " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        lblRegister = new javax.swing.JLabel();
        lblAccount = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);
        getContentPane().add(txtPassword);
        txtPassword.setBounds(80, 270, 310, 30);
        getContentPane().add(txtUsername);
        txtUsername.setBounds(80, 180, 310, 30);

        lblLogin.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setText("LOGIN");
        getContentPane().add(lblLogin);
        lblLogin.setBounds(190, 30, 80, 30);

        lblPassword.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Password");
        getContentPane().add(lblPassword);
        lblPassword.setBounds(80, 240, 90, 20);

        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(160, 380, 140, 30);

        lblUsername.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("Username");
        getContentPane().add(lblUsername);
        lblUsername.setBounds(80, 150, 90, 20);

        lblRegister.setForeground(new java.awt.Color(255, 255, 255));
        lblRegister.setText("Register Here");
        lblRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegisterMouseClicked(evt);
            }
        });
        getContentPane().add(lblRegister);
        lblRegister.setBounds(270, 430, 80, 14);

        lblAccount.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblAccount.setForeground(new java.awt.Color(255, 255, 255));
        lblAccount.setText("Don't have an account yet?");
        getContentPane().add(lblAccount);
        lblAccount.setBounds(120, 430, 160, 16);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auth/images/separator.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 70, 140, 10);

        lblBackground.setForeground(new java.awt.Color(255, 255, 255));
        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auth/images/backg.png"))); // NOI18N
        getContentPane().add(lblBackground);
        lblBackground.setBounds(10, 10, 450, 490);

        setSize(new java.awt.Dimension(470, 509));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try {
            // buat koneksi TCP ke server
            // kirim Request Data (LOGIN;;<username>;;<password>)
            msgToServer.writeBytes("LOGIN//" + txtUsername.getText() + ";-;" + txtPassword.getText() + "\n");

            String result;
            result = msgFromServer.readLine();

            String[] messages = null;
            messages = result.split(";-;");

            String cmd = "";
            cmd = messages[0];

            // kalau ada username yang sama
            if (cmd.equals("TRUE")) {
                msgToServer.writeBytes("ROLE//" + txtUsername.getText() + ";-;" + txtPassword.getText() + "\n");

                String answer = "";
                answer = msgFromServer.readLine();

                String[] words = null;
                words = answer.split(";-;");
                System.out.println(words);

                String word = "";
                word = words[0];

                // kalau role customer
                if (word.equals("customer")) {
                    new CustomerDashboard(words[1], words[2]).setVisible(true);
                    this.dispose();
                } // kalau role restaurant
                else if (word.equals("restaurant")) {
                    new RestaurantDashboard(words[1], words[2]).setVisible(true);
                    this.dispose();
                }
            } // kalau tidak ada username yang sama
            else if (cmd.equals("FALSE")) {
                JOptionPane.showMessageDialog(this, "Incorrect Username or Password");
            }

        } catch (Exception e) {
            System.out.println("LoginForm btnLogin, Error; " + e);
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMouseClicked
        String[] options = new String[2];
        options[0] = "customer";
        options[1] = "restaurant";
        int response = JOptionPane.showOptionDialog(this, "Register as?", "Choose Role", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
        if (response == 0) {
            new RegisterFormCustomer(s).setVisible(true);
            this.dispose();
        } else if (response == 1) {
            new RegisterFormOwner(s).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lblRegisterMouseClicked

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblAccount;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
