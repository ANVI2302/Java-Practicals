public class SmartController {
    public static void main(String[] args) {
        Switchable[] items = {new Fan(), new Lamp()};

        for (Switchable item : items) {
            item.toggle();
        }

        PowerPermission rule1 = new PowerPermission() {
            public boolean allowed(String device, int hour) {
                return hour >= 7 && hour <= 22;
            }
        };

        System.out.println("Fan at 8: " + rule1.allowed("Fan", 8));
        System.out.println("Lamp at 5: " + rule1.allowed("Lamp", 5));

        PowerPermission rule2 =
                (device, hour) -> hour >= 7 && hour <= 22;

        System.out.println("Lambda check:");
        System.out.println("Fan at 8: " + rule2.allowed("Fan", 8));
        System.out.println("Lamp at 5: " + rule2.allowed("Lamp", 5));
    }
}

interface Switchable {
    void on();
    void off();

    default void toggle() {
        on();
    }
}

class Fan implements Switchable {
    public void on() {
        System.out.println("Fan started.");
    }

    public void off() {
        System.out.println("Fan stopped.");
    }
}

class Lamp implements Switchable {
    public void on() {
        System.out.println("Lamp switched on.");
    }

    public void off() {
        System.out.println("Lamp switched off.");
    }
}

@FunctionalInterface
interface PowerPermission {
    boolean allowed(String device, int hour);
}