public class FiveSecondsNotifier extends Thread{

    DisplayCounter counter;
    int timer;

    public FiveSecondsNotifier(DisplayCounter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        while (counter.isAlive()){
            try{
                timer = counter.getTimer();
                if (timer != 0 && timer % 5 == 0){
                    System.out.println("five seconds passed");
                    sleep(2000);
                }
            }catch(IllegalStateException | InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Process finished in: " + counter.getTimer() + " sec.");
    }
}