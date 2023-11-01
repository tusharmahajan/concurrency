package deadlocks.bankingProblem;

public class Account {

    private final int id;
    private int amount;

    public Account(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public void add(int credit){
        this.amount+=credit;
    }

    public void deduct(int debit){
        if(debit > amount){
            throw new RuntimeException("Cant deduct with greater amount: " + debit);
        }
        amount-=debit;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }
}
