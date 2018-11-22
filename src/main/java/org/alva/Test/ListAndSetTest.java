package org.alva.Test;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import org.alva.PO.Employee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class ListAndSetTest {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee("one","first");
        Employee employee2 = new Employee("two","second");
        Employee employee3 = new Employee("three","third");
        Employee employee4 = new Employee("one","foruth");
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        List<String> employeeNames = new ArrayList<>();
        employeeNames = FluentIterable.from(employees).transform(new Function<Employee, String>() {
            @Override
            public String apply(Employee employee) {
                return employee.getName();
            }
        }).toList();

        for (String name : employeeNames){
            System.out.println("---"+name+"---");
        }
        Set<String> emNameSet = new HashSet<>(employeeNames);
        for (String name : emNameSet){
            System.out.println("==="+name+"===");
        }
        employeeNames = new ArrayList<>(emNameSet);
        for (String name : employeeNames){
            System.out.println("---"+name+"---");
        }
        //
        System.out.println(employeeNames.size() != new HashSet<String>(employeeNames).size());

    }
}
