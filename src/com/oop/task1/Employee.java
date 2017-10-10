package com.oop.task1;

public abstract class Employee {
    private String firstName;
    private String secondName;
    private int experience;
    private double salary;

    public Employee(String firstName, String secondName, int experience, Double salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        setExperience(experience);
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int years) {
        if(years<0 || years>100) {
            throw new RuntimeException("Trying to set unrealistic experience: %d year(s). Experience must be within 0-80 years.");
        }
        this.experience = years;
    }

    protected double bonusForExperience() {
        double bonus = (experience>2 ? (experience > 5 ? (salary*0.2+500d) : 200d) : 0d);
        return bonus;
    }

    protected void setSalary(double salary) {
        this.salary = salary;
    }

    protected double getSalary() {
        return salary;
    }

    public abstract double calculateSalary();

    public abstract void takeSalary();

}
