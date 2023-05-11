package com.artem.university.service;

import com.artem.university.entity.Lector;
import com.artem.university.exception.DepartmentException;
import com.artem.university.repository.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.artem.university.exception.DepartmentException.throwDepartmentException;

@Service
@RequiredArgsConstructor
public class LectorServiceImpl implements LectorService {

    private final LectorRepository lectorRepository;

    @Override
    public Integer countLectorsByDepartmentName(String departmentName) throws DepartmentException {
        return lectorRepository.countLectorsByDepartmentName(departmentName)
                .orElseThrow(throwDepartmentException(departmentName));
    }

    @Override
    public List<String> globalSearchByTemplate(String template) {
        return lectorRepository.findByFullNameContaining(template).stream().map(Lector::getFullName).toList();
    }

    @Override
    public Integer calculateAvgSalaryByDepartmentName(String departmentName) throws DepartmentException {
        return lectorRepository.findAverageSalaryByDepartmentName(departmentName)
                .orElseThrow(throwDepartmentException(departmentName));
    }
}
