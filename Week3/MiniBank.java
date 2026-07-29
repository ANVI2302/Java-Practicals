import java.util.*;

class Customer implements Cloneable {
    private String name;
    private Address add;

    Customer(String name, Address add) {
        this.name = name;
        this.add = add;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return add;
    }

    @Override
    public Customer clone() {
        try {
            Customer c = (Customer) super.clone();
            c.add = new Address(add.line, add.city, add.pincode);
            return c;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    static class Address {
        String line;
        String city;
        String pincode;

        Address(String line, String city, String pincode) {
            this.line = line;
            this.city = city;
            this.pincode = pincode;
        }

        public String getCity() {
            return city;
        }

        public String getPincode() {
            return pincode;
        }
    }
}

class Account {
    private int accountNumber;
    private String ownerName;
    private double balance;
    private boolean active;

    Account(int accountNumber, String ownerName, double balance, boolean active) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.active = active;
    }

    public String toString() {
        return "Account Number: " + accountNumber +
               "\nOwner Name: " + ownerName +
               "\nBalance: " + balance +
               "\nActive: " + active;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Account))
            return false;

        Account a = (Account) o;
        return accountNumber == a.accountNumber;
    }

    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}

public class MiniBank {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int n1 = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter owner name: ");
        String name = sc.nextLine();

        System.out.print("Enter balance: ");
        double b = sc.nextDouble();

        Account a1 = new Account(n1, name, b, true);

        System.out.print("Enter another account number: ");
        int n2 = sc.nextInt();

        Account a2 = new Account(n2, name, b, true);
        sc.nextLine();

        System.out.print("Enter address line: ");
        String line = sc.nextLine();

        System.out.print("Enter city: ");
        String city = sc.nextLine();

        System.out.print("Enter pincode: ");
        String pin = sc.nextLine();

        Customer.Address ad = new Customer.Address(line, city, pin);

        Customer c1 = new Customer(name, ad);
        Customer c2 = c1.clone();

        System.out.println("\nAccount Details");
        System.out.println(a1);

        System.out.println("\nAccounts Equal: " + a1.equals(a2));

        Object obj = a1;
        if (obj instanceof Account) {
            System.out.println("Object is an Account");
        }

        System.out.println("\nCustomer Name: " + c2.getName());
        System.out.println("City: " + c2.getAddress().getCity());

        sc.close();
    }
}