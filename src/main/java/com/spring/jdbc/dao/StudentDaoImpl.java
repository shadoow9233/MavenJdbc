package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
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
	
	
	//Selecting multiple object


	public List<Student> getAllStudents() {
		//selecting a multiple student
		String query="SELECT *FROM student";
		List<Student> students=this.jdbcTemplate.query(query,new RowMapperImpl());
		return students;
	}


	
	
	

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



	

	


	

	
	
}
