package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long>{

	@Query(value= "SELECT * FROM employees", nativeQuery=true)
	List<Employee> employeeList();
	
//	SELECT
	@Query(value= "SELECT * FROM employees WHERE username =?1", nativeQuery=true)
	Employee employeeExits(String username);
	
//	INSERT 
	@Modifying(clearAutomatically=true)
	@Query(value= "INSERT INTO employees (id, username) VALUES (?1, ?2)", nativeQuery=true)
	int addEmployee(long id, String username);
	
//	Update
	@Modifying(clearAutomatically=true)
	@Query(value= "UPDATE employees SET username = ?1 WHERE id = ?2", nativeQuery=true)
	int updateUsername(String username,long id);
	
	//Delete
	@Modifying(clearAutomatically=true)
	@Query(value= "DELETE FROM employees WHERE id=?1", nativeQuery=true)
	int deletEmployee(long id);
}
