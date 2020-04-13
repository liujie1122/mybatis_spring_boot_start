package com.liujie.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liujie.bean.Employee;
import com.liujie.bean.EmployeeExample;
import com.liujie.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee findById(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    /**
     *    多条件组合查询
     * @param example
     * @return
     */
    public List<Employee> selectByExample(EmployeeExample  example) {
        example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmailLike("%8%");
        EmployeeExample.Criteria criteria1 = example.createCriteria();
        criteria1.andGenderEqualTo("1");
        example.or(criteria1);
        return employeeMapper.selectByExample(example);
    }
    /**
     *    多条件组合分页查询
     * @param
     * @return
     */
    public PageInfo<Employee> queryByPage() {
        PageHelper.startPage(2, 2);
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmailLike("%8%");
        EmployeeExample.Criteria criteria1 = example.createCriteria();
        criteria1.andGenderEqualTo("1");
        example.or(criteria1);
        List<Employee> employees = employeeMapper.selectByExample(example);

        PageInfo<Employee> pageInfo = new PageInfo<Employee>(employees);
        System.out.println(pageInfo);
        return pageInfo;
    }
    public PageInfo<Employee> queryByPage1() {
        PageHelper.startPage(1, 2);

        List<Employee> employees = employeeMapper.selectByExample(null);

        PageInfo<Employee> pageInfo = new PageInfo<Employee>(employees);
        System.out.println(pageInfo);
        return pageInfo;
    }
}
