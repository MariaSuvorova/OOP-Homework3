package Homework3;

public class Worker extends Employee {
    
    public Worker(String name, String surname, int age, String jobTitle) {
        super(name, surname, age, jobTitle);
    }

    @Override
    public double calculateSalary(String jobTitle) {
        double salary = getSalaryMonth();
        switch (jobTitle){
            case "worker":
                salary = salary;
                break;
            case "manager":
                salary = salary*1.3;
                break;
            case "accounter":
                salary = salary*1.4;
                break;
            case "boss":
                salary = salary*2;
                break;}
        return salary;
        }

    @Override
    public String toString() {
        return String.format("%s %s возраст %d лет; Рабочий; Заработная плата (фиксированная) на должности %s: %.2f (руб.)",
                surname, name, age ,jobTitle, calculateSalary(jobTitle));
    }

}
