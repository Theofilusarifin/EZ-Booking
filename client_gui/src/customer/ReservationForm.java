package customer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ReservationForm extends javax.swing.JFrame {

    Socket s;
    BufferedReader in;
    DataOutputStream out;
    String message;
    
    public ReservationForm() {
        try {
            initComponents();
            s = new Socket("localhost", 6000);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new DataOutputStream(s.getOutputStream());
            
            out.writeBytes("DATARESTAURANT//" + "\n");
            String response = in.readLine();
            System.out.println(response);
        } catch (IOException ex) {
            Logger.getLogger(ReservationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtHour = new javax.swing.JTextField();
        BookingDate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMinute = new javax.swing.JTextField();
        cbRestaurant = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        btnLetsgo = new javax.swing.JButton();
        cbDuration = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbTable = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtHour.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        BookingDate.setDateFormatString("yyyy-MM-dd");
        BookingDate.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText(":");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Date");

        txtMinute.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        cbRestaurant.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbRestaurant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "a", "b", "c", "d" }));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Duration");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Restaurant");

        lblLogin.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setText("Reservation");

        btnLetsgo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLetsgo.setText("LET'S GO");
        btnLetsgo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLetsgoActionPerformed(evt);
            }
        });

        cbDuration.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbDuration.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "30 minutes", "1 hour", "1 hour 30 minutes", "2 hour", "2 hour 30 minutes", "3 hour", "4 hour" }));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Table");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Time");

        cbTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BookingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtHour, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTable, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(151, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblLogin)
                        .addGap(213, 213, 213))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLetsgo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BookingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbTable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(btnLetsgo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
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
//        Pastikan waktu tidak kosong
            if (txtHour.getText() == null || txtMinute.getText() == null) {
                JOptionPane.showMessageDialog(this, "Please fill in the time section", "Warning", JOptionPane.WARNING_MESSAGE);
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

//        User ID
            int user_id = 1;
//        Restaurant ID
            int restaurant_id = cbRestaurant.getSelectedIndex();

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
            if (cbDuration.getSelectedItem().toString().equals("30 minutes")) addedMinutes = 30;
            else if (cbDuration.getSelectedItem().toString().equals("1 hour")) addedMinutes = 60;
            else if (cbDuration.getSelectedItem().toString().equals("1 hour 30 minutes")) addedMinutes = 90;
            else if (cbDuration.getSelectedItem().toString().equals("2 hour")) addedMinutes = 120;
            else if (cbDuration.getSelectedItem().toString().equals("2 hour 30 minutes")) addedMinutes = 150;
            else if (cbDuration.getSelectedItem().toString().equals("3 hour")) addedMinutes = 180;
            else if (cbDuration.getSelectedItem().toString().equals("4 hour")) addedMinutes = 240;

            Date endDate = new Date(timeInSecs + (addedMinutes * 60 * 1000));
            SimpleDateFormat endFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String endHour = endFormatter.format(endDate);
            
//         Table Count
            int tableCount = Integer.parseInt(cbTable.getSelectedItem().toString());
//            Kirim ke server
            out.writeBytes("RESERVATION//" + 
                    startHour + ";" + 
                    endHour + ";" + 
                    String.valueOf(tableCount) + ";" + 
                    String.valueOf(user_id) + ";" +  
                    String.valueOf(restaurant_id) + ";" +  
                    "\n");
            
//            Hasil dari server
            String response = in.readLine();
            String[] msg = response.split(";");
            String hasil = msg[0];
            String preorder_availability = msg[1];
            String pesan = msg[2];
            
            if (hasil.equals("True")) {
                if (preorder_availability.equals("True")){
                    JOptionPane.showMessageDialog(this, pesan, "Reservation Successful", JOptionPane.INFORMATION_MESSAGE);
                    
                }
                else if (preorder_availability.equals("False")){
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
    private javax.swing.JLabel lblLogin;
    private javax.swing.JTextField txtHour;
    private javax.swing.JTextField txtMinute;
    // End of variables declaration//GEN-END:variables
}
