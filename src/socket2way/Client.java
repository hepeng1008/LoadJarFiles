package socket2way;

import java.io.*;
import java.net.Socket;
/**
 * Created by yuandl on 2016-10-17.
 * 客户端发数据到服务端
 */
public class Client {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            //1,创建socket客户端对象。
            socket = new Socket("127.0.0.1", 8868);

            Socket finalSocket = socket;

            new Thread(){
                @Override
                public void run() {
                    String message = "";
                    try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    //3,socket输入流。读取服务端返回的数据
                    //bufferedReader_Server = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    //4,socket输出流。将控制台信息数据输出给服务端
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(finalSocket.getOutputStream()));

                    System.out.print("请输入：");

                        while ((message = bufferedReader.readLine()) != null) {
                            bufferedWriter.write(message);
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                            //String getMessage = bufferedReader_Server.readLine();
                            //System.out.println("来自服务器说：" + getMessage);
                            //System.out.print("请输入：");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();



            new Thread(){
                @Override
                public void run() {
                    try {
                        BufferedReader bufferedReader_server = new BufferedReader(new InputStreamReader(finalSocket.getInputStream()));
                        String message = "";
                        while ((message = bufferedReader_server.readLine()) != null) {
                            System.out.println("服务器说:" + message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }.start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
