package soketoneway;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) {
        Socket socket=null;
        OutputStream outputStream=null;
        try {
            socket= new Socket("127.0.0.1",3307);
            outputStream = socket.getOutputStream();
            outputStream.write("hello world".getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
