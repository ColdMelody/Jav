package test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Bill on 2017/4/18.
 * Email androidBaoCP@163.com
 */
public class ChatServer extends Thread {

    private ServerSocket server = null;
    private static final int PORT = 5000;
    private BufferedWriter writer;
    private BufferedReader reader;

    public ChatServer() throws IOException {
        createSocket();
    }

    @Override
    public void run() {
        Socket client;
        String text;
        try {
            while (true) {
                client = responseSocket();
                while (true) {
                    text = receiveMsg(client);
                    System.out.println(text);
                    sendMsg(client, text);
                    break;
                }
                closeSocket(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createSocket() throws IOException {
        server = new ServerSocket(PORT, 100);
    }

    private Socket responseSocket() throws IOException {
        return server.accept();
    }

    private void closeSocket(Socket socket) throws IOException {
        reader.close();
        writer.close();
        socket.close();
    }

    private void sendMsg(Socket socket, String msg) throws IOException {
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write(msg + "\n");
        writer.flush();
    }

    private String receiveMsg(Socket socket) throws IOException {
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return "Server send:" + reader.readLine();
    }

    public static void main(String[] args) throws IOException {
        ChatServer chatServer = new ChatServer();
        chatServer.start();
    }
}
