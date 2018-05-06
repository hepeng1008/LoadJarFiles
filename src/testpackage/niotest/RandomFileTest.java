package testpackage.niotest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class RandomFileTest {

    public static void main(String[] args) {
        RandomAccessFile randomAccessFile=null;
        try {
            randomAccessFile= new RandomAccessFile("test","rw");
            FileChannel channel = randomAccessFile.getChannel();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
