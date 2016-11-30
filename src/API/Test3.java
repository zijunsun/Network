package API;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by SUN on 2016/11/29.
 * 使用URL读取网页内容
 */
public class Test3 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.baidu.com");
            //通过URL的openStream方法获取URL对象所表示的资源的字节输入流
            InputStream inputStream =  url.openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            //为字符输入流添加缓冲
            BufferedReader br = new BufferedReader(inputStreamReader);
            String data = br.readLine();
            while (data!=null){
                System.out.println(data);
                data = br.readLine();
            }
            br.close();
            inputStream.close();
            inputStreamReader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
