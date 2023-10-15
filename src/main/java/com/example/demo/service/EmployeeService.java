package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Employee;
import com.example.demo.models.RaponseCutomize;
import com.example.demo.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> list() {
        return employeeRepository.findAll();
    }
	
	
	//INSERT EMPLOYEE
	public RaponseCutomize AddEmployee(Employee employee) {
		RaponseCutomize re = new RaponseCutomize();
		re.setSuccess(true);
		re.setMessege("Add user successful");
		try { 
			Employee exist = employeeRepository.employeeExits(employee.getUsername());
			if (exist == null) {
				int save = employeeRepository.addEmployee(employee.getId(),employee.getUsername());
			} else {
//				re.setUsername("UserExist");
				re.setSuccess(false);
				re.setMessege("UserExist");
			}
//			
		} catch (Exception ex) {
//			System.out.println(ex);
			re.setSuccess(false);
			re.setMessege(ex.getMessage());
		}
		return re;
		
	}
	
	//UPDATE Employee
	public RaponseCutomize UpdateUsername(String username, long id) {
//		RsponseCustomize re = "Reset password faild";
		RaponseCutomize re = new RaponseCutomize();
		re.setSuccess(false);
		re.setMessege("Update Username faild");
		try { 
			int changeUsername = employeeRepository.updateUsername(username, id);
			if (changeUsername != 0) {
				re.setSuccess(true);
				re.setMessege("Update Username successfull!");
//				re = "Reset Password successfull!";
			}
		
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return re;
		
	}
	
	//DELETE EMPLOYEE
	public RaponseCutomize DeleteEmployee(long id) {
		RaponseCutomize re = new RaponseCutomize();
		re.setSuccess(false);
		re.setMessege("Delete user faild!");
		try { 
			int deleteEmployee = employeeRepository.deletEmployee(id);
			if (deleteEmployee > 0) {
				re.setSuccess(false);
				re.setMessege("Delete success");
			}
		
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return re;
		
	}
}
