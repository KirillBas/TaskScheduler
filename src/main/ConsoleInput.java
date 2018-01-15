package main;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ConsoleInput {
    private Student student = null;
    private Scanner scanner = new Scanner(System.in);
    // TODO: 11.01.2018 написать view
    private WorkWhithFile workWhithFile;
    private LocalDate localDate;

    public ConsoleInput(Student student, Scanner scanner, WorkWhithFile workWhithFile, LocalDate localDate) {
        this.student = student;
        this.scanner = scanner;
        this.workWhithFile = workWhithFile;
        this.localDate = localDate;
    }

    public void startMenu() {
        System.out.println("Это твоё расписание уроков");
        System.out.println("Выход. Нажми #0");
        System.out.println("Назначить расписание для ученика. Нажми #1");
        System.out.println("Удалить расписание для ученика. Нажми #2");
        System.out.println("Перенести дату для ученика. Нажми #3");
    }

    public void workWhithStartMenu() {
        Map< LocalDate, Student> taskMap = new TreeMap<>();
        String input = scanner.next();
        startMenu();
        while (true) {
            switch (input) {
                case "0":
                    return;
                case "1":
                    workWhithFile.addStudentAtDay(taskMap, localDate, student);
                case "2":
                    return;
                case "3":
                    return;
            }
            workWhithFile.writeInFile(taskMap);
        }
    }
    // TODO: 15.01.2018 написать методы для определения клиента и даты!
}
