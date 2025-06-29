package _interview_prep._0sys_designs._3designPatterns._2structural._2Facade.check;

public class SecurityCheck {
  private int securityCode = 1234;

  public int getSecurityCode() {
    return securityCode;
  }

  public boolean isCodeCorrect(int securityCode) {
    return securityCode == getSecurityCode();
  }
}
