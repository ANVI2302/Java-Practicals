import java.util.*;

public class point {
    private int x;
    private int y;

    point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof point)) {
            return false;
        }

        point p = (point) o;
        return x == p.x && y == p.y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of points: ");
        int n = sc.nextInt();

        point a[] = new point[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter x: ");
            int x = sc.nextInt();

            System.out.print("Enter y: ");
            int y = sc.nextInt();

            a[i] = new point(x, y);
        }

        int c = 0;

        for (int i = 0; i < n; i++) {
            boolean f = false;

            for (int j = 0; j < i; j++) {
                if (a[i].equals(a[j])) {
                    f = true;
                    break;
                }
            }

            if (!f) {
                c++;
            }
        }

        System.out.println("Distinct points: " + c);

        sc.close();
    }
}