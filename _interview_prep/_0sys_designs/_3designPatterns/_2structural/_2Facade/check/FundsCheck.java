package _interview_prep._0sys_designs._3designPatterns._2structural._2Facade.check;

public class FundsCheck {

  private double cashInAccount = 1000.00;

  public double getCashInAccount() {
    return cashInAccount;
  }

  public void decreaseCashInAccount(double cashWithdrawal) {
    cashInAccount -= cashWithdrawal;
  }

  public void increaseCashInAccount(double cashDeposited) {
    cashInAccount += cashDeposited;
  }

  public boolean hasEnoughMoney(double cashToWithdrawal) {
    if (cashToWithdrawal > getCashInAccount()) {
      System.out.println("you don't have enough money!");
      System.out.println("current balance: " + getCashInAccount());
      return false;
    }
    decreaseCashInAccount(cashToWithdrawal);
    System.out.println("Withdrawal complete: current balance: " + getCashInAccount());
    return true;
  }

  public void makeDeposit(double cashToDeposit) {
    increaseCashInAccount(cashToDeposit);
    System.out.println("Deposit complete: current balance: " + getCashInAccount());
  }
}
