import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] amounts = {1200, 2500, 3500, 4800};

        System.out.println("Select a discount:");
        System.out.println("1. 5 percent");
        System.out.println("2. 15 percent");
        System.out.println("3. Flat Rs. 150");

        System.out.print("Choice: ");
        int choice = input.nextInt();

        DiscountRule selected;

        if (choice == 1) {
            selected = amount -> amount * 0.95;
        } else if (choice == 2) {
            selected = amount -> amount * 0.85;
        } else if (choice == 3) {
            selected = amount -> Math.max(0, amount - 150);
        } else {
            System.out.println("Invalid selection.");
            input.close();
            return;
        }

        System.out.println("Discounted amounts:");

        for (double amount : amounts) {
            System.out.println(
                "Rs. " + amount + " -> Rs. " + selected.calculate(amount)
            );
        }

        input.close();
    }
}

@FunctionalInterface
interface DiscountRule {
    double calculate(double amount);
}