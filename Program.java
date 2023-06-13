package Homework3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Program {

    static Random random = new Random();

    /**
     * TODO: Переработать метод generateEmployee в рамках домашнего задания,
     *  метод должен генерировать рабочих (Employee) разных типов.
     * @return
     */
    //  метод генерации сотрудника(случайного worker или freelancer)
    static Employee generateEmployee(){
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };
        int age = random.nextInt(20, 60);
        String[] jobTitleWorkers = new String[] { "worker", "manager", "accounter", "boss"};
        String[] jobTitleFreelancers = new String[] { "programmer", "tester", "analytic"};

        if (random.nextInt(0, 2) == 0) {
            String name = names[random.nextInt(names.length)];
            String surname = surnames[random.nextInt(surnames.length)];
            String jobTitle = jobTitleWorkers[random.nextInt(jobTitleWorkers.length)];
            Worker worker = new Worker(name, surname, age, jobTitle);
            worker.calculateSalary(jobTitle);
            return worker;
        }
        else {
            String name = names[random.nextInt(names.length)];
            String surname = surnames[random.nextInt(surnames.length)];
            String jobTitle = jobTitleFreelancers[random.nextInt(jobTitleFreelancers.length)];
            int hours = random.nextInt(20, 168);
            Freelancer freelancer = new Freelancer(name, surname, age, jobTitle, hours);
            freelancer.calculateSalary(jobTitle);
            return freelancer;
        }
    }
    /**
     * TODO: Придумать новые состояния для наших сотрудников
     *  Придумать несколько Comparator'ов для сортировки сотрудников
     *  по фамилии + имени или по возрасту и уровню ЗП.
     * @param args
     */

    public static void main(String[] args) {

        //  генерация списка сотрудников
        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++){
            employees[i] = generateEmployee();
        }
        for(Employee employee : employees){
            System.out.println(employee);
        }
        // сортировка по выбранным параметрам
        Scanner scanner = new Scanner(System.in,"866");
        System.out.println("Как сортируем:\n 1-фамилия-зарплата\n 2-возраст-зарплата\n 3-зарплата-должность");
        String str = scanner.nextLine();
        int choice = Integer.parseInt(str);
        System.out.println("сортировка по убыванию?");
        String str1 = scanner.nextLine();
        boolean order = false;
        if (str1.equals("да")) order = true;
        scanner.close();
        
        switch (choice){
            case 1:
                System.out.println("Сортировка по умолчанию (фамилия-зарплата):");
                if (order == true) Arrays.sort(employees, Collections.reverseOrder());
                else Arrays.sort(employees);
                break;
            case 2:
                System.out.println("Сортировка по: возраст-зарплата:");
                Comparator ageSalaryComparator = new AgeSalaryComparator();
                if (order == true) Arrays.sort(employees, Collections.reverseOrder(ageSalaryComparator));
                else Arrays.sort(employees, ageSalaryComparator);
                break;
            case 3:
                System.out.println("Сортировка по: зарплата-должность:");
                Comparator salaryTitleComparator = new SalaryJobTitleComparator();
                if (order == true) Arrays.sort(employees, Collections.reverseOrder(salaryTitleComparator));
                else Arrays.sort(employees, salaryTitleComparator);
                break;
        }
        for(Employee employee : employees){
            System.out.println(employee);
        }
    }
}
