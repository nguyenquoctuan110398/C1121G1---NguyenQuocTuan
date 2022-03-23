package repository.employee;

import model.employee.*;

import java.util.List;

public interface IEmployeeRepository {
    List<EmployeeDTO> selectAllEmployee();

    List<Position> getAllPosition();

    List<EducationDegree> getAllEducation();

    List<Division> getAllDivision();

    void createEmployee(Employee employee);

    Employee selectEmployeeById(Integer id);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(Integer id);

    List<EmployeeDTO> searchEmployeeByName(String search);
}
