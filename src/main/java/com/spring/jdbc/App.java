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
        
        //insert query 
        
        
//        Student student = new Student();
//        student.setId(556);
//        student.setName("sani");
//        student.setCity("Kathmandu");   
//        int result = studentDao.insert(student);
//        System.out.println("Student added: " + result);
        
        
        //update query
        
//        Student student = new Student();
//        student.setId(25);
//        student.setName("Black Shadoow");
//        student.setCity("Krishna Tower");
//        int result = studentDao.change(student);
//        System.out.println("Data updated: " + result);
        
        
        //delete record
        int result = studentDao.delete(556);
        System.out.println("Deleted "+result);
     
        
       
        
        
    }
}
