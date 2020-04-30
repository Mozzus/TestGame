package com.test;

import java.util.ArrayList;
import java.util.List;

public class Tasks {
    private static List<String> zadaniya = new ArrayList<>();

    public static void addTask(String task) {
        System.out.println("@Добавлено новое задание");
        zadaniya.add(task);
    }

    public static void showTasks () {
        int number = 1;
        for (String x : zadaniya) {
            number+=1;
            System.out.println(number + ". " + x);
        }
    }
}
