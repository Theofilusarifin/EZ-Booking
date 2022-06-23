package customer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Port;
import javax.sound.sampled.TargetDataLine;

public class AudioCallForm extends javax.swing.JFrame implements Runnable {

    Thread t = null;
    boolean running = true;
    byte[] receiveData;
    byte[] sendData;
    DatagramPacket sendPacket;
    DatagramPacket receivePacket;
    DatagramSocket clientSocket;

    public AudioCallForm() {
        initComponents();
        try {
            if (t == null) {
                t = new Thread(this, "audiocall");
                t.start();
            }
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        btnAudioCall = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLogin.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setText("Calling Restaurant");

        btnAudioCall.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAudioCall.setText("End Call");
        btnAudioCall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAudioCallActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnAudioCall, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(lblLogin)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblLogin)
                .addGap(18, 18, 18)
                .addComponent(btnAudioCall, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAudioCallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAudioCallActionPerformed
        running = false;
        this.dispose();
    }//GEN-LAST:event_btnAudioCallActionPerformed

    @Override
    public void run() {
        while (running) {
            if (AudioSystem.isLineSupported(Port.Info.MICROPHONE)) {
                try {
                    DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, getAudioFormat());
                    TargetDataLine targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
                    targetDataLine.open(getAudioFormat());
                    targetDataLine.start();
                    byte tempBuffer[] = new byte[50000];

                    while (true) {
                        targetDataLine.read(tempBuffer, 0, tempBuffer.length);
                        sendUDP(tempBuffer);
                    }
                } catch (Exception e) {
                    t.stop();
                }
            }
        }
    }

    public static AudioFormat getAudioFormat() {
        return new AudioFormat(44100.0f, 16, 1, true, false);
    }

    public static void sendUDP(byte soundpacket[]) {
        try {
            DatagramSocket sock = new DatagramSocket();
            sock.send(new DatagramPacket(soundpacket, soundpacket.length, InetAddress.getByName("localhost"), 5000));
            sock.close();
        } catch (Exception e) {

        }
    }

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
            java.util.logging.Logger.getLogger(AudioCallForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AudioCallForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AudioCallForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AudioCallForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AudioCallForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAudioCall;
    private javax.swing.JLabel lblLogin;
    // End of variables declaration//GEN-END:variables
}
