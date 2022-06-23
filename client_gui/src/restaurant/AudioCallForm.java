package restaurant;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class AudioCallForm extends javax.swing.JFrame implements Runnable {

    Thread t;
    boolean running = true;

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
        lblLogin.setText("Calling Customer");

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
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAudioCall, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblLogin)
                        .addGap(71, 71, 71))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblLogin)
                .addGap(18, 18, 18)
                .addComponent(btnAudioCall, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAudioCallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAudioCallActionPerformed
        running = false;
        this.dispose();
        
    }//GEN-LAST:event_btnAudioCallActionPerformed

    @Override
    public void run() {
        byte b[] = null;
        while (running) {
            b = receiveUDP();
            toSpeaker(b);
        }
    }

    public static byte[] receiveUDP() {
        try {
            DatagramSocket sock = new DatagramSocket(5000);
            byte soundpacket[] = new byte[50000];
            DatagramPacket datagram = new DatagramPacket(soundpacket, soundpacket.length, InetAddress.getByName("localhost"), 5000);
            sock.receive(datagram);
            sock.close();
            return datagram.getData();
        } catch (Exception e) {
            return null;
        }
    }

    public static void toSpeaker(byte soundbytes[]) {
        try {
            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, getAudioFormat());
            SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
            sourceDataLine.open(getAudioFormat());
            sourceDataLine.start();
            sourceDataLine.write(soundbytes, 0, soundbytes.length);
            sourceDataLine.drain();
            sourceDataLine.close();
        } catch (Exception e) {

        }
    }

    public static AudioFormat getAudioFormat() {
        return new AudioFormat(44100.0f, 16, 1, true, false);
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
