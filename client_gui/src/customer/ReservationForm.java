package customer;

import auth.LoginForm;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ReservationForm extends javax.swing.JFrame {

    BufferedReader in;
    DataOutputStream out;
    String message;
    ArrayList<String> ids;
    ArrayList<String> names;
    ArrayList<String> tableCounts;

    public ReservationForm() {
        try {
            initComponents();
            this.setLocationRelativeTo(null);
            in = new BufferedReader(new InputStreamReader(LoginForm.s.getInputStream()));
            out = new DataOutputStream(LoginForm.s.getOutputStream());

            out.writeBytes("DATARESTAURANT//" + " " + "\n");
            String response = in.readLine();
            String[] responses = response.split(";");
            ids = new ArrayList<String>();
            names = new ArrayList<String>();
            tableCounts = new ArrayList<String>();

            for (int i = 0; i < responses.length; i++) {
//                Tambahkan id ke arraylist
                ids.add(responses[i].split("&")[0]);
//                Tambahkan name ke arraylist
                String _name = responses[i].split("&")[1];
                names.add(_name);
//                Tambahkan name ke combobox
                cbRestaurant.addItem(_name);
//                Tambahkan table counts ke arraylist
                tableCounts.add(responses[i].split("&")[2]);
            }
        } catch (IOException ex) {
            Logger.getLogger(ReservationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        btnLetsgo = new javax.swing.JButton();
        cbTable = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbDuration = new javax.swing.JComboBox<>();
        txtMinute = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtHour = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BookingDate = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbRestaurant = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(2, 26, 74));

        lblLogin.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setText("Reservation");

        btnLetsgo.setBackground(new java.awt.Color(244, 203, 14));
        btnLetsgo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnLetsgo.setText("LET'S GO");
        btnLetsgo.setBorderPainted(false);
        btnLetsgo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetsgoActionPerformed(evt);
            }
        });

        cbTable.setBackground(new java.awt.Color(242, 242, 242));
        cbTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Table");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Duration");

        cbDuration.setBackground(new java.awt.Color(242, 242, 242));
        cbDuration.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbDuration.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "30 minutes", "1 hour", "1 hour 30 minutes", "2 hour", "2 hour 30 minutes", "3 hour", "4 hour" }));

        txtMinute.setBackground(new java.awt.Color(242, 242, 242));
        txtMinute.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(":");

        txtHour.setBackground(new java.awt.Color(242, 242, 242));
        txtHour.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Time");

        BookingDate.setDateFormatString("yyyy-MM-dd");
        BookingDate.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Date");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Restaurant");

        cbRestaurant.setBackground(new java.awt.Color(242, 242, 242));
        cbRestaurant.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(lblLogin))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLetsgo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BookingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtHour, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTable, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BookingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbTable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLetsgo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
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
            //        Pastikan Restaurant tidak kosong
            if (cbRestaurant.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Please choose a restaurant", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
//        Pastikan Date tidak kosong
            if (BookingDate.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Please choose a date", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!txtMinute.getText().matches("-?\\d+(\\.\\d+)?")) {
                JOptionPane.showMessageDialog(this, "Please fill in the time section with numbers", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
//        Pastikan waktu tidak kosong dan waktu dalam range yang benar
            if (txtHour.getText() == null || txtMinute.getText() == null || Integer.parseInt(txtHour.getText()) > 23 || Integer.parseInt(txtMinute.getText()) > 59) {
                JOptionPane.showMessageDialog(this, "Please fill in the time section correctly", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
//        Pastikan durasi tidak kosong
            if (cbDuration.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Please choose a duration", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
//        Pastikan jumlah table tidak kosong
            if (cbTable.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Please choose table", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
//        Semua udah di select

//        Restaurant ID
            int restaurant_id = Integer.parseInt(ids.get(cbRestaurant.getSelectedIndex()));
//        startHour
            Date reservation_date = BookingDate.getDate();
            SimpleDateFormat strFormatter = new SimpleDateFormat("yyyy-MM-dd");
            String strStartDate = strFormatter.format(reservation_date);

            String strStartHour = txtHour.getText() + ":" + txtMinute.getText() + ":00";
            String startHour = strStartDate + " " + strStartHour;

//        EndHour
            Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startHour);
//        Caculation for endHour
            long timeInSecs = startDate.getTime();

//        Specify the added minutes
            int addedMinutes = 0;
            if (cbDuration.getSelectedItem().toString().equals("30 minutes")) {
                addedMinutes = 30;
            } else if (cbDuration.getSelectedItem().toString().equals("1 hour")) {
                addedMinutes = 60;
            } else if (cbDuration.getSelectedItem().toString().equals("1 hour 30 minutes")) {
                addedMinutes = 90;
            } else if (cbDuration.getSelectedItem().toString().equals("2 hour")) {
                addedMinutes = 120;
            } else if (cbDuration.getSelectedItem().toString().equals("2 hour 30 minutes")) {
                addedMinutes = 150;
            } else if (cbDuration.getSelectedItem().toString().equals("3 hour")) {
                addedMinutes = 180;
            } else if (cbDuration.getSelectedItem().toString().equals("4 hour")) {
                addedMinutes = 240;
            }

            Date endDate = new Date(timeInSecs + (addedMinutes * 60 * 1000));
            SimpleDateFormat endFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String endHour = endFormatter.format(endDate);

//         Table Count
            int tableCount = Integer.parseInt(cbTable.getSelectedItem().toString());
//            Kirim ke server
            out.writeBytes("RESERVATION//"
                    + startHour + ";"
                    + endHour + ";"
                    + String.valueOf(tableCount) + ";"
                    + String.valueOf(restaurant_id) + ";"
                    + "\n");

//            Hasil dari server
            String response = in.readLine();
            String[] msg = response.split(";");
            String hasil = msg[0];
            String preorder_availability = msg[1];
            String pesan = msg[2];

            if (hasil.equals("True")) {
                if (preorder_availability.equals("True")) {
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(this, pesan, "Reservation Successful", dialogButton);
//                    Apabila user memilih yes (ingin melakukan pre order)
                    if (dialogResult == 0) {
//                      Kirim ke server
                        out.writeBytes("GETBOOKINGINDEX//" + " " + "\n");
                        response = in.readLine();
//                      Hasil dari server
                        int booking_id = Integer.parseInt(response);
                        PreOrderForm form = new PreOrderForm(restaurant_id, booking_id);
                        form.setVisible(true);
                        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        this.dispose();
                    }

                } else if (preorder_availability.equals("False")) {
                    JOptionPane.showMessageDialog(this, pesan, "Reservation Successful", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (hasil.equals("False")) {
                JOptionPane.showMessageDialog(this, pesan, "Reservation Failed", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (ParseException ex) {
            Logger.getLogger(ReservationForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReservationForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnLetsgoActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ReservationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser BookingDate;
    private javax.swing.JButton btnLetsgo;
    private javax.swing.JComboBox<String> cbDuration;
    private javax.swing.JComboBox<String> cbRestaurant;
    private javax.swing.JComboBox<String> cbTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JTextField txtHour;
    private javax.swing.JTextField txtMinute;
    // End of variables declaration//GEN-END:variables
}
