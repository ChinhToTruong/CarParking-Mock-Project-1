package com.example.carparking.service.impl;

import com.example.carparking.dto.EmployeeDto;
import com.example.carparking.dto.mapper.EmployeeMapper;
import com.example.carparking.dto.request.EmployeeRegisterRequest;
import com.example.carparking.exception.custom.EmployeeAlreadyExistedException;
import com.example.carparking.exception.custom.UserNotFoundException;
import com.example.carparking.model.Employee;
import com.example.carparking.repository.EmployeeRepository;
import com.example.carparking.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Log4j2
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto addEmployee(EmployeeRegisterRequest request){
        var employee = employeeRepository.findEmployeeByEmail(request.getEmail());
        if (employee != null) {
            throw new EmployeeAlreadyExistedException("Email already exists");
        }
        employeeRepository.save(EmployeeMapper.getInstance().toEntity(request));
        return EmployeeMapper.getInstance().toDTO(EmployeeMapper.getInstance().toEntity(request));
    }

    @Override
    public Collection<EmployeeDto> getAllEmployees(){
        Collection<EmployeeDto> listDto = new ArrayList<EmployeeDto>();
        List<Employee> list = employeeRepository.findAll();
        list.forEach(employee -> {
            listDto.add(EmployeeMapper.getInstance().toDTO(employee));
        });
        return listDto;
    }

    @Override
    public void deleteEmployee(Long id){
        var employee = employeeRepository.findEmployeeById(id);
        if (employee == null) {
            throw new UserNotFoundException("User not found " + id);
        }
        employeeRepository.delete(employee);
    }
}
