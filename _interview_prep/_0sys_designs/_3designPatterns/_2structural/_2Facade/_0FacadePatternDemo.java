package _interview_prep._0sys_designs._3designPatterns._2structural._2Facade;

import _interview_prep._0sys_designs._3designPatterns._2structural._2Facade.facade.BankAccountFacade;

//  simplified interface, that do many other actions
//  https://youtu.be/B1Y8fcYrz5o
public class _0FacadePatternDemo {

  public static void main(String[] args) {
    BankAccountFacade facade = new BankAccountFacade(123456789, 1234);
    /*
    * Welcome to Bank ABC!
      We'll give you your money!
      Withdrawal complete: current balance: 950.0
      Transaction complete!
      Withdrawal complete: current balance: 50.0
      Transaction complete!
      Deposit complete: current balance: 250.0
      Transaction complete!
    * */
    facade.withDrawMoney(50.00);
    facade.withDrawMoney(900.00);
    facade.depositMoney(200);
  }
}
