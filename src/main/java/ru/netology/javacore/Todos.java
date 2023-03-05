package ru.netology.javacore;

import java.util.*;

public class Todos {
    private static final int MAX_AMOUNT_OF_TASKS = 7;
    private final List<String> tasks = new LinkedList<>();

    public void addTask(String task) {
        if (tasks.size() < MAX_AMOUNT_OF_TASKS) {
            tasks.add(task);
        }
    }

    public void removeTask(String task) {
        if (tasks.contains(task)) {
            tasks.remove(task);
        }
    }

    public String getAllTasks() {
        Collections.sort(tasks);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            stringBuilder.append(tasks.get(i));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}


