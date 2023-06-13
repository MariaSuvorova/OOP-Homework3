package Homework3;

import java.util.Comparator;

public class SalaryJobTitleComparator implements Comparator<Employee> {
    
    public int compare(Employee o1, Employee o2) {
        int res = Double.compare(o1.calculateSalary(o1.getJobTitle()), o2.calculateSalary(o2.getJobTitle()));
        if (res == 0)
            return o1.getJobTitle().compareTo(o2.getJobTitle());
        else
            return res;
    }

}
