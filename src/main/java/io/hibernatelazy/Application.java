package io.hibernatelazy;

import static io.hibernatelazy.util.QueryUtil.findAllStudents;

import java.util.List;

import io.hibernatelazy.entity.Student;

public class Application {

    public static void main(String... args) {

        // load all students - lazy load address
        List<Student> studentList = findAllStudents();

        studentList.forEach(System.out::println);
    }
}
