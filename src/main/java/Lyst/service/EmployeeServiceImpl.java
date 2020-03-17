package Lyst.service;

import Lyst.DTO.EmployeeDto;
import Lyst.model.Employee;
import Lyst.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto findById(int employeeId) {
        Optional<Employee> emp = employeeRepository.findById(employeeId);
        //EmployeeDto empDTO = modelMapper.map(emp, EmployeeDto.class);
        return new EmployeeDto(emp.get().getId()
                ,emp.get().getName()
                ,null);
    }

    @Override
    public List<EmployeeDto> GetEmployees() {
        return modelMapper.map(employeeRepository.findAll(), new TypeToken<List<EmployeeDto>>(){}.getType());
    }
}
