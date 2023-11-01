package signaling.specialSeries;

public class SeriesSimulator {

    public static int total = 100;
    public static int curr = 1;
    public static boolean isZeroLast = false;

    public static void main(String[] args) {

        Object lock = new Object();

        Thread zero = new Thread(new Zero(lock));
        Thread even = new Thread(new Even(lock));
        Thread odd = new Thread(new Odd(lock));

        zero.start();
        even.start();
        odd.start();
    }
}
