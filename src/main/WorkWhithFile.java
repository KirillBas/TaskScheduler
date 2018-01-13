package main;


import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Map;

public class WorkWhithFile {
    private Path path = Paths.get("calendar.csv");

//не нужен
    public void initializeCalendar(Map<LocalDate, Student> taskMap) {
        LocalDate localDate = LocalDate.of(2018, 1, 1);
        Student student = new Student();
        while (!localDate.equals(LocalDate.of(2019, 1, 1))) {
            taskMap.put(localDate, student);
            localDate = localDate.plusDays(1);
        }
    }

    // TODO: 12.01.2018 после написания view избавиться от постоянного перезаписывания файла
    public void deleteStudentAtDay(Map<LocalDate, Student> taskMap, LocalDate localDate) {
        if (taskMap.containsKey(localDate)) {
            taskMap.remove(localDate);
            writeInFile(taskMap);
        } else {
            throw new IndexOutOfBoundsException("Неверная дата");
        }
    }

    public void addStudentAtDay(Map<LocalDate, Student> taskMap, LocalDate localDate, Student student) {
        if (taskMap.containsKey(localDate)) {
            taskMap.put(localDate, student);
            writeInFile(taskMap);
        } else {
            throw new IndexOutOfBoundsException("Неверная дата");
        }
    }

    public void writeInFile(Map<LocalDate, Student> taskMap) {
        // TODO: 12.01.2018 использовать сериализацию мапы
        try (Writer writer = new OutputStreamWriter(Files.newOutputStream(path))) {
            writer.append("localDate, name").append("\n");
            for (LocalDate localDate : taskMap.keySet()) {
                Student student = taskMap.get(localDate);
                writer.append(localDate.toString()).append(" ")
                        .append(student.getName()).append(" ")
                        .append(student.getTask()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TODO: 11.01.2018 написать чтение информации из файла, предусмотреть возможность переноса даты!
}
