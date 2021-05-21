import java.util.Arrays;
import java.util.StringJoiner;

public class FizzBuzz {

    private int number = 1;
    private final int limit;
    StringJoiner join = new StringJoiner(", ");

    public FizzBuzz(int limit){
        this.limit = limit;
    }

    public synchronized void fizz(){
        while(number <= limit){
            if (number % 3 == 0 && number % 5 != 0){
                join.add("Fizz");
                number++;
                notifyAll();
            }
            else{
                threadWait();
            }
        }
        System.out.println(join.toString());
    }

    public synchronized void buzz(){
        while (number <= limit){
            if (number % 5 == 0 && number % 3 != 0){
                join.add("Buzz");
                number++;
                notifyAll();
            }
            else{
                threadWait();
            }
        }
    }

    public synchronized void fizzBuzz(){
        while (number <= limit){
            if (number % 15 == 0){
                join.add("FizzBuzz");
                number++;
                notifyAll();
            }
            else{
                threadWait();
            }
        }
    }

    public synchronized void addNumber(){
        while (number <= limit){
            if (number % 3 != 0 && number % 5 != 0){
                join.add(String.valueOf(number));
                number++;
                notifyAll();
            }
            else{
                threadWait();
            }
        }
    }

    private void threadWait(){
        try{
            wait();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void runAll(Thread a, Thread b, Thread c, Thread d){
        for(Thread thread : Arrays.asList(a, b, c, d)){
            thread.start();
        }
    }

    public static void main(String[] args) {

        FizzBuzz fizzBuzz = new FizzBuzz(30);

        Thread threadA = new Thread(fizzBuzz::fizz);
        Thread threadB = new Thread(fizzBuzz::buzz);
        Thread threadC = new Thread(fizzBuzz::fizzBuzz);
        Thread threadD = new Thread(fizzBuzz::addNumber);

        fizzBuzz.runAll(threadA, threadB, threadC, threadD);

    }

}