package model;

import model.enums.Priorities;

import java.util.Objects;

public class Task implements Comparable<Task> {
    private static final Incrementator incrementator = new Incrementator();
    private int id;
    private String name;
    private Priorities priority;

    public Task(String name, Priorities priority) {
        this.name = name;
        this.priority = priority;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priorities getPriority() {
        return priority;
    }

    public void setPriority(Priorities priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Task name: %s, task priority: %s".formatted(name, priority);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Task task = (Task) object;
        return Objects.equals(name, task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Task o) {
        if (this.equals(o)) return 0;
        return Integer.compare(id, o.id);
    }
    public static Incrementator getIncrementator() {
        return incrementator;
    }
}
