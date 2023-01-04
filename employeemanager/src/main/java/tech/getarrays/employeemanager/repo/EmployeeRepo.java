package tech.getarrays.employeemanager.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.getarrays.employeemanager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	@Transactional
	void deleteEmployeeById(Long id);

	Optional<Employee> findEmployeeById(Long id);

}
