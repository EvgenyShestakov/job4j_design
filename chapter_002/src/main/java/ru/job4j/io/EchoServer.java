package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args)  {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream()));
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    StringBuilder request = new StringBuilder();
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        request.append(str);
                        System.out.println(str);
                        str = in.readLine();
                    }
                    if (request.indexOf("Exit") != -1) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n");
                        out.write("Bye");
                        out.flush();
                        server.close();
                    } else if (request.indexOf("Hello") != -1) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n");
                        out.write("Hello");
                    } else if (request.indexOf("Any") != -1) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n");
                        out.write("What?");
                    } else {
                        out.write("HTTP/1.1 200 OK\r\n\r\n");
                    }
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
    }
}