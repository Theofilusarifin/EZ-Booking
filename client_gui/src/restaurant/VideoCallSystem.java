package restaurant;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class VideoCallSystem extends Thread {

    public VideoCallSystem() {
        
    }
    
    public void run() {
        byte b[] = null;
        while (true) {
            b = receiveUDP();
            toSpeaker(b);
        }
    }
    
    public static void main(String[] args) {
        VideoCallSystem avcs = new VideoCallSystem();
        avcs.start();
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
}
