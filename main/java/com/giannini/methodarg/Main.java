package com.giannini.methodarg;

/**
 * Created by Fenglin on 2017/6/21.
 */
public class Main {

    public static void changeEmployee(Employee employee)
    {
        employee = new Employee();
        employee.age = 1000;
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.age = 100;
        changeEmployee(employee);
        System.out.println(employee.age);

    }

    public static class Employee {
        public int age;
    }
}
