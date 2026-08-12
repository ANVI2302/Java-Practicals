class Game extends Media {

    Game(String title, int lateDays) {
        super(title, lateDays);
    }

    double lateFee() {
        return lateDays * 3;
    }
}
