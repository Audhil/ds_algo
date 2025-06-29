package _interview_prep._0sys_designs._3designPatterns._2structural._2Facade.facade;

import _interview_prep._0sys_designs._3designPatterns._2structural._2Facade.other.WelcomeToBank;
import _interview_prep._0sys_designs._3designPatterns._2structural._2Facade.check.AccountNumberCheck;
import _interview_prep._0sys_designs._3designPatterns._2structural._2Facade.check.FundsCheck;
import _interview_prep._0sys_designs._3designPatterns._2structural._2Facade.check.SecurityCheck;

public class BankAccountFacade {

  private int acctNumber = 123456;
  private int securityCode = 654321;

  public int getAcctNumber() {
    return acctNumber;
  }

  public int getSecurityCode() {
    return securityCode;
  }

  private final AccountNumberCheck accountNumberChecker;
  private final SecurityCheck securityChecker;
  private final FundsCheck fundChecker;

  private final WelcomeToBank welcomeToBank;

  public BankAccountFacade(int acctNumber, int securityCode) {
    this.acctNumber = acctNumber;
    this.securityCode = securityCode;

    welcomeToBank = new WelcomeToBank();
    accountNumberChecker = new AccountNumberCheck();
    securityChecker = new SecurityCheck();
    fundChecker = new FundsCheck();
  }

  public void withDrawMoney(double cashToGet) {
    if (accountNumberChecker.isActive(getAcctNumber())
        && securityChecker.isCodeCorrect(getSecurityCode())
        && fundChecker.hasEnoughMoney(cashToGet)) {
      System.out.println("Transaction complete!");
    } else {
      System.out.println("Transaction failed");
    }
  }

  public void depositMoney(double amount) {
    if (accountNumberChecker.isActive(getAcctNumber())
        && securityChecker.isCodeCorrect(getSecurityCode())) {
      fundChecker.makeDeposit(amount);
      System.out.println("Transaction complete!");
    } else {
      System.out.println("Transaction failed");
    }
  }
}
