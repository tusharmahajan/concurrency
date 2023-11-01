package deadlocks.bankingProblem;

public class Bank {

    public void transfer(Account source, Account destination, int amount){
        Account account1, account2;

        if(source.getId() < destination.getId()){
            account1 = source;
            account2 = destination;
        }
        else {
            account1 = destination;
            account2 = source;
        }
        synchronized (account1){
            synchronized (account2) {
                source.deduct(amount);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                destination.add(amount);
            }
        }

    }
}
