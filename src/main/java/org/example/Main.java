package org.example;

import java.io.*;


public class Main {
    public static void main(String[] args) {
        // Создание объекта Student
        Student student = new Student("John Doe", 20, 3.8);

        // Сериализация объекта в файл
        try {
            FileOutputStream fileOut = new FileOutputStream("student.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(student);
            out.close();
            fileOut.close();
            System.out.println("Объект успешно сериализован в файл student.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализация объекта из файла
        try {
            FileInputStream fileIn = new FileInputStream("student.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Student deserializedStudent = (Student) in.readObject();
            in.close();
            fileIn.close();

            // Вывод полей объекта
            System.out.println("Имя: " + deserializedStudent.getName());
            System.out.println("Возраст: " + deserializedStudent.getAge());
            System.out.println("Средний балл: " + deserializedStudent.getGPA());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}