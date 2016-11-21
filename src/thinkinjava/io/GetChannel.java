package thinkinjava.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Bill on 2016/11/21.
 * Email androidBaoCP@163.com
 * 分别产生可写的、可读写的、可读的通道
 */
public class GetChannel {
    private static final int BSIZE=1024;
    public static void main(String[] args) throws Exception{
        FileChannel fc=new FileOutputStream("E:\\testio\\data.txt").getChannel();
        fc.write(ByteBuffer.wrap("some txt".getBytes()));
        fc.close();
        fc=new RandomAccessFile("E:\\testio\\data.txt","rw").getChannel();
        fc.position(fc.size());//移动到结尾处
        fc.write(ByteBuffer.wrap("some more".getBytes()));
        fc.close();
        fc=new FileInputStream("E:\\testio\\data.txt").getChannel();
        ByteBuffer buffer=ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()){
            System.out.println((char) buffer.get());
        }
    }
}
