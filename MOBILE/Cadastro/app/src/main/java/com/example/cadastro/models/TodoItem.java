package com.example.cadastro.models;

import java.io.Serializable;

public class TodoItem implements Serializable {
    private String task;

    public TodoItem(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}