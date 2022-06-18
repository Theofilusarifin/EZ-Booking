package restaurant;

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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DisplayBookings extends javax.swing.JFrame {

    Socket s;
    BufferedReader in;
    DataOutputStream out;
    String message;
    ArrayList<String> nama;    
    ArrayList<String> start;
    ArrayList<String> end;
    ArrayList<String> table;

    public DisplayBookings() {
        initComponents();
                try {
            
            this.setLocationRelativeTo(null);
            s = new Socket("localhost", 6000);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new DataOutputStream(s.getOutputStream());
            
            out.writeBytes("DISPLAYBOOKINGS//" + "6" + " " + "\n");
            String response = in.readLine();
            txtarea.append(response);
            String[] responses = response.split(";");
            nama = new ArrayList<String>();            
            start = new ArrayList<String>();
            end = new ArrayList<String>();
            table = new ArrayList<String>();
            
//            for (int i = 0; i < responses.length; i++) {
////                Tambahkan nama customer ke arraylist
//                String _nama = responses[i].split("&")[0];
//                nama.add(_nama);
////                Tambahkan start hour ke arraylist
//                start.add(responses[i].split("&")[1]);
////                Tambahkan end hour ke arraylist
//                end.add(responses[i].split("&")[2]);
////                Tambahkan table counts ke arraylist
//                table.add(responses[i].split("&")[3]);
//            }
//            for (int i = 0; i < responses.length; i++) {
//                String _nama = responses[i].split("&")[0];
//                txtarea.append("aaa");
//                txtarea.append(responses[i].split("&")[0]);                
//                txtarea.append(responses[i].split("&")[1]);                
//                
//                txtarea.append(responses[i].split("&")[2]);
//                txtarea.append(responses[i].split("&")[3]);
//
//            }
//            
//            DefaultTableModel dpt = (DefaultTableModel) tableData.getModel();
//            dpt.setRowCount(0);
//            Object[] rowData = new Object[4];
//            for (int i = 0; i < responses.length; i++) {
//                String _nama = responses[i].split("&")[0];
//                rowData[0] = _nama;
//                rowData[1] = responses[i].split("&")[1];
//                rowData[2] = responses[i].split("&")[2];
//                rowData[3] = responses[i].split("&")[3];
//                dpt.addRow(rowData);
//            }

        } catch (Exception ex) {
            Logger.getLogger(DisplayBookings.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    public DisplayBookings(String kode) {
        initComponents();
//        try {
//            
//            this.setLocationRelativeTo(null);
//            s = new Socket("localhost", 6000);
//            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
//            out = new DataOutputStream(s.getOutputStream());
//            
//            out.writeBytes("DATABOOKINGS//" + kode + " " + "\n");
//            String response = in.readLine();
//            String[] responses = response.split(";");
//            nama = new ArrayList<String>();            
//            start = new ArrayList<String>();
//            end = new ArrayList<String>();
//            table = new ArrayList<String>();
//            
////            for (int i = 0; i < responses.length; i++) {
//////                Tambahkan nama customer ke arraylist
////                String _nama = responses[i].split("&")[0];
////                nama.add(_nama);
//////                Tambahkan start hour ke arraylist
////                start.add(responses[i].split("&")[1]);
//////                Tambahkan end hour ke arraylist
////                end.add(responses[i].split("&")[2]);
//////                Tambahkan table counts ke arraylist
////                table.add(responses[i].split("&")[3]);
////            }
//            
//            DefaultTableModel dpt = (DefaultTableModel) tableData.getModel();
//            dpt.setRowCount(0);
//            Object[] rowData = new Object[4];
//            for (int i = 0; i < responses.length; i++) {
//                String _nama = responses[i].split("&")[0];
//                rowData[0] = _nama;
//                rowData[1] = responses[i].split("&")[1];
//                rowData[2] = responses[i].split("&")[2];
//                rowData[3] = responses[i].split("&")[3];
//                dpt.addRow(rowData);
//            }
//
//        } catch (Exception ex) {
//            Logger.getLogger(DisplayBookings.class.getName()).log(Level.SEVERE, null, ex);
//        }  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Customer Name", "Start Hour", "End Hour", "Tables Count"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableData);

        txtarea.setColumns(20);
        txtarea.setRows(5);
        jScrollPane2.setViewportView(txtarea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DisplayBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayBookings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableData;
    private javax.swing.JTextArea txtarea;
    // End of variables declaration//GEN-END:variables
}
