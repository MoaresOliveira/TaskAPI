package io.github.todolist.enums;

public enum StatusTaskEnum {

    ToDo("To Do"),
    Doing("Doing"),
    Done("Done");

    private final String status;
    StatusTaskEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
