import java.util.*;

public class card {
    private String rank;
    private String suit;

    card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof card)) {
            return false;
        }

        card c = (card) o;
        return rank.equalsIgnoreCase(c.rank) &&
               suit.equalsIgnoreCase(c.suit);
    }

    public int hashCode() {
        return Objects.hash(rank.toLowerCase(), suit.toLowerCase());
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cards: ");
        int n = sc.nextInt();
        sc.nextLine();

        card a[] = new card[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter rank: ");
            String rank = sc.nextLine();

            System.out.print("Enter suit: ");
            String suit = sc.nextLine();

            a[i] = new card(rank, suit);

            for (int j = 0; j < i; j++) {
                if (a[i].equals(a[j])) {
                    System.out.println("Duplicate found: " + a[i]);
                    sc.close();
                    return;
                }
            }
        }

        System.out.println("No duplicate card found.");
        sc.close();
    }
}