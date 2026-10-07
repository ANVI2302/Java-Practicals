public class AlertBroadcast {
    public static void main(String[] args) {

        Notifier email = text ->
                System.out.println("Email alert: " + text);

        Notifier sms = text ->
                System.out.println("SMS alert: " + text);

        Notifier prioritySms = new PriorityNotifier(sms);

        Notifier[] channels = {email, prioritySms};

        String alert = "Lab submission closes tomorrow.";

        System.out.println("Sending alerts:");

        for (Notifier channel : channels) {
            channel.send(alert);

            if (channel instanceof Urgent) {
                channel.send(alert);
            }
        }
    }
}

@FunctionalInterface
interface Notifier {
    void send(String text);
}

interface Urgent {
}

class PriorityNotifier implements Notifier, Urgent {

    private Notifier channel;

    PriorityNotifier(Notifier channel) {
        this.channel = channel;
    }

    public void send(String text) {
        channel.send(text);
    }
}