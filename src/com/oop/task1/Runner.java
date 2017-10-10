package com.oop.task1;

import java.util.Arrays;

/*
Create structure for department:
There are 3 types of employee: developer, designer and manager
Each employee has: first name, second name, salary, experiance (years) and manager
Each designer has effectivness coefficient(0-1)
Each manager has team of developers and designers.
Department.json should have list of managers(which have their own teams)
Department.json should be able to give salary
(for each employee message: "@firstName@ @secondName@: got salary: @salaryValue@")
Each employee gets the salary, defined in field Salary.
If experiance of employee is > 2 years, he gets bonus + 200$, if experiance is > 5 years, he gets salary*1.2 + bonus 500
Each designer gets the salary = salary*effCoeff
Each manager gets salary +
200$ if his team has >5 members
300$ if his team has >10 members
salary*1.1 if more than half of team members are developers.
Redefine string representation for employee as follows:
"@firstName@ @secondName@, manager:@manager secondName@, experiance:@experiance@"
 */
public class Runner {
    public static void main(String[] args) {
        Manager manager1 = new Manager("FirstName1", "SecondName1", 4, 3003d);
        Designer designer2 = new Designer("FirstName2", "SecondName2", 0, 2020d);
        designer2.setEffectivnessCoefficient(0.9);
        Designer designer3 = new Designer("FirstName4", "SecondName4", 3, 2020d);
        designer3.setEffectivnessCoefficient(0.9);
        Developer developer4 = new Developer("FirstName4", "SecondName4", 10, 2022d);
        manager1.addAllEmployees(Arrays.asList(designer2, designer3, developer4));
        Department department1 = new Department("dep1");
        department1.addManager(manager1);

        Manager manager5 = new Manager("FirstName5", "SecondName5", 4, 3003d);
        Designer designer6 = new Designer("FirstName6", "SecondName6", 0, 2020d);
        Developer developer7 = new Developer("FirstName7", "SecondName7", 10, 2022d);
        manager5.addAllEmployees(Arrays.asList(designer6, developer7));
        Department department2 = new Department("dep2");
        department2.addManager(manager5);

        department1.giveSalary();
        department2.giveSalary();
    }
}





