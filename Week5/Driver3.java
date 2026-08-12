public class Driver3 {

    public static void main(String[] args) {

        Media[] media = {
            new Book("Java Book", 3),
            new Movie("Avengers", 2),
            new Game("Minecraft", 4)
        };

        double total = 0;

        for (Media m : media) {

            double fee = m.lateFee();

            System.out.println(
                m.title + " Late Fee: " + fee
            );

            total += fee;
        }

        System.out.println("Total Late Fees: " + total);
    }
}