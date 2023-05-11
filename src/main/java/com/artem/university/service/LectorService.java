package com.artem.university.service;

import com.artem.university.exception.DepartmentException;

import java.util.List;

public interface LectorService {

    Integer countLectorsByDepartmentName(String departmentName) throws DepartmentException;
    List<String> globalSearchByTemplate(String template);
    Integer calculateAvgSalaryByDepartmentName(String departmentName) throws DepartmentException;
}
