package thinkinjava.io;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * Created by Bill on 2016/11/21.
 * Email androidBaoCP@163.com
 * Zip压缩文件，也可以压缩网络数据
 */
public class ZIPcompress {
    public static void main(String[] args) throws IOException{
        FileOutputStream f=new FileOutputStream("E:\\testio\\test.zip");
        CheckedOutputStream csum=new CheckedOutputStream(f,new Adler32());
        ZipOutputStream zos=new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        zos.setComment("A test of Java compressing");
        for (String arg:args){
            System.out.println("Writing files: "+arg);
            BufferedReader in=new BufferedReader(new FileReader(arg));
            //对于每一个要加入压缩档案的文件，都必须调用这个方法，传递给一个ZipEntry对象
            zos.putNextEntry(new ZipEntry(arg));
            int c;
            while ((c=in.read())!=-1){
                out.write(c);
            }
            in.close();
            out.flush();
        }
        out.close();
        System.out.println("Checksum: "+csum.getChecksum().getValue());
        System.out.println("Reading file");
        FileInputStream fi=new FileInputStream("E:\\testio\\test.zip");
        CheckedInputStream cusmi=new CheckedInputStream(fi,new Adler32());
        ZipInputStream in2=new ZipInputStream(cusmi);
        BufferedInputStream bis=new BufferedInputStream(in2);
        ZipEntry ze;
        while ((ze=in2.getNextEntry())!=null){
            System.out.println("Reading file: "+ze);
            int x;
            while((x=bis.read())!=-1){
                System.out.write(x);
            }
            if (args.length==1){
                System.out.println("Checksum: "+cusmi.getChecksum().getValue());
                bis.close();
                ZipFile zf=new ZipFile("E:\\testio\\test.zip");
                Enumeration e=zf.entries();
                while (e.hasMoreElements()){
                    ZipEntry ze2= (ZipEntry) e.nextElement();
                    System.out.println("File: "+ze2);
                }
            }
        }
    }
}
