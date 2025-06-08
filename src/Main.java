import ru.aston.homework.module2.Book;
import ru.aston.homework.module2.Student;
import ru.aston.homework.module3.FileActions;
import ru.aston.homework.module3.FileActionsException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "data.txt";
        List<String> dataToWrite = Arrays.asList(
                "Первая строка",
                "Вторая строка",
                "Третья строка"
        );

        try {
            FileActions.writeToFile(filePath, dataToWrite);
            System.out.println("Данные успешно записаны в файл");
        } catch (FileActionsException e) {
            System.err.println("Ошибка при записи: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            List<String> readData = FileActions.readFromFile(filePath);
            System.out.println("\nСодержимое файла:");
            readData.forEach(System.out::println);
        } catch (FileActionsException e) {
            System.err.println("Ошибка при чтении: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void showModule2() {
        List<Student> students = List.of(
                new Student(
                        "Иванов",
                        List.of(
                                new Book("Война и мир", 1868, 1300),
                                new Book("Горе от ума", 2017, 400),
                                new Book("Евгений Онегин", 1999, 410),
                                new Book("Беседа пьяного с трезвым чертом", 2016, 420),
                                new Book("Герой нашего времени", 1998, 430)
                        )
                ),
                new Student(
                        "Петров",
                        List.of(
                                new Book("Чудесный доктор", 2015, 440),
                                new Book("Преступление и наказание", 1997, 450),
                                new Book("Ревизор", 2013, 480),
                                new Book("Идиот", 2014, 460),
                                new Book("Зеленая лампа", 1996, 470),
                                new Book("Шинель", 2012, 500), // дубль книги
                                new Book("Евгений Онегин", 1999, 410) // дубль книги
                        )
                ),
                new Student(
                        "Сидоров",
                        List.of(
                                new Book("Муму", 1995, 490),
                                new Book("Шинель", 2012, 500),
                                new Book("Мертвые души", 2011, 520),
                                new Book("Как закалялась сталь", 1994, 510),
                                new Book("Недоросль", 1993, 530),
                                new Book("Руслан и Людмила", 2010, 540)
                        )
                )
        );

        students.stream()
                .peek(System.out::println)
                .flatMap((student)->student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter((book)->book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        (year)->System.out.println("Год выпуска книги: " + year),
                        ()->System.out.println("Книга отсутствует")
                );
    }
}