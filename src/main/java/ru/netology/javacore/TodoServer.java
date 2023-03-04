package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    private int port;
    private  Todos todos;
    private Gson gson = new Gson();

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(8989);) { // стартуем сервер один(!) раз
            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    String request = in.readLine();
                    Command command = gson.fromJson(request, Command.class);
                    switch (command.type) {
                        case ADD:
                            todos.addTask(command.task);
                            break;
                        case REMOVE:
                            todos.removeTask(command.task);
                    }
                    String result = todos.getAllTasks();
                    out.println(result);
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}

class Command {
    enum Type {ADD, REMOVE, RESTORE}

    Type type;
    String task;
    public Command(Type type, String task) {
        this.type = type;
        this.task = task;
    }
}