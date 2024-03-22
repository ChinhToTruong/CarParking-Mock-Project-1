package com.example.carparking.service.impl;

import com.example.carparking.dto.EmployeeDto;
import com.example.carparking.dto.mapper.EmployeeMapper;
import com.example.carparking.dto.request.EmployeeRegisterRequest;
import com.example.carparking.exception.custom.EmployeeAlreadyExistedException;
import com.example.carparking.exception.custom.EmployeeNotFoundException;
import com.example.carparking.model.Employee;
import com.example.carparking.repository.EmployeeRepository;
import com.example.carparking.service.EmployeeService;
import com.example.carparking.validator.ObjectValidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Log4j2
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final ObjectValidator<EmployeeRegisterRequest> validator;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ObjectValidator validator) {
        this.employeeRepository = employeeRepository;
        this.validator = validator;
    }

    @Override
    public EmployeeDto addEmployee(EmployeeRegisterRequest request) {
        validator.validate(request);
        var employee = employeeRepository.findEmployeeByEmail(request.getEmail());
        if (employee != null) {
            throw new EmployeeAlreadyExistedException("Email already exists");
        }

        employeeRepository.save(EmployeeMapper.getInstance().toEntity(request));
        return EmployeeMapper.getInstance().toDTO(EmployeeMapper.getInstance().toEntity(request));
    }

    @Override
    public Collection<EmployeeDto> getAllEmployees(int pageNo, int record, String property){
        Pageable pageable = PageRequest.of(pageNo, record, Sort.by(property));


        Collection<EmployeeDto> listDto = new ArrayList<EmployeeDto>();
        List<Employee> list = employeeRepository.findAll(pageable).stream().toList();
        list.forEach(employee -> {
            listDto.add(EmployeeMapper.getInstance().toDTO(employee));
        });
        return listDto;
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        var employee = employeeRepository.findEmployeeById(employeeDto.getId());
        if (employee == null) {
            throw new EmployeeNotFoundException("User not found " + employeeDto.getId());
        }
        var newEmployee = new Employee(
                employeeDto.getId(),
                employeeDto.getAccount(),
                employeeDto.getDepartment(),
                employeeDto.getAddress(),
                employeeDto.getDayOfBirth(),
                employeeDto.getEmail(),
                employeeDto.getFullName(),
                employeeDto.getPhone(),
                employeeDto.getPassword(),
                employeeDto.getSex()
        );
        employeeRepository.save(newEmployee);

        return EmployeeMapper.getInstance().toDTO(newEmployee);
    }

    @Override
    public void deleteEmployee(Long id){
        var employee = employeeRepository.findEmployeeById(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("User not found " + id);
        }
        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeDto findEmployeeById(Long id) {
        var employee = employeeRepository.findEmployeeById(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("User not found " + id);
        }

        return EmployeeMapper.getInstance().toDTO(employee);
    }
}
