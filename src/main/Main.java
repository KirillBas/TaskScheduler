package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        LocalDate localDate = LocalDate.of(2018,1,1);
        Map<LocalDate, Student> taskMap = new TreeMap<>();
        Student student1 = new Student("Nil", "HashMap");
        WorkWhithFile workWhithFile = new WorkWhithFile();
        workWhithFile.initializeCalendar(taskMap);
        System.out.println(taskMap);
        workWhithFile.writeInFile(taskMap);
        workWhithFile.addStudentAtDay(taskMap, LocalDate.of(2018,1,1), student1);
        System.out.println(taskMap);
        workWhithFile.deleteStudentAtDay(taskMap, LocalDate.of(2018,1,1));
        System.out.println(taskMap);
    }
    // TODO: 11.01.2018 написать тесты на весь ГК))
}
