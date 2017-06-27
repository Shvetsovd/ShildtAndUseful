package company.myUseful.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by OPER on 27.06.2017.
 */
public class InetAddressTest {

    public static void main(String[] args) throws IOException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        InetAddress host = InetAddress.getByName("www.yandex.ru");
        System.out.println(host);

        InetAddress[] hosts = InetAddress.getAllByName("www.yandex.ru");
        System.out.println(Arrays.toString(hosts));

        InetAddress google = InetAddress.getByAddress(new byte[]{8, 8, 8, 8});
        System.out.println(google.getHostName());
        System.out.println(google.getCanonicalHostName());
        System.out.println(google.getHostAddress());
        System.out.println(google.isReachable(15));
        System.out.println(google.isMulticastAddress());

    }

}
