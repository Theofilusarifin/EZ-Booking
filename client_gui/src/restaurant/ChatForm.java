package restaurant;

import auth.LoginForm;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ChatForm extends javax.swing.JFrame {

    BufferedReader in;
    DataOutputStream out;
    String message;
    ArrayList<String> ids;
    ArrayList<String> names;

    public ChatForm() {
        try {
            initComponents();

            this.setLocationRelativeTo(null);
            in = new BufferedReader(new InputStreamReader(LoginForm.s.getInputStream()));
            out = new DataOutputStream(LoginForm.s.getOutputStream());

            out.writeBytes("DATACUSTOMER//" + " " + "\n");
            String response = in.readLine();
            String[] responses = response.split(";");
            ids = new ArrayList<String>();
            names = new ArrayList<String>();

            for (int i = 0; i < responses.length; i++) {
//                Tambahkan id ke arraylist
                ids.add(responses[i].split("&")[0]);
//                Tambahkan name ke arraylist
                String _name = responses[i].split("&")[1];
                names.add(_name);
//                Tambahkan name ke combobox
                cbCustomer.addItem(_name);
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refreshChat() {
        try {
//        Pastikan Restaurant tidak kosong
            if (cbCustomer.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Please choose a customer", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            txtAreaChat.setText("");

//        User ID
            int user_id = Integer.parseInt(ids.get(cbCustomer.getSelectedIndex()));

            out.writeBytes("GETCHAT//" + user_id + "\n");

            String result = in.readLine();

            if (!result.equals("")) {
                String[] responses = result.split(";--;");

                for (int i = 0; i < responses.length; i++) {
                    String[] response = responses[i].split(";-;");
                    txtAreaChat.append(response[1] + "\n");
                    txtAreaChat.append(response[2] + ": " + response[0] + "\n");
                    txtAreaChat.append("\n");
                }
            } else {
                JOptionPane.showMessageDialog(this, "There is no chat available", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRefresh = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnSend = new javax.swing.JButton();
        txtMessage = new javax.swing.JTextField();
        btnCall = new javax.swing.JButton();
        cbCustomer = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnRefresh1 = new javax.swing.JButton();
        btnVideo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaChat = new javax.swing.JTextArea();

        btnRefresh.setText("Resfresh");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(2, 26, 74));

        btnSend.setBackground(new java.awt.Color(2, 26, 74));
        btnSend.setForeground(new java.awt.Color(51, 51, 51));
        btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/send.png"))); // NOI18N
        btnSend.setBorderPainted(false);
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        txtMessage.setBackground(new java.awt.Color(242, 242, 242));
        txtMessage.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        btnCall.setBackground(new java.awt.Color(2, 26, 74));
        btnCall.setForeground(new java.awt.Color(51, 51, 51));
        btnCall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/call.png"))); // NOI18N
        btnCall.setBorderPainted(false);
        btnCall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCallActionPerformed(evt);
            }
        });

        cbCustomer.setBackground(new java.awt.Color(242, 242, 242));
        cbCustomer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCustomerActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Customer");

        btnRefresh1.setBackground(new java.awt.Color(2, 26, 74));
        btnRefresh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/refresh.png"))); // NOI18N
        btnRefresh1.setBorderPainted(false);
        btnRefresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh1ActionPerformed(evt);
            }
        });

        btnVideo.setBackground(new java.awt.Color(2, 26, 74));
        btnVideo.setForeground(new java.awt.Color(51, 51, 51));
        btnVideo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/videocall.png"))); // NOI18N
        btnVideo.setBorderPainted(false);
        btnVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVideoActionPerformed(evt);
            }
        });

        txtAreaChat.setColumns(20);
        txtAreaChat.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtAreaChat.setRows(5);
        jScrollPane1.setViewportView(txtAreaChat);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(26, 26, 26)
                        .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVideo)
                        .addGap(12, 12, 12)
                        .addComponent(btnCall))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSend))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addComponent(btnRefresh1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVideo)
                    .addComponent(btnCall))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCallActionPerformed
        AudioCallForm form = new AudioCallForm();
        form.setVisible(true);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnCallActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        try {
//        Pastikan Restaurant tidak kosong
            if (cbCustomer.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Please choose a customer", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

//        Restaurant ID
            int customer_id = Integer.parseInt(ids.get(cbCustomer.getSelectedIndex()));

//        startHour
            Date currrent_time = new Date();
            SimpleDateFormat strFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String date = strFormatter.format(currrent_time);
            message = txtMessage.getText();

            out.writeBytes("CHAT//" + customer_id + ";" + date + ";" + message + "\n");

            refreshChat();
        } catch (IOException ex) {
            Logger.getLogger(ChatForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnRefresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh1ActionPerformed
        refreshChat();
    }//GEN-LAST:event_btnRefresh1ActionPerformed

    private void cbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCustomerActionPerformed
        refreshChat();
    }//GEN-LAST:event_cbCustomerActionPerformed

    private void btnVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVideoActionPerformed
        VideoCallForm form = new VideoCallForm();
        form.setVisible(true);
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnVideoActionPerformed

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
            java.util.logging.Logger.getLogger(ChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCall;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRefresh1;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnVideo;
    private javax.swing.JComboBox<String> cbCustomer;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaChat;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables
}
