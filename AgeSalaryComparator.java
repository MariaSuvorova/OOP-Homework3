package Homework3;

import java.util.Comparator;

public class AgeSalaryComparator implements Comparator<Employee> {

    public int compare(Employee o1, Employee o2) {
        int res = o1.age - o2.age;
        if (res == 0)
            return Double.compare(o1.calculateSalary(o1.getJobTitle()), o2.calculateSalary(o2.getJobTitle()));
        else
            return res;
    }
}
