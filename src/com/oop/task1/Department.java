package com.oop.task1;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentTitle;

    private List<Manager> managers = new ArrayList<>();

    public Department(String departmentTitle) {
        this.departmentTitle = departmentTitle;
    }

    public String getDepartmentTitle() {
        return departmentTitle;
    }

    public void addManager(Manager manager) {
        this.managers.add(manager);
    }

    public void addAllManagers(List<Manager> managers) {
        this.managers.addAll(managers);
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public void giveSalary() {
        System.out.printf("=== Salary day of department %s ===\n", departmentTitle);

        managers.stream().forEach(manager -> {
            System.out.println("\nTeam of manager " + manager);
            manager.takeSalary();
            manager.getTeam().stream().forEach(employee -> {employee.takeSalary();});
            System.out.println();
        });

        System.out.printf("*** End of salary day in department %s. ***\n\n", departmentTitle);
    }
}
