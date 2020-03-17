package Lyst.service;

import Lyst.DTO.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    public EmployeeDto findById(int employeeId);

    public List<EmployeeDto> GetEmployees();

}
