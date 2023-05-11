package com.artem.university.service;

import com.artem.university.entity.Department;
import com.artem.university.entity.Lector;
import com.artem.university.enums.Degree;
import com.artem.university.exception.DepartmentException;
import com.artem.university.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.artem.university.exception.DepartmentException.throwDepartmentException;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public String findHeadByDepartmentName(String departmentName) throws DepartmentException {
        return departmentRepository.findHeadByDepartmentName(departmentName)
                .orElseThrow(throwDepartmentException(departmentName))
                .getFullName();
    }

    @Override
    public Map<Degree, Integer> showStatisticsByDepartmentName(String departmentName) throws DepartmentException {
        Department department = findByName(departmentName);

        Set<Lector> lectors = department.getLectors();

        return lectors
                .stream()
                .collect(Collectors.toMap(Lector::getDegree, value -> 1, Integer::sum));
    }

    @Override
    public Department findByName(String departmentName) throws DepartmentException {
        return departmentRepository.findByName(departmentName).orElseThrow(throwDepartmentException(departmentName));
    }
}
