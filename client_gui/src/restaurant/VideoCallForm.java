package restaurant;

import com.github.sarxos.webcam.Webcam;
import java.awt.image.BufferedImage;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.swing.ImageIcon;
public class VideoCallForm extends javax.swing.JFrame implements Runnable {

    Thread t;
    VideoCallSystem vcs;
    boolean running = true;
    SourceDataLine sourceDataLine;
    Webcam cam;
    
    public class VideoCallSystem extends Thread {

        public void run() {
            byte b[] = null;
            while (running) {
                b = receiveUDP();
                toSpeaker(b);
            }
        }
    }
    
    public VideoCallForm() {    
        initComponents();
        vcs = new VideoCallSystem();
        this.setLocationRelativeTo(null);
        this.setTitle("Video Call");
        try {
            if (t == null) {
                t = new Thread(this, "videoCall");
                t.start();
            }

            vcs.start();
        } catch (Exception e) {

        }
    }

@Override
    public void run() {
        byte b[] = null;
        while (true) {
            try {
//                Inisiasi socket untuk mengirim video
                Socket s = new Socket("127.0.0.1", 7800);
                ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                
                ImageIcon ic;
                BufferedImage br;
//                Inisiasi webcam
                cam = Webcam.getDefault();
//                Buka webcam
                cam.open();
                
//                Terima voice
                b = receiveUDP();
                toSpeaker(b);

                while (running) {
//                    Ambil gambar
                    br = cam.getImage();
//                    Pasang gambar
                    ic = new ImageIcon(br);
                    out.writeObject(ic);
                    out.flush();
                    clientVideo.setIcon(ic);
                }
            } catch (Exception ex) {
                t.stop();
            }
        }
    }
    
    public byte[] receiveUDP() {
        try {
            DatagramSocket sock = new DatagramSocket(5000);
            byte soundpacket[] = new byte[10000];
            DatagramPacket datagram = new DatagramPacket(soundpacket, soundpacket.length, InetAddress.getByName("localhost"), 5000);
            sock.receive(datagram);
            sock.close();
            return datagram.getData();
        } catch (Exception e) {
            return null;
        }
    }

    public void toSpeaker(byte soundbytes[]) {
        try {
            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, getAudioFormat());
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
            sourceDataLine.open(getAudioFormat());
            sourceDataLine.start();
            sourceDataLine.write(soundbytes, 0, soundbytes.length);
            sourceDataLine.drain();
            sourceDataLine.close();
        } catch (Exception e) {
            
        }
    }

    public AudioFormat getAudioFormat() {
        return new AudioFormat(44100.0f, 16, 1, true, false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        clientVideo = new javax.swing.JLabel();
        btnAudioCall = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(2, 26, 74));

        lblLogin.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/videocall.png"))); // NOI18N
        lblLogin.setText("Customer");

        clientVideo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addComponent(clientVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(btnAudioCall))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(lblLogin)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblLogin)
                .addGap(18, 18, 18)
                .addComponent(clientVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnAudioCall, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAudioCallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAudioCallActionPerformed
        sourceDataLine.stop();
        cam.close();
        vcs.stop();
        running = false;
        t.stop();
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
