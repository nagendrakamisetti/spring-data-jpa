package com.example.paginationsorting.service;

import com.example.paginationsorting.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.userRepository = employeeRepository;
    }

    private final EmployeeRepository userRepository;
/*
    public User createUser(User user) {
        // userRepository.save(user);
        User resultUser = userRepository.saveAndFlush(user);
        System.out.println(user);
        return resultUser;
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }*/
}
