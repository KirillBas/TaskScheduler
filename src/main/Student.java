package main;

import java.time.LocalDate;
import java.util.Objects;

public class Student {
    private String name;
    private String task;

    public Student() {
    }

    public Student(String name, String task) {
        this.name = name;
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(task, student.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, task);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", task='" + task + '\'' +
                '}';
    }

}
