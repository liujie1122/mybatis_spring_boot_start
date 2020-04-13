package com.liujie.controller;

import com.github.pagehelper.PageInfo;
import com.liujie.bean.Employee;
import com.liujie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/findById/{id}")
    public Employee example(@PathVariable("id") Integer id){
        System.out.println("id="+id);
        Employee employee = employeeService.findById(id);
        System.out.println(employee);
        return employee;
    }

    @GetMapping("/selectByExample")
    public List<Employee> findById(){
        return employeeService.selectByExample(null);
    }

    @GetMapping("/queryByPage")
    public PageInfo<Employee> queryByPage(){
        return employeeService.queryByPage();
    }


    @GetMapping("/queryByPage1")
    public PageInfo<Employee> queryByPage1(){
        return employeeService.queryByPage1();
    }
}
