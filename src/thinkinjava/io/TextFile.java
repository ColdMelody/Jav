package thinkinjava.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by Bill on 2016/11/20.
 * Email androidBaoCP@163.com
 */
public class TextFile extends ArrayList<String> {
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String s;
        try {
            while ((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            out.print(text);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) {
            remove(0);
        }
    }

    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            for (String item : this) {
                out.println(item);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String file = read("C:\\Users\\Administrator\\IdeaProjects\\Jva\\src\\thinkinjava\\io\\TextFile.java");
        write("C:\\Users\\Administrator\\IdeaProjects\\Jva\\src\\thinkinjava\\io\\test.txt", file);
        TextFile text = new TextFile("C:\\Users\\Administrator\\IdeaProjects\\Jva\\src\\thinkinjava\\io\\test.txt");
        text.write("C:\\Users\\Administrator\\IdeaProjects\\Jva\\src\\thinkinjava\\io\\test2.txt");
        TreeSet<String> words = new TreeSet<>(new TextFile("C:\\Users\\Administrator\\IdeaProjects\\Jva\\src\\thinkinjava\\io\\TextFile.java", ""));
        System.out.println(words);
    }
}
