package main;


import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class WorkWhithFile {
    private Path path = Paths.get("calendar.csv");
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

    // TODO: 12.01.2018 после написания view избавиться от постоянного перезаписывания файла
    public void deleteStudentAtDay(Map<LocalDate, Student> taskMap, LocalDate localDate) {
        taskMap.remove(localDate);
    }


    public void addStudentAtDay(Map<LocalDate, Student> taskMap, LocalDate localDate, Student student) {
        while (!localDate.equals(LocalDate.of(2018, 3, 31))) {
            int i = 0;
            if (localDate.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
                while (i < 10) {
                    taskMap.put(localDate, student);
                    localDate = localDate.plusDays(7);
                    i++;
                }
                break;
            } else if (localDate.getDayOfWeek().equals(DayOfWeek.TUESDAY)) {
                while (i < 10) {
                    taskMap.put(localDate, student);
                    localDate = localDate.plusDays(7);
                    i++;
                }
                break;
            } else if (localDate.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)) {
                while (i < 10) {
                    taskMap.put(localDate, student);
                    localDate = localDate.plusDays(7);
                    i++;
                }
                break;
            } else if (localDate.getDayOfWeek().equals(DayOfWeek.THURSDAY)) {
                while (i < 10) {
                    taskMap.put(localDate, student);
                    localDate = localDate.plusDays(7);
                    i++;
                }
                break;
            } else if (localDate.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                while (i < 10) {
                    taskMap.put(localDate, student);
                    localDate = localDate.plusDays(7);
                    i++;
                }
                break;
            } else if (localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                while (i < 10) {
                    taskMap.put(localDate, student);
                    localDate = localDate.plusDays(7);
                    i++;
                }
                break;
            } else if (localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                while (i < 10) {
                    taskMap.put(localDate, student);
                    localDate = localDate.plusDays(7);
                    i++;
                }
                break;
            }
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
