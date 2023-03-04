package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private final List<String> tasks = new LinkedList<>();
    private static final int MAX_AMOUNT_OF_TASKS = 7;

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
        for (String i : tasks) {
            if (stringBuilder.toString().equals("")) {
                stringBuilder.append(tasks);
            } else {
                stringBuilder.append(" ").append(i);
            }
        }
        return stringBuilder.toString();
    }
    }


