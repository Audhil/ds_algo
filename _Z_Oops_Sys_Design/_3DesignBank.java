package _Z_Oops_Sys_Design;

import java.util.ArrayList;
import java.util.List;

public class _3DesignBank {

  //  transaction
  private static class Transaction {

    private final int customerId;
    private final int tellerId;

    public Transaction(int customerId, int tellerId) {
      this.customerId = customerId;
      this.tellerId = tellerId;
    }

    public int getCustomerId() {
      return customerId;
    }

    public int getTellerId() {
      return tellerId;
    }

    public String getTransaction() {
      return "";
    }
  }

  private static class OpenAccount extends Transaction {

    public OpenAccount(int customerId, int tellerId) {
      super(customerId, tellerId);
    }

    @Override
    public String getTransaction() {
      return "Teller with Id: "
          + getTellerId()
          + ", opened account for customer with Id: "
          + getCustomerId();
    }
  }

  private static class Deposit extends Transaction {

    private final int amount;

    public Deposit(int customerId, int tellerId, int amount) {
      super(customerId, tellerId);
      this.amount = amount;
    }

    @Override
    public String getTransaction() {
      return "Teller with Id: "
          + getTellerId()
          + ", deposited amount: "
          + amount
          + ",for customer with Id: "
          + getCustomerId();
    }
  }

  private static class Withdraw extends Transaction {

    private final int amount;

    public Withdraw(int customerId, int tellerId, int amount) {
      super(customerId, tellerId);
      this.amount = amount;
    }

    @Override
    public String getTransaction() {
      return "Teller with Id: "
          + getTellerId()
          + ", withdrawn amount: "
          + amount
          + ",for customer with Id: "
          + getCustomerId();
    }
  }

  //  teller
  private static class Teller {

    private final int id;

    public Teller(int id) {
      this.id = id;
    }

    public int getId() {
      return id;
    }
  }

  //  bank account = customer
  private static class BankAccount {

    String name;
    int balance;
    int customerId;

    public BankAccount(String name, int amount, int customerId) {
      this.name = name;
      this.balance = amount;
      this.customerId = customerId;
    }

    private void deposit(int amount) {
      this.balance += amount;
    }

    private void withDraw(int amount) {
      this.balance -= amount;
    }
  }

  //  bank system - software
  private static class BankSystem {

    private final List<BankAccount> accountList;
    private final List<Transaction> transactionList;

    public BankSystem(List<BankAccount> accountList, List<Transaction> transactionList) {
      this.accountList = accountList;
      this.transactionList = transactionList;
    }

    private int openAccount(String customerName, int initialDeposit, int tellerId) {
      Transaction accountOpen = new OpenAccount(accountList.size(), tellerId);
      int customerId = accountList.size();
      accountList.add(new BankAccount(customerName, initialDeposit, customerId));
      //  log the transaction
      transactionList.add(accountOpen);
      return customerId;
    }

    private void deposit(int customerId, int amount, int tellerId) {
      Transaction deposit = new Deposit(customerId, tellerId, amount);
      BankAccount account = accountList.get(customerId);
      if (account != null) {
        account.deposit(amount);
      }
      //  log the transaction
      transactionList.add(deposit);
    }

    private void withDraw(int customerId, int amount, int tellerId) {
      BankAccount account = accountList.get(customerId);
      if (account == null) {
        return;
      }

      if (account.balance < amount) {
        throw new Error("Insufficient balance error!");
      }

      Transaction withDraw = new Withdraw(customerId, tellerId, amount);
      account.withDraw(amount);
      //  log the transaction
      transactionList.add(withDraw);
    }
  }

  //  bank branch
  private static class BankBranch {

    public String getName() {
      return name;
    }

    private final String name;
    private final List<Teller> tellerList;
    private final BankSystem bankSystem;
    private int cashInHand;

    public BankBranch(String name, BankSystem bankSystem, int cashInHand) {
      this.name = name;
      this.tellerList = new ArrayList<>();
      this.bankSystem = bankSystem;
      this.cashInHand = cashInHand;
    }

    private Teller getAvailableTeller() {
      if (tellerList.size() == 0) {
        throw new Error("No tellers available in the bank!");
      }
      int index = (int) (Math.round(Math.random() * (tellerList.size() - 1)));
      return tellerList.get(index);
    }

    private int openAccount(String customerName, int initialDeposit) {
      return bankSystem.openAccount(customerName, initialDeposit, getAvailableTeller().getId());
    }

    private void deposit(int customerId, int amount) {
      bankSystem.deposit(customerId, amount, getAvailableTeller().getId());
    }

    private void withDraw(int customerId, int amount) {
      if (amount > cashInHand) {
        throw new Error("Insufficient cash in hand at the branch");
      }
      bankSystem.withDraw(customerId, amount, getAvailableTeller().getId());
    }

    private int depositToHQ(double ratio) {
      cashInHand -= (int) Math.round(cashInHand * ratio);
      return cashInHand;
    }

    private void getCashFromHQ(int cash) {
      cashInHand += cash;
    }

    private void addTeller(Teller teller) {
      tellerList.add(teller);
    }
  }

  //  bank
  private static class Bank {

    private final List<BankBranch> branchList;
    private final BankSystem bankSystem;
    private int totalCash;

    public Bank(List<BankBranch> branchList, BankSystem bankSystem, int totalCash) {
      this.branchList = branchList;
      this.bankSystem = bankSystem;
      this.totalCash = totalCash;
    }

    private BankBranch addBranch(String branchName, int initialFunds) {
      BankBranch bankBranch = new BankBranch(branchName, bankSystem, initialFunds);
      branchList.add(bankBranch);
      return bankBranch;
    }

    //  safety deposit in HQ
    private void collectCash(double ratio) {
      for (BankBranch branch : branchList) {
        totalCash += branch.depositToHQ(ratio);
      }
    }

    private void printTransactions() {
      for (Transaction transaction : bankSystem.transactionList) {
        System.out.println(transaction.getTransaction());
      }
    }
  }

  public static void main(String[] args) {
    BankSystem bankSystem = new BankSystem(new ArrayList<BankAccount>(),
        new ArrayList<Transaction>());
    Bank bank = new Bank(new ArrayList<BankBranch>(), bankSystem, 10000);

    BankBranch branch1 = bank.addBranch("123 Main St", 1000);
    BankBranch branch2 = bank.addBranch("456 Elm St", 1000);

    branch1.addTeller(new Teller(1));
    branch1.addTeller(new Teller(2));
    branch2.addTeller(new Teller(3));
    branch2.addTeller(new Teller(4));

    int customerId1 = branch1.openAccount("John Doe", 100);
    int customerId2 = branch1.openAccount("Bob Smith", 200);
    int customerId3 = branch2.openAccount("Jane Doe", 300);

    branch1.withDraw(customerId1, 50);

    /*
    * Teller with Id: 1, opened account for customer with Id: 0
      Teller with Id: 1, opened account for customer with Id: 1
      Teller with Id: 4, opened account for customer with Id: 2
      Teller with Id: 2, withdrawn amount: 50,for customer with Id: 0
      * */
    bank.printTransactions();
    bank.collectCash(0.5);
  }
}
