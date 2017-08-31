package company.useful.net;


import javazoom.jl.decoder.JavaLayerException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by OPER on 27.06.2017.
 */
public class SocketTest {
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException, JavaLayerException {
        Socket socket;

        socket = new Socket("www.yandex.ru", 25);
        System.out.println(socket.isConnected());

        InputStream inputStream = socket.getInputStream();
        System.out.println(inputStream);

        OutputStream outputStream = socket.getOutputStream();
        System.out.println(outputStream);

        /*socket = new Socket("eptop128server.streamr.ru", 8033);
        System.out.println(socket.isConnected());
        try(AudioInputStream ais = AudioSystem.getAudioInputStream(socket.getInputStream());){
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        }*/


    }


}
