package com.example.to_do_list_app;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private int id;
    private String title;
    private String description;
    private String dueDate;

    public Task(int id, String title, String description, String dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    public static List<Task> getMockTasks() {
        List<Task> tasks = new ArrayList<>();

        tasks.add(new Task(1, "Comprar leche", "Comprar leche desnatada", "2024-06-15"));
        tasks.add(new Task(2, "Llamar al médico", "Pedir cita para revisión anual", "2024-06-16"));
        tasks.add(new Task(3, "Preparar presentación", "Preparar slides para reunión", "2024-06-18"));
        tasks.add(new Task(4, "Comprar leche", "Comprar leche desnatada", "2024-06-29"));
        tasks.add(new Task(5, "Llamar al médico", "Pedir cita para revisión anual", "2024-06-20"));
        tasks.add(new Task(6, "Preparar presentación", "Preparar slides para reunión", "2024-06-10"));

        return tasks;
    }
}
