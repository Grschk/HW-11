public class DisplayCounter extends Thread {

    int timer;
    private final int finish;

    public DisplayCounter (int finish){
        this.finish = finish;
    }

    public synchronized int getTimer() {
        return timer;
    }

    @Override
    public void run() {
        while (!currentThread().isInterrupted()) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                timer++;
            }
            System.out.println(currentThread().getName() + " second:" + timer);
            if (timer == finish){
                currentThread().interrupt();
            }
        }
    }
}
