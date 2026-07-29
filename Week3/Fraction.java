import java.util.*;

public class Fraction {
    private int num;
    private int den;

    Fraction(int num, int den) {
        int g = gcd(num, den);
        this.num = num / g;
        this.den = den / g;
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public String toString() {
        return num + "/" + den;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fraction)) {
            return false;
        }
        Fraction f = (Fraction) o;
        return num == f.num && den == f.den;
    }

    public int hashCode() {
        return Objects.hash(num, den);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of fractions: ");
        int n = sc.nextInt();

        Fraction a[] = new Fraction[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter numerator: ");
            int num = sc.nextInt();

            System.out.print("Enter denominator: ");
            int den = sc.nextInt();

            a[i] = new Fraction(num, den);
        }

        System.out.println("\nReduced fractions:");
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }

        System.out.println("\nMatching fractions:");
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i].equals(a[j])) {
                    System.out.println(a[i] + " = " + a[j]);
                }
            }
        }

        sc.close();
    }
}