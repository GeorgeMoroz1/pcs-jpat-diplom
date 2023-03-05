package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class TodosTests {
    Todos todos = new Todos();
    public static PrintWriter out;
    public static BufferedReader in;

    @BeforeEach
    public void newConnection() {
        try {
            Socket socket = new Socket("localhost", 8989);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void addTest() {
        todos.addTask("Умыться");
        todos.addTask("Купить еды");
        todos.addTask("Позавтракать");
        String addResult = todos.getAllTasks();
        Assertions.assertEquals(addResult, "Купить еды Позавтракать Умыться ");
    }

    @Test
    public void removeTest() {
        todos.addTask("Умыться");
        todos.addTask("Купить еды");
        todos.addTask("Позавтракать");
        todos.removeTask("Купить еды");
        String removeResult = todos.getAllTasks();
        Assertions.assertEquals(removeResult, "Позавтракать Умыться ");
    }

    @Test
    public void getAllTasks() {
        todos.addTask("Умыться");
        todos.addTask("Купить еды");
        todos.addTask("Позавтракать");
        String allTasks = todos.getAllTasks();
        System.out.println(allTasks);
        Assertions.assertEquals(allTasks, "Купить еды Позавтракать Умыться ");
    }

    // ваши тесты для класса Todos
}
