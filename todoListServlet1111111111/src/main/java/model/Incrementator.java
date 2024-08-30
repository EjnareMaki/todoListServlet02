package model;

public class Incrementator {

    private int currentId = 1;
    public int incrementAndSet() {
        return currentId++;
    }

    public int getCurrentId() {
        return currentId;
    }
}
