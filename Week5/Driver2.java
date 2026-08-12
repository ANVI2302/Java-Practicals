public class Driver2 {

    public static void main(String[] args) {

        Employee[] employees = {
            new FullTime("Krisha", 101, 50000),
            new PartTime("Diya", 102, 80, 300),
            new Intern("Ishita", 103, 15000)
        };

        double total = 0;

        for (Employee e : employees) {

            double salary = e.monthlySalary();

            System.out.println(
                e.name + " Salary: " + salary
            );

            total += salary;

            if (e instanceof Intern) {
                System.out.println("This is an Intern.");
            }
        }

        System.out.println("Total Salary: " + total);
    }
}