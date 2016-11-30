package API;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by SUN on 2016/11/29.
 */
public class Test {
    public static void main(String[] args) {
        try {
            //创建一个URL实例
            URL imooc = new URL("http://www.imooc.com");
            URL url = new URL(imooc,"/index.html?username=tom#test");
            System.out.println( "协议：" + url.getProtocol());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
