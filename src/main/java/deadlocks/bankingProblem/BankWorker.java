package deadlocks.bankingProblem;

public class BankWorker implements Runnable{

    private final Account source, destination;
    private final Bank bank;
    private final int amount;

    public BankWorker(Account source, Account destination, Bank bank, int amount) {
        this.source = source;
        this.destination = destination;
        this.bank = bank;
        this.amount = amount;
    }


    @Override
    public void run() {
        bank.transfer(source, destination, amount);
    }
}
