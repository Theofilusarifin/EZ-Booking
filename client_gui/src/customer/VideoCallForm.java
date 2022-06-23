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
        while (true) {
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

        clientVideo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clientVideo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(clientVideo, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(clientVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(65, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    public static javax.swing.JLabel clientVideo;
    // End of variables declaration//GEN-END:variables
}
