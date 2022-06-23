package customer;

import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Port;
import javax.sound.sampled.TargetDataLine;
import javax.swing.ImageIcon;

public class VideoCallForm extends javax.swing.JFrame implements Runnable {

    Thread t;
    boolean running = true;

    public VideoCallForm() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setTitle("Video Call");
        try {
            if (t == null) {
                t = new Thread(this, "videoCall");
                t.start();
            }
        } catch (Exception e) {

        }
    }
    
    @Override
    public void run() {
        while (running) {
            Mixer.Info minfo[] = AudioSystem.getMixerInfo();

            if (AudioSystem.isLineSupported(Port.Info.MICROPHONE)) {
                try {
                    ServerSocket server = new ServerSocket(7800);
                    System.out.println("Wait...");
                    Socket s = server.accept();
                    System.out.println("Connect...");
                    ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                    ImageIcon ic;

                    DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, getAudioFormat());
                    TargetDataLine targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
                    targetDataLine.open(getAudioFormat());
                    targetDataLine.start();
                    byte tempBuffer[] = new byte[10000];
                    
                    while (true) {
                        ic = (ImageIcon) in.readObject();
                        clientVideo.setIcon(ic);

                        targetDataLine.read(tempBuffer, 0, tempBuffer.length);
                        sendUDP(tempBuffer);
                    }
                } catch (Exception ex) {
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
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        clientVideo = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        btnAudioCall = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(2, 26, 74));

        clientVideo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblLogin.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/videocall.png"))); // NOI18N
        lblLogin.setText(" Restaurant");

        btnAudioCall.setBackground(new java.awt.Color(180, 0, 51));
        btnAudioCall.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAudioCall.setForeground(new java.awt.Color(255, 255, 255));
        btnAudioCall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/endcall.png"))); // NOI18N
        btnAudioCall.setText("End Video Call");
        btnAudioCall.setBorderPainted(false);
        btnAudioCall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAudioCallActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(clientVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAudioCall)
                        .addGap(275, 275, 275))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLogin)
                        .addGap(284, 284, 284))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblLogin)
                .addGap(18, 18, 18)
                .addComponent(clientVideo, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(btnAudioCall, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAudioCallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAudioCallActionPerformed
        running = false;
        this.dispose();
    }//GEN-LAST:event_btnAudioCallActionPerformed

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
            java.util.logging.Logger.getLogger(VideoCallForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VideoCallForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VideoCallForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VideoCallForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VideoCallForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAudioCall;
    public static javax.swing.JLabel clientVideo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLogin;
    // End of variables declaration//GEN-END:variables
}
