package company.myUseful.net.streamAudio;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

/**
 * Created by OPER on 27.06.2017.
 */
public class InetAudioStream {
    public static void main(String[] args) throws IOException, JavaLayerException {
        //EuropaPlus
        //playURLAudioStream("http://ep256.hostingradio.ru:8052/europaplus256.mp3");

        //LoveRadio
        //playURLAudioStream("http://stream.variant.fm:8000/LOVE-192");

        //RadioRecord
        //playURLAudioStream("http://air2.radiorecord.ru:805/rr_320");

        //MaximumFM
        //playURLAudioStream("http://icecast.radiomaximum.cdnvideo.ru/maximum.mp3");

        //Локальный mp3 файл
        playMP3File("d:\\MUSIC\\TeQuero.mp3");



    }

    static void playURLAudioStream(String path) throws IOException, JavaLayerException {
        URL url = new URL(path);
        try(BufferedInputStream is = new BufferedInputStream(url.openStream());) {

            Player player = new Player(is);
            player.play();
        }
    }

    static void playMP3File(String path) throws IOException, JavaLayerException {
        try(BufferedInputStream is = new BufferedInputStream(new FileInputStream(path));){

            Player player = new Player(is);
            player.play();

        }


    }
}
