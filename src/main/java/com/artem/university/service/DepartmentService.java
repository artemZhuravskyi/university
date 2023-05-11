package com.artem.university.service;

import com.artem.university.entity.Department;
import com.artem.university.enums.Degree;
import com.artem.university.exception.DepartmentException;

import java.util.Map;

public interface DepartmentService {

    String findHeadByDepartmentName(String name) throws DepartmentException;
    Map<Degree, Integer> showStatisticsByDepartmentName(String name) throws DepartmentException;
    Department findByName(String name) throws DepartmentException;
}
