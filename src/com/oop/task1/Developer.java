package com.oop.task1;

public class Developer extends Employee {
    private static double defaultSalary = 2000;
    private Manager manager;

    public Developer(String firstName, String secondName, int years, double salary) {
        super(firstName, secondName, years, salary);
    }

    public Developer(String firstName, String secondName, int years) {
        super(firstName, secondName, years, defaultSalary);
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public double calculateSalary() {
        return getSalary() + bonusForExperience();
    }

    @Override
    public void takeSalary() {
        System.out.printf("Developer %s %s: got salary: %.2f\n", getFirstName(), getSecondName(), calculateSalary());
    }

    @Override
    public String toString() {
        return String.format("%s %s, manager: %s, experience:%d",
                getFirstName(), getSecondName(), manager.getSecondName(), getExperience());
    }
}