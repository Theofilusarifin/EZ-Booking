package customer;

import auth.LoginForm;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PreOrderForm extends javax.swing.JFrame {

    BufferedReader in;
    DataOutputStream out;
    int restaurant_id;
    int booking_id;
    int menu_id;

    ArrayList<String> ids;
    ArrayList<String> names;
    ArrayList<String> prices;
    double price;
    double total_price;
    int amount;
    boolean cbReady = false;

    public PreOrderForm(int r_id, int b_id) {
        try {
            initComponents();
            this.setLocationRelativeTo(null);
            in = new BufferedReader(new InputStreamReader(LoginForm.s.getInputStream()));
            out = new DataOutputStream(LoginForm.s.getOutputStream());
            restaurant_id = r_id;
            booking_id = b_id;

            out.writeBytes("DATAMENU//" + restaurant_id + "\n");
            String response = in.readLine();
            String[] responses = response.split(";");
            ids = new ArrayList<String>();
            names = new ArrayList<String>();
            prices = new ArrayList<String>();

            for (int i = 0; i < responses.length; i++) {
//                Tambahkan id ke arraylist
                ids.add(responses[i].split("&")[0]);
//                Tambahkan name ke arraylist
                String _name = responses[i].split("&")[1];
                names.add(_name);
//                Tambahkan name ke combobox
                cbMenu.addItem(_name);
//                Tambahkan price ke arraylist
                String _price = responses[i].split("&")[2];
                prices.add(_price);
            }
            cbReady = true;

        } catch (IOException ex) {
            Logger.getLogger(PreOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        btnLetsgo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        cbMenu = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(2, 26, 74));

        lblLogin.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setText("Pre Order");

        btnLetsgo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLetsgo.setText("LET'S GO");
        btnLetsgo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetsgoActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sub Total");

        lblSubTotal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblSubTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblSubTotal.setText("---");
        lblSubTotal.setEnabled(false);

        txtAmount.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAmountKeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Amount");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Price");

        lblPrice.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblPrice.setText("---");
        lblPrice.setToolTipText("");
        lblPrice.setEnabled(false);

        cbMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMenuActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Menu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLetsgo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbMenu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(lblLogin)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnLetsgo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLetsgoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLetsgoActionPerformed
        try {
            //        Pastikan menu tidak kosong
            if (cbMenu.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Please choose a menu", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
//        Pastikan amount yang dimasukkan adalah angka
            if (!txtAmount.getText().matches("-?\\d+(\\.\\d+)?")) {
                JOptionPane.showMessageDialog(this, "Please fill in the amount section with numbers", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

//            Kirim ke server
            out.writeBytes("PREORDER//"
                    + String.valueOf(booking_id) + ";"
                    + String.valueOf(menu_id) + ";"
                    + String.valueOf(amount) + ";"
                    + String.valueOf(total_price) + ";"
                    + "\n");

            String response = in.readLine();
            String[] responses = response.split(";");
            if (responses[0].equals("True")) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(this, responses[1], "Preorder Successful", dialogButton);
//                    Apabila user memilih no (Tidak ingin melakukan pre order lagi)
                if (dialogResult == 1) {
                    this.dispose();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(PreOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLetsgoActionPerformed

    private void cbMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMenuActionPerformed
        if (cbReady) {
            menu_id = Integer.parseInt(ids.get(cbMenu.getSelectedIndex()));;
//        Restaurant ID
            price = Double.parseDouble(prices.get(cbMenu.getSelectedIndex()));
//        Ubah price sesuai menu yang dipilih
            lblPrice.setText(String.valueOf(price));

//            ubah total price apabila amount tidak kosong
            if (!txtAmount.getText().equals("")) {
//                  Ambil amount yang diisikan
                amount = Integer.parseInt(txtAmount.getText());
//                  kalkulasikan total price
                total_price = amount * price;
//                  Ubah subtotal sesuai dengan sub total yang sesuai
                lblSubTotal.setText(String.valueOf(total_price));
            }
        }
    }//GEN-LAST:event_cbMenuActionPerformed

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed

    }//GEN-LAST:event_txtAmountActionPerformed

    private void txtAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyReleased
//        Pastikan amount yang dimasukkan adalah angka
        if (!txtAmount.getText().equals("") && !txtAmount.getText().matches("-?\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(this, "Please fill in the amount section with numbers", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
//        Ambil amount yang diisikan
        amount = Integer.parseInt(txtAmount.getText());
//        kalkulasikan total price
        total_price = amount * price;
//        Ubah subtotal sesuai dengan sub total yang sesuai
        lblSubTotal.setText(String.valueOf(total_price));
    }//GEN-LAST:event_txtAmountKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLetsgo;
    private javax.swing.JComboBox<String> cbMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JTextField txtAmount;
    // End of variables declaration//GEN-END:variables
}
