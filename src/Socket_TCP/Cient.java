package Socket_TCP;

import java.io.*;
import java.net.Socket;

/**
 * Created by SUN on 2016/11/29.
 * 基于TCP协议socket通信，实现用户登录
 * 客户端
 */
public class Cient {
    public static void main(String[] args) {
        try {
            //1、创建客户端Socket,指定服务器地址和端口
            Socket socket = new Socket("localhost",8888);
            //2、获取输出流，向服务器发送信息
            OutputStream os = socket.getOutputStream();//字节输出流
            PrintWriter pw = new PrintWriter(os);//将输出流包装为打印流
            pw.write("用户名：admin;密码：123");
            pw.flush();
            socket.shutdownOutput();//关闭输出流
            //3、获取输入流，并读取服务器端响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = br.readLine()) != null){
                System.out.println("client:");
                System.out.println("server-message=>" + info);
            }
            //3、关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
