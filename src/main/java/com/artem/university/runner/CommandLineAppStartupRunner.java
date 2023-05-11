package com.artem.university.runner;

import com.artem.university.enums.Degree;
import com.artem.university.exception.DepartmentException;
import com.artem.university.service.DepartmentService;
import com.artem.university.service.LectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.artem.university.enums.Degree.ASSISTANT;
import static com.artem.university.enums.Degree.ASSOCIATE_PROFESSOR;
import static com.artem.university.enums.Degree.PROFESSOR;
import static com.artem.university.message.CLIMessages.ASSISTANTS;
import static com.artem.university.message.CLIMessages.ASSOCIATE_PROFESSORS;
import static com.artem.university.message.CLIMessages.EMPLOYEE_COUNT;
import static com.artem.university.message.CLIMessages.ENTER_THE_NAME_OF_THE_DEPARTMENT;
import static com.artem.university.message.CLIMessages.ENTER_THE_SEARCH_TEMPLATE;
import static com.artem.university.message.CLIMessages.ENTER_YOUR_CHOICE;
import static com.artem.university.message.CLIMessages.EXIT;
import static com.artem.university.message.CLIMessages.GLOBAL_SEARCH;
import static com.artem.university.message.CLIMessages.HEAD_OF_DEPARTMENT;
import static com.artem.university.message.CLIMessages.INVALID_INPUT_TYPE_GIVEN_NUMBERS_TO_INTERACT;
import static com.artem.university.message.CLIMessages.LECTORS_FOUND;
import static com.artem.university.message.CLIMessages.NO_SEARCH_RESULTS_FOUND;
import static com.artem.university.message.CLIMessages.PLEASE_SELECT_AN_OPTION;
import static com.artem.university.message.CLIMessages.PROFESSORS;
import static com.artem.university.message.CLIMessages.SHOW_AVERAGE_SALARY_FOR_A_DEPARTMENT;
import static com.artem.university.message.CLIMessages.SHOW_COUNT_OF_EMPLOYEES_FOR_A_DEPARTMENT;
import static com.artem.university.message.CLIMessages.SHOW_DEPARTMENT_HEAD;
import static com.artem.university.message.CLIMessages.SHOW_DEPARTMENT_STATISTICS;
import static com.artem.university.message.CLIMessages.STATISTICS_FOR_DEPARTMENT;
import static com.artem.university.message.CLIMessages.THANK_YOU_FOR_USING_THE_UNIVERSITY_CONSOLE_APPLICATION_GOODBYE;
import static com.artem.university.message.CLIMessages.THE_AVERAGE_SALARY;
import static com.artem.university.message.CLIMessages.TOTAL_LECTORS_FOUND;
import static com.artem.university.message.CLIMessages.WELCOME_TO_THE_UNIVERSITY_CONSOLE_APPLICATION;

@Component
@RequiredArgsConstructor
public class CommandLineAppStartupRunner implements CommandLineRunner {


    private final DepartmentService departmentService;
    private final LectorService lectorService;

    @Override
    public void run(String... args) {
        System.out.println(WELCOME_TO_THE_UNIVERSITY_CONSOLE_APPLICATION);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String input = scanner.nextLine();
            try {
                switch (input) {
                    case "1" -> showDepartmentHead(scanner);
                    case "2" -> showDepartmentStatistics(scanner);
                    case "3" -> showAverageSalary(scanner);
                    case "4" -> showEmployeeCount(scanner);
                    case "5" -> globalSearch(scanner);
                    case "0" -> {
                        System.out.println(THANK_YOU_FOR_USING_THE_UNIVERSITY_CONSOLE_APPLICATION_GOODBYE);
                        return;
                    }
                    default -> System.out.println(INVALID_INPUT_TYPE_GIVEN_NUMBERS_TO_INTERACT);
                }
            } catch (DepartmentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printMenu() {
        System.out.println(PLEASE_SELECT_AN_OPTION);
        System.out.println(SHOW_DEPARTMENT_HEAD);
        System.out.println(SHOW_DEPARTMENT_STATISTICS);
        System.out.println(SHOW_AVERAGE_SALARY_FOR_A_DEPARTMENT);
        System.out.println(SHOW_COUNT_OF_EMPLOYEES_FOR_A_DEPARTMENT);
        System.out.println(GLOBAL_SEARCH);
        System.out.println(EXIT);
        System.out.print(ENTER_YOUR_CHOICE);
    }

    private void showDepartmentHead(Scanner scanner) throws DepartmentException {
        System.out.print(ENTER_THE_NAME_OF_THE_DEPARTMENT);
        String departmentName = scanner.nextLine();
        String departmentHead = departmentService.findHeadByDepartmentName(departmentName);
        System.out.printf(HEAD_OF_DEPARTMENT, departmentName, departmentHead);
    }

    private void showDepartmentStatistics(Scanner scanner) throws DepartmentException {
        System.out.print(ENTER_THE_NAME_OF_THE_DEPARTMENT);
        String departmentName = scanner.nextLine();
        Map<Degree, Integer> degreeCountMap = departmentService.showStatisticsByDepartmentName(departmentName);

        int assistantsCount = degreeCountMap.get(ASSISTANT);
        int associateProfessorsCount = degreeCountMap.get(ASSOCIATE_PROFESSOR);
        int professorsCount = degreeCountMap.get(PROFESSOR);

        System.out.printf(STATISTICS_FOR_DEPARTMENT, departmentName);
        System.out.printf(ASSISTANTS, assistantsCount);
        System.out.printf(ASSOCIATE_PROFESSORS, associateProfessorsCount);
        System.out.printf(PROFESSORS, professorsCount);
    }

    private void showAverageSalary(Scanner scanner) throws DepartmentException {
        System.out.print(ENTER_THE_NAME_OF_THE_DEPARTMENT);
        String departmentName = scanner.nextLine();
        int averageSalary = lectorService.calculateAvgSalaryByDepartmentName(departmentName);

        System.out.printf(THE_AVERAGE_SALARY, departmentName, averageSalary);
    }

    private void showEmployeeCount(Scanner scanner) throws DepartmentException {
        System.out.print(ENTER_THE_NAME_OF_THE_DEPARTMENT);
        String departmentName = scanner.nextLine();
        int employeeCount = lectorService.countLectorsByDepartmentName(departmentName);
        System.out.printf(EMPLOYEE_COUNT, departmentName, employeeCount);
    }

    private void globalSearch(Scanner scanner) {
        System.out.print(ENTER_THE_SEARCH_TEMPLATE);
        String template = scanner.nextLine();
        List<String> searchResults = lectorService.globalSearchByTemplate(template);
        if (searchResults.isEmpty()) {
            System.out.println(NO_SEARCH_RESULTS_FOUND);
        } else {
            System.out.printf(LECTORS_FOUND, String.join(", ", searchResults));
            System.out.printf(TOTAL_LECTORS_FOUND, searchResults.size());
        }

    }
}

