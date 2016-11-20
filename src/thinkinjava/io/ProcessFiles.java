package thinkinjava.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by Bill on 2016/11/20.
 * Email androidBaoCP@163.com
 */
public class ProcessFiles {
    public interface Strategy{
        void process(File file);
    }
    private String ext;
    private Strategy strategy;
    public ProcessFiles(Strategy strategy,String ext){
        this.strategy=strategy;
        this.ext=ext;
    }
    public void start(String[] args) {
        try {
            if (args.length == 0) {
                processDirectoryTree(new File("."));
            }
            else{
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory()) {
                        processDirectoryTree(fileArg);
                    } else {
                        if (!arg.endsWith("." + ext)) {
                            arg += "." + ext;
                        }
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
    public void processDirectoryTree(File root) throws IOException{
        for (File file:Directory.walk(root.getAbsolutePath(),".*\\."+ext))
            strategy.process(file.getCanonicalFile());
    }
    public static void main(String[] args){
        new ProcessFiles(System.out::println,"java").start(args);
    }
}
