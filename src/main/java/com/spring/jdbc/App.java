package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        // Spring JDBC => JdbcTemplate
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
        Student student = new Student();
        student.setId(555);
        student.setName("sani");
        student.setCity("Kathmandu");   
        int result = studentDao.insert(student);
        System.out.println("Student added: " + result);
    }
}
