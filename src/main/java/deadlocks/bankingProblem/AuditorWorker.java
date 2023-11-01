package deadlocks.bankingProblem;

import java.util.List;

public class AuditorWorker implements Runnable {

    private final List<Account> accounts;
    private final Bank bank;
    public AuditorWorker(List<Account> accounts, Bank bank) {
        this.accounts = accounts;
        this.bank = bank;
    }

    @Override
    public void run() {

        while(true){
            // not scalable solution
            int totalAmount = 0;
            synchronized (accounts.get(0)){
                synchronized (accounts.get(1)){
                    synchronized (accounts.get(2)){
                        synchronized (accounts.get(3)){
                            synchronized (accounts.get(4)){
                                synchronized (accounts.get(5)){
                                    for(Account account: accounts){
                                        synchronized (account){
                                            System.out.println(account.getId() + " : " + account.getAmount());
                                            totalAmount+=account.getAmount();
                                        }
                                    }
                                    System.out.println("Total amount across all accounts: " + totalAmount);
                                }
                            }
                        }
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
