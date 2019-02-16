package leetcode;

import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/employee-importance/
 */
public class EmployeeImportance {

    // Employee info
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        /*
            Time Complexity - O(n) where n is the number of employees in the list (potentially have to loop through all)
            Space Complexity - O(n)
         */
        HashMap<Integer, Employee> idToEmployeeMapping = new HashMap<>();

        for (Employee e : employees) {
            idToEmployeeMapping.put(e.id, e);
        }

        return getImportance(idToEmployeeMapping.get(id), idToEmployeeMapping);
    }

    private int getImportance(Employee e, HashMap<Integer, Employee> idToEmployeeMapping) {
        int importance = 0;
        for (int i = 0; i < e.subordinates.size(); i++) {
            Employee subordinate = idToEmployeeMapping.get(e.subordinates.get(i));
            importance += getImportance(subordinate, idToEmployeeMapping);
        }
        return e.importance + importance;
    }
}
