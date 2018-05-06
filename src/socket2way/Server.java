package socket2way;

import java.io.*;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by yuandl on 2016-10-17.
 * 服务端接收客户端发送过来的数据，并打印在控制台上。
 */
public class Server {
    static ServerSocket serverSocket = null;

    public static void main(String[] args) {
        try {
            HashMap<Integer, OutputStream> hashMap = new HashMap<>();
            ArrayList<Integer> list = new ArrayList<>();
            //1创建服务端对象。
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        int len = hashMap.size();
                            System.out.println(len);
                        if (len > 0) {
                            int i = new Random().nextInt(len);
                            OutputStream outputStream = hashMap.get(list.get(i));
                            try {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                                String outmessage = "";
/*                               while ((outmessage = bufferedReader.readLine()) != null) {
                                    bufferedWriter.write("向端口号为" + list.get(i) + "发送消息为" + outmessage);
                                    bufferedWriter.newLine();
                                    bufferedWriter.flush();
                                    //System.out.print("请输入：");
                                }*/
                                outmessage = bufferedReader.readLine();
                                bufferedWriter.write("向端口号为" + list.get(i) + "发送消息为" + outmessage);
                                bufferedWriter.newLine();
                                bufferedWriter.flush();
                                //System.out.print("请输入：");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }.start();
            serverSocket = new ServerSocket(8868);
            //2,获取连接过来的客户端对象。
            while (true) {
                Socket socket = serverSocket.accept();
                int port = socket.getPort();
                list.add(port);
                hashMap.put(port,socket.getOutputStream());
                System.out.println("来自客户端【" + socket.getInetAddress().getHostAddress() + ",端口号为" + port + "】的连接");
                //3，通过socket对象获取输入流，要读取客户端发来的数据
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            BufferedReader bufferedReader_server = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            String message = "";
                            while ((message = bufferedReader_server.readLine()) != null) {
                                System.out.println("来自客户端【" + socket.getInetAddress().getHostAddress() + "】说:" + message);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }.start();

                /*new Thread() {
                    @Override
                    public void run() {
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                            String outmessage = "";
                            while ((outmessage = bufferedReader.readLine()) != null) {
                                bufferedWriter.write(outmessage);
                                bufferedWriter.newLine();
                                bufferedWriter.flush();
                                //System.out.print("请输入：");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }.start();*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
