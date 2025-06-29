package _interview_prep._0sys_designs._3designPatterns._2structural._2Facade.check;

public class AccountNumberCheck {

  private int accNum = 123456789;

  public int getAccNum() {
    return accNum;
  }

  public boolean isActive(int accNum) {
    return accNum == getAccNum();
  }
}
