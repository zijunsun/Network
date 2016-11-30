package Chapter_1;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by SUN on 2016/11/29.
 */
public class SocketTest {
    public static void main(String[] args) throws IOException{
        try(Socket s = new Socket("www.baidu.com",80)){
            InputStream inputStream = s.getInputStream();
            Scanner in = new Scanner(inputStream);

            while (in.hasNextLine()){
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
}
