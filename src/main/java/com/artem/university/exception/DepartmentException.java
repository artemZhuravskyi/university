package com.artem.university.exception;

import java.util.function.Supplier;

public class DepartmentException extends Exception{

    private static final String NO_DEPARTMENT_FOUND = "No department %s found";

    public DepartmentException(String errorMessage) {
        super(errorMessage);
    }
    public static Supplier<DepartmentException> throwDepartmentException(String departmentName) {
        return () -> new DepartmentException(NO_DEPARTMENT_FOUND.formatted(departmentName));
    }
}
