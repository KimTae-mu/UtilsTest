package org.alva.Guava;

import com.google.common.base.Function;
import com.google.common.collect.*;
import org.alva.PO.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class MultiMapTest {

    @Test
    public void testMult(){
        List<Employee> test = new ArrayList();
        test.add(new Employee("zzz","12"));
        test.add(new Employee("zzz","12"));
        test.add(new Employee("zzz","14"));
        test.add(new Employee("ccc","12"));
        test.add(new Employee("ccc","13"));
        test.add(new Employee("ccc","15"));

        Map<Employee, String> employeeStringImmutableMap = Maps.toMap(test, new Function<Employee, String>() {
            @Override
            public String apply(Employee employee) {
                return employee.getName();
            }
        });

        /*for (Employee value : index.values()) {
            System.out.println(value);
        }*/
        System.out.println(employeeStringImmutableMap.size());


    }
}
