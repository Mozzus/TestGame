package com.test;

import java.util.ArrayList;
import java.util.List;

 class Tasks {
    private static List<String> zadaniya = new ArrayList<>();
    private static int number = 0;

    static void addTask(String task) {
        System.out.println("@Добавлено новое задание");
        zadaniya.add(task);
    }

    static void showTasks () {
        zadaniya.forEach(x -> System.out.println((number+=1) + ". " + x));
        number = 0;
    }
}
