package controller.dao;

import model.Task;
import model.enums.Priorities;

import java.util.*;

public class TaskDAO implements DAO<Task> {
    private final LinkedHashSet<Task> tasks = new LinkedHashSet<>();
    private static TaskDAO INSTANCE;


    private TaskDAO(){}

    public static TaskDAO getInstance() {
        if (INSTANCE == null) {
            return INSTANCE = new TaskDAO();
        }
        return INSTANCE;
    }

    @Override
    public boolean add(Task value) {
        if (tasks.add(value)) {
            System.out.println("Successfully added task!");
            return true;
        }
        else {
            System.out.println("Cannot add task!");
            return false;
        }
    }

    @Override
    public boolean delete(Task value) {
        if (tasks.remove(value)) {
            System.out.println("Successfully deleted task!");
            return true;
        }
        else {
            throw new RuntimeException("No such user found!");
        }
    }

    @Override
    public Task getById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        throw new RuntimeException("No such user found!");
    }

    @Override
    public Set<Task> getAll() {
        return tasks;
    }

    @Override
    public boolean deleteByName(String name) {
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                tasks.remove(task);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean deleteById(int id) {
      return tasks.removeIf(task -> task.getId() == id);
    }
    public boolean tryAdd(Task task) {
        if (tasks.contains(task)) {
            return false;
        }
        else {
            task.setId(Task.getIncrementator().incrementAndSet());
            return add(task);
        }
    }

    public boolean updateTask(Task taskToUpdate, int id, String name, Priorities priority) {
        for (Task task : tasks) {
            if (task.equals(taskToUpdate)) {
                task.setId(id);
                task.setName(name);
                task.setPriority(priority);
                return true;
            }
        }
        return false;
    }
}
