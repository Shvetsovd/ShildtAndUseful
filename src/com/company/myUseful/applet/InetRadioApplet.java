package company.myUseful.applet;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/*EuropaPlus
private String linkToStream = "http://ep256.hostingradio.ru:8052/europaplus256.mp3";
private String bannerText = "Europa Plus Moscow                  ";
private String logoURL = "https://www.benztown.com/sites/default/files/styles/jingle_small_teaser/public/jingle_station_logos/EuropaPlus_1200px_2015.png?itok=LmfFPPEE";

LoveRadio
private String linkToStream = "http://stream.variant.fm:8000/LOVE-192";
private String bannerText = "Love Radio          ";
private String logoURL = "http://img-fotki.yandex.ru/get/5500/zomka.c1/0_53e85_dfae8593_L.jpg";

RadioRecord
private String linkToStream = "http://air2.radiorecord.ru:805/rr_320";
private String bannerText = "Radio Record          ";
private String logoURL = "http://abload.de/img/pngindexlikmalzemelerf7uvt.png";

MaximumFM
private String linkToStream = "http://icecast.radiomaximum.cdnvideo.ru/maximum.mp3";
private String bannerText = "MaximumFM          ";
private String logoURL = "http://abload.de/img/pngindexlikmalzemelerf7uvt.png";
*/


public class InetRadioApplet extends Applet {
    private String linkToStream = "http://ep256.hostingradio.ru:8052/europaplus256.mp3";
    private String bannerText = "Europa Plus Moscow          ";
    private String logoURL = "https://www.benztown.com/sites/default/files/styles/jingle_small_teaser/public/jingle_station_logos/EuropaPlus_1200px_2015.png?itok=LmfFPPEE";

    private Image logo;

    private Thread bannerThread;
    private Thread streamThread;
    private Thread controlThread;

    private volatile BufferedInputStream stream;
    private Player player;

    private volatile boolean stopFlag = false;

    @Override
    public void init() {
        setBackground(Color.black);
        setForeground(Color.WHITE);

        try {
            logo = getImage(new URL(logoURL));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                stopFlag = !stopFlag;
            }
        });

        controlThread = new Thread(() -> {
            try {
                while (true) {
                    if (!stopFlag) {

                        if (stream == null) {
                            startPlay();
                            showStatus("<<< Воспроизведение >>>");
                        }
                    } else {

                        if (stream != null) {
                            stopPlay();
                            showStatus("<<< Пауза >>>");
                        }
                    }
                    Thread.sleep(500);
                }

            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        });
        controlThread.start();

    }


    private synchronized void stopPlay() throws IOException {
        player.close();
        stream.close();
        streamThread.stop();
        bannerThread.stop();

        player = null;
        stream = null;
        streamThread = null;
        bannerThread = null;
    }

    private synchronized void startPlay() {
        streamThread = new Thread(() -> {
            try {
                URL url = new URL(linkToStream);
                stream = new BufferedInputStream(url.openStream());
                player = new Player(stream);
                player.play();

            } catch (IOException | JavaLayerException e) {
                e.printStackTrace();
            }
        });
        streamThread.start();

        bannerThread = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(500);
                    repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        bannerThread.start();
    }

    @Override
    public void paint(Graphics g) {
        char sym = bannerText.charAt(0);
        bannerText = (bannerText.substring(1) + sym).intern();

        g.draw3DRect(-100,15,500,20, true);

        g.drawString("В эфире: " + bannerText, 110, 30);
        g.drawImage(logo, 70, 50, this);

    }
}
