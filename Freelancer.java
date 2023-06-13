package Homework3;

/**
 * TODO: Спроектировать класс Freelancer самостоятельно в рамках домашнего задания.
 *  *20*8
 */
public class Freelancer extends Employee{
    
    protected int hours;

    
public Freelancer(String name, String surname, int age, String jobTitle, int hours) {
        super(name, surname, age, jobTitle);
        this.hours = hours;
    }

    @Override
    public double calculateSalary(String jobTitle) {
        double salary = getSalaryMonth();
        switch (jobTitle){
            case "programmer":
                salary = salary*1.5;
                break;
            case "tester":
                salary = salary*1.1;
                break;
            case "analytic":
                salary = salary*1.5;
                break;
        }
        return (salary*hours)/168;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return String.format("%s %s возраст %d лет; Freelancer; Заработная плата (за %d часов) на должности %s: %.2f (руб.)",
                surname, name, age, hours, jobTitle, calculateSalary(jobTitle));
    }

}

