package deadlocks.bankingProblem;

import java.util.Arrays;
import java.util.List;

public class BankingProblem {

    public static void main(String[] args) {
        Bank bank = new Bank();

        Account account1 = new Account(1, 1000);
        Account account2 = new Account(2, 500);
        Account account3 = new Account(3, 100);
        Account account4 = new Account(4, 2500);
        Account account5 = new Account(5, 1500);
        Account account6 = new Account(6, 3500);

        List<Account> accountList = Arrays.asList(account1, account2, account3, account4, account5, account6);

        int total = 0;

        for (Account account: accountList){
            total+=account.getAmount();
        }
        System.out.println("Total amont: " + total);

        Thread t1 = new Thread(new BankWorker(account1, account4, bank, 100));
        Thread t2 = new Thread(new BankWorker(account1, account2, bank, 500));
        Thread t3 = new Thread(new BankWorker(account3, account4, bank,50));
        Thread t4 = new Thread(new BankWorker(account4, account2, bank, 1000));
        Thread t5 = new Thread(new BankWorker(account5, account1, bank, 200));
        Thread t6 = new Thread(new BankWorker(account6, account3, bank, 300));

        Thread auditor = new Thread(new AuditorWorker(accountList, bank));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        auditor.start();
    }
}
