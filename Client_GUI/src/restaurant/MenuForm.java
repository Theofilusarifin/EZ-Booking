package restaurant;

import auth.LoginForm;
import customer.PreOrderForm;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class MenuForm extends javax.swing.JFrame {

    BufferedReader in;
    DataOutputStream out;
    String[][] values;

    public MenuForm() {
        try {
            initComponents();
            this.setLocationRelativeTo(null);
            in = new BufferedReader(new InputStreamReader(LoginForm.s.getInputStream()));
            out = new DataOutputStream(LoginForm.s.getOutputStream());

//            isi tabel
            refreshTable();
        } catch (IOException ex) {
            Logger.getLogger(PreOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refreshTable() {
        try {
//            ambil menu dari server lalu jadikan array string
            out.writeBytes("DATAMENU// " + "\n");
            String response = in.readLine();
            String[] responses = response.split(";");

//            buat array 2d untuk menampung data dari responses
            values = new String[responses.length][3];

//            isi array values sesuai dengan hasil responses yang sudah displit
            String[] splitResponses;
            for (int i = 0; i < responses.length; i++) {
                splitResponses = responses[i].split("&");
                for (int j = 0; j < 3; j++) {
                    values[i][j] = splitResponses[j];
                }
            }
//        ambil model tabel
            DefaultTableModel model = (DefaultTableModel) tableMenu.getModel();
            model.setRowCount(0);

//        buat object untuk setiap row dan masukkan ke tabel
            Object[] rowData = new Object[2];
            for (int i = 0; i < values.length; i++) {
                rowData[0] = values[i][1];
                rowData[1] = Double.parseDouble(values[i][2]);
                model.addRow(rowData);
            }
        } catch (IOException ex) {
            Logger.getLogger(MenuForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableMenu = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnAddMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableMenu.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tableMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableMenu);
        if (tableMenu.getColumnModel().getColumnCount() > 0) {
            tableMenu.getColumnModel().getColumn(0).setResizable(false);
            tableMenu.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("MENU");

        btnAddMenu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAddMenu.setText("ADD MENU");
        btnAddMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnAddMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMenuActionPerformed
        AddMenuDialog dialog = new AddMenuDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnAddMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMenu;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMenu;
    // End of variables declaration//GEN-END:variables
}
