package tech.getarrays.employeemanager.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
private final EmployeeRepo employeeRepo ;

@Autowired

public EmployeeService(EmployeeRepo employeeRepo) {
	this.employeeRepo = employeeRepo;
}
public Employee addEmployee(Employee employee) {
	employee.setEmployeeCode(UUID.randomUUID().toString());
	return employeeRepo.save(employee);
}
public List<Employee> FindAllEmployees(){
	return employeeRepo.findAll();
}
public Employee UpdateEmployee(Employee employee) {
	return employeeRepo.save(employee);
}

public Employee findEmployeeById(Long id) {
	return employeeRepo.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("Id :" + id + "not founded"));
			
}

public void deleteEmployeeById(Long id) {
	employeeRepo.deleteEmployeeById(id);
}

	

}
