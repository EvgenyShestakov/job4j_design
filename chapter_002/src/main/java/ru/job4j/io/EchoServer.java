package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
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
                        server.close();
                    } else if (request.indexOf("Hello") != -1) {
                        out.write("HTTP/1.1 200 Hello\r\n");
                    } else if (request.indexOf("Any") != -1) {
                        out.write("HTTP/1.1 200 What?\r\n");
                    } else {
                        out.write("HTTP/1.1 200 OK\r\n");
                    }
                    out.flush();
                }
            }
        }
    }
}