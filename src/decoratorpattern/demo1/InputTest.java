package decoratorpattern.demo1;

import java.io.*;
import java.net.URISyntaxException;

public class InputTest {

    public static void main(String[] args) {
        int c;
        try{
            //getPath()方法会通过系统的默认编码方式进行解码
            System.out.println(InputTest.class.getClassLoader().getResource("").toURI().getPath());
            System.out.println(InputTest.class.getClassLoader().getResource("").toString());
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(InputTest.class.getResource("").toURI().getPath()+"test.txt")));


            while((c=in.read())>=0){
                System.out.println((char)c);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
