package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream()));
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    List<String> requests = new ArrayList<>();
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        requests.add(str);
                        System.out.println(str);
                        str = in.readLine();
                    }
                    for (String request : requests) {
                        int index = request.indexOf("Bye");
                        if (index != -1) {
                            server.close();
                        }
                    }
                    out.write("HTTP/1.1 200 OK\n\r");
                    out.flush();
                }
            }
        }
    }
}
