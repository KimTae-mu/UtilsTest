package org.alva.Test;

import org.alva.PO.Employee;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Employee> employeeMap = new HashMap<>();
        Employee employee1 = new Employee("one", "first");
        Employee employee2 = new Employee("two", "second");
        Employee employee3 = new Employee("three", "third");
        employeeMap.put("1", employee1);
        employeeMap.put("2", employee2);
        employeeMap.put("3", employee3);

        Employee temp = employeeMap.get("2");
        temp.setName("hello");

        for (Employee employee : employeeMap.values()) {
            System.out.println(employee);
        }
    }

    @Test
    public void testNullKey() {
        Map<String, String> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder("test");
        for (int i = 0; i < 5; i++) {
            map.put(stringBuilder.append(i).toString(), String.valueOf(i));
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        for (String key : map.keySet()) {
            System.out.println("key:[" + key + "]的value为:" + map.get(key));
        }

        String s = map.get("test4");
        if (StringUtils.isEmpty(s)) {
            System.out.println("该key没有value");
        } else {
            System.out.println("key:[test4]的值为:" + s);
        }
    }
}
