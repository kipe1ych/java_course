package ru.aston.homework.module3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileActions {

    /**
     * Записывает список строк в файл по указанному пути.
     *
     * @param filePath Путь к файлу
     * @param data     Список строк для записи
     * @throws FileActionsException если произошла ошибка ввода-вывода
     */
    public static void writeToFile(String filePath, List<String> data) throws FileActionsException {
        validateFilePath(filePath);
        if(data == null) throw new FileActionsException("Переданы пустые данные");

        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8))) {
            for(String line : data) {
                writer.write(line);
                writer.newLine();
            }
        } catch(IOException e) {
            throw new FileActionsException("Ошибка записи в файл: " + filePath, e);
        }
    }

    /**
     * Записывает одну строку в файл.
     *
     * @param filePath Путь к файлу
     * @param data     Строка для записи
     * @throws FileActionsException если произошла ошибка ввода-вывода
     */
    public static void writeToFile(String filePath, String data) throws FileActionsException {
        if(data == null) throw new FileActionsException("Содержимое не может быть пустым");
        writeToFile(filePath, List.of(data));
    }

    /**
     * Читает содержимое файла по указанному пути.
     *
     * @param filePath Путь к файлу
     * @return Список строк из файла
     * @throws FileActionsException если произошла ошибка чтения
     */
    public static List<String> readFromFile(String filePath) throws FileActionsException {
        validateFileExists(filePath);

        List<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line;
            while((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch(IOException e) {
            throw new FileActionsException("Ошибка чтения файла: " + filePath, e);
        }

        return lines;
    }

    /**
     * Проверяет существование файла
     * @param filePath путь к файлу
     * @return true если файл существует и это именно файл (не директория)
     * @throws FileActionsException если путь невалиден
     */
    public static boolean fileExists(String filePath) throws FileActionsException {
        validateFilePath(filePath);
        File file = new File(filePath);

        return file.exists() && file.isFile();
    }

    /**
     * Проверяет валидность пути к файлу
     * @param filePath путь к файлу
     * @throws FileActionsException если путь невалиден
     */
    private static void validateFilePath(String filePath) throws FileActionsException {
        if(filePath == null || filePath.trim().isEmpty()) throw new FileActionsException("Путь к файлу не может быть пустым");
    }

    /**
     * Проверяет существование файла
     * @param filePath путь к файлу
     * @throws FileActionsException если файл не существует
     */
    private static void validateFileExists(String filePath) throws FileActionsException {
        if(!fileExists(filePath)) throw new FileActionsException("Файл не существует: " + filePath);
    }
}
