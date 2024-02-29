package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        // Spring JDBC => JdbcTemplate
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
        //insert query 
        
        
        Student student = new Student();
        student.setId(101);
        student.setName("Kalu");
        student.setCity("Achham");   
        int result = studentDao.insert(student);
        System.out.println("Student added: " + result);
        
        //update query
        
//        Student student = new Student();
//        student.setId(25);
//        student.setName("Black Shadoow");
//        student.setCity("Krishna Tower");
//        int result = studentDao.change(student);
//        System.out.println("Data updated: " + result);
        
        
        //delete record
//        int result = studentDao.delete(556);
//        System.out.println("Deleted "+result);
        
        //single object call
        
//        Student student=studentDao.getStudent(111);
//        System.out.println(student);
        
        //multiple object call
        List<Student> students = studentDao.getAllStudents();
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
