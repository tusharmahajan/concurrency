package signaling.fizzbuzz;

public class FizzBuzzSimulator {

    public static int curr = 1;
    public static int total = 15;

    public static void main(String[] args) {

        Object lock = new Object();
        Thread fizz = new Thread(new Fizz("fizz", lock));
        Thread buzz = new Thread(new Buzz("buzz", lock));
        Thread fizzbuzz = new Thread(new FizzBuzz("fizzbuzz", lock));
        Thread plain = new Thread(new Plain("plain", lock));

        fizz.start();
        buzz.start();
        fizzbuzz.start();
        plain.start();
    }
}
