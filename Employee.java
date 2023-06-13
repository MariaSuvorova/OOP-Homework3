package Homework3;

public abstract class Employee implements Comparable<Employee> {

    protected String name;
    protected String surname;
    protected int age;
    protected String jobTitle;
    private static double salaryMonth = 50000; // Ставка заработной платы

    public Employee(String name, String surname, int age, String jobTitle) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.jobTitle = jobTitle;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    
    public static double getSalaryMonth() {
        return salaryMonth;
    }

    /**
     * Расчет среднемесячной заработной платы
     * @return
     */
    public abstract double calculateSalary(String jobTitle);
    

    @Override
    public int compareTo(Employee o) {
        int res = surname.compareTo(o.surname);
        if (res == 0)
            return Double.compare(calculateSalary(jobTitle), o.calculateSalary(jobTitle));
        else
            return res;
    }
    }

    

