package com.oop.task1;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    private static double defaultSalary = 3000;
    //private List<Designer> designers = new ArrayList<>();
    //private List<Developer> developers = new ArrayList<>();
    private List<Employee> team = new ArrayList<>();

    public Manager(String firstName, String secondName, int years, Double salary) {
        super(firstName, secondName, years, salary);
    }

    public Manager(String firstName, String secondName, int years) {
        super(firstName, secondName, years, defaultSalary);
    }

    public void addEmployee(Employee employee) throws Exception {
        if(employee instanceof Designer) {
            ((Designer) employee).setManager(this);
            team.add(employee);
        } else if(employee instanceof Developer) {
            ((Developer) employee).setManager(this);
            team.add(employee);
        } else {
            throw new Exception(employee + " - wrong employee type. Only following employees can be added: Designer, Developer");
        }
    }

    public void addAllEmployees(List<Employee> employees) {
        employees.forEach(employee -> {
            try {
                addEmployee(employee);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public List<Employee> getTeam() {
        return team;
    }

    // if more than half of team members are developers.
    private boolean areDevelopersMoreThanHalf() {
        long developersCount = team.stream().filter(employee-> employee instanceof Developer).count();
        return (int)developersCount > team.size()/2;
    }

    @Override
    public double calculateSalary() {

        double calculatedSalary =
                getSalary() +
                        bonusForExperience() +
                        (team.size() > 5 ? (team.size()>10? 300d : 200d) : 0d) +
                        (areDevelopersMoreThanHalf()== true ? getSalary()*0.1 : 0d);
        return calculatedSalary;
    }

    @Override
    public void takeSalary() {
        System.out.printf("Manager %s %s: got salary: %.2f\n", getFirstName(), getSecondName(), calculateSalary());
    }

    @Override
    public String toString() {
        return String.format("%s %s, experience:%d",
                getFirstName(), getSecondName(), getExperience());
    }
}