package _interview_prep._0sys_designs._3designPatterns._2structural._3Composite;

import java.util.ArrayList;
import java.util.List;

//  https://youtu.be/AIyTWtOqrfs?list=PLt4nG7RVVk1h9lxOYSOGI9pcP3I5oblbx
public class _0CompositePatternDemo {

  //  4 points: leaf, composite, component, client

  //  component
  private static abstract class Account {

    abstract float getBalance();
  }

  //  leaf
  private static class SavingsAccount extends Account {

    private final String accNo;
    private final float accBalance;

    public SavingsAccount(String accNo, float accBalance) {
      this.accNo = accNo;
      this.accBalance = accBalance;
    }

    @Override
    float getBalance() {
      return accBalance;
    }
  }

  private static class DepositeAccount extends Account {

    private final String accNo;
    private final float accBalance;

    public DepositeAccount(String accNo, float accBalance) {
      this.accNo = accNo;
      this.accBalance = accBalance;
    }

    @Override
    float getBalance() {
      return accBalance;
    }
  }

  //  composite
  private static class CompositeAccount {

    private float totalBalance;
    private final List<Account> accountList = new ArrayList<>();

    private float getBalance() {
      for (Account account : accountList) {
        totalBalance += account.getBalance();
      }
      return totalBalance;
    }

    private void addAccount(Account account) {
      accountList.add(account);
    }

    private void removeAccount(Account account) {
      accountList.remove(account);
    }
  }

  //  Client
  public static void main(String[] args) {
    CompositeAccount compositeAccount = new CompositeAccount();
    compositeAccount.addAccount(new DepositeAccount("33OOP", 900));
    compositeAccount.addAccount(new DepositeAccount("332w2wOOP", 90));
    compositeAccount.addAccount(new SavingsAccount("33ttOOP", 1200));

    System.out.println(
        "total: balance: " + compositeAccount.getBalance()); //  total: balance: 2190.0
  }
}
