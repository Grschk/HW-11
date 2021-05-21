public class Main {

    public static void main(String[] args) {
        DisplayCounter counter = new DisplayCounter(15);
        FiveSecondsNotifier notifyer = new FiveSecondsNotifier(counter);

        counter.start();
        notifyer.start();

    }

}