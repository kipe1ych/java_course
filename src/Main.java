import ru.aston.homework.module2.Book;
import ru.aston.homework.module2.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(
                        "Иванов",
                        Arrays.asList(
                            new Book("Война и мир", 1868, 1300),
                            new Book("Горе от ума", 2017, 400),
                            new Book("Евгений Онегин", 1999, 410),
                            new Book("Беседа пьяного с трезвым чертом", 2016, 420),
                            new Book("Герой нашего времени", 1998, 430)
                        )
                ),
                new Student(
                        "Петров",
                        Arrays.asList(
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
                        Arrays.asList(
                            new Book("Муму", 1995, 490),
                            new Book("Шинель", 2012, 500),
                            new Book("Мертвые души", 2011, 520),
                            new Book("Как закалялась сталь", 1994, 510),
                            new Book("Недоросль", 1993, 530),
                            new Book("Руслан и Людмила", 2010, 540)
                        )
                )
        );

        // При помощи одного (не допускается объявления никаких промежуточных переменных, совсем никаких) стрима:
        students.stream()
                .peek(System.out::println) // Вывести в консоль каждого студента (переопределите toString)
                .flatMap((student)->student.getBooks().stream()) // Получить для каждого студента список книг
                .sorted(Comparator.comparingInt(Book::getPages)) // Отсортировать книги по количеству страниц (Не забывайте про условия для сравнения объектов)
                .distinct() // Оставить только уникальные книги
                .filter((book)->book.getYear() > 2000) // Отфильтровать книги, оставив только те, которые были выпущены после 2000 года
                .limit(3) // Ограничить стрим на 3 элементах
                .map(Book::getYear) // Получить из книг годы выпуска
                .findFirst() // При помощи методов короткого замыкания (почитайте самостоятельно что это такое) вернуть Optional от книги
                .ifPresentOrElse(
                        (year)->System.out.println("Год выпуска книги: " + year),
                        ()->System.out.println("Книга отсутствует")
                ); // При помощи методов получения значения из Optional вывести в консоль год выпуска найденной книги, либо запись о том, что такая книга отсутствует
    }


}