package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;

    public int insert(Student student) {
        // Define the SQL query for insertion
        String query = "INSERT INTO student (Id, name, city) VALUES (?, ?, ?)";
        // Directly return the result of the update method
        int r= jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return r;
    }
    
    
    public int change(Student student) {
		// updated query 
    	String query = "UPDATE student SET name=?, city=? WHERE Id=?";
        int r = jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return r;
	}
    
   
	public int delete(int studentId) {
		// deleted record from database 
		String query ="DELETE FROM student WHERE Id=?";
		int r=this.jdbcTemplate.update(query,studentId);
		return r;
	}
	
	//to get a single object 
	
	public Student getStudent(int studentId) {
	    // Selected single student data 
	    String query = "SELECT * FROM student WHERE id=?";
	    RowMapper<Student> rowMapper=new RowMapperImpl();
	    // Assuming jdbcTemplate is an instance of JdbcTemplate
	   Student student= this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
	    return student;
	    		
	}

	
	
	

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


	

	


	

	
	
}
