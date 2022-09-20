package _interview_prep._0sys_designs._3designPatterns._2structural._7Bridge._zanother_example;

//  https://youtu.be/1HL0V7vz5mA?list=PLt4nG7RVVk1h9lxOYSOGI9pcP3I5oblbx
public class _0BridgePatternDemoAnother {

  public static void main(String[] args) {
    Remote oldRemote = new OldRemote();
    TV sonyWithOldRemote = new Sony(oldRemote);
    //  Sony TV is ON! On with OldRemote
    //  Sony TV is OFF! Off with OldRemote
    sonyWithOldRemote.on();
    sonyWithOldRemote.off();
    System.out.println();

    Remote newRemote = new NewRemote();
    TV sonyWithNewRemote = new Sony(newRemote);
    //  Sony TV is ON! On with NewRemote
    //  Sony TV is OFF! Off with NewRemote
    sonyWithNewRemote.on();
    sonyWithNewRemote.off();
    System.out.println();

    TV phillipsWithOldRemote = new Phillips(oldRemote);
    //  Phillips TV is ON! On with OldRemote
    //  Phillips TV is OFF! Off with OldRemote
    phillipsWithOldRemote.on();
    phillipsWithOldRemote.off();
    System.out.println();

    TV phillipsWithNewRemote = new Phillips(newRemote);
    //  Phillips TV is ON! On with NewRemote
    //  Phillips TV is OFF! Off with NewRemote
    phillipsWithNewRemote.on();
    phillipsWithNewRemote.off();
    System.out.println();
  }
}

abstract class TV {

  Remote remote;

  public TV(Remote remote) {
    this.remote = remote;
  }

  abstract void on();

  abstract void off();
}

class Sony extends TV {

  Remote remoteType;

  public Sony(Remote remote) {
    super(remote);
    remoteType = remote;
  }

  @Override
  void on() {
    System.out.print("Sony TV is ON! ");
    remoteType.on();
  }

  @Override
  void off() {
    System.out.print("Sony TV is OFF! ");
    remoteType.off();
  }
}

class Phillips extends TV {

  private final Remote remoteType;

  public Phillips(Remote remote) {
    super(remote);
    remoteType = remote;
  }

  @Override
  void on() {
    System.out.print("Phillips TV is ON! ");
    remoteType.on();
  }

  @Override
  void off() {
    System.out.print("Phillips TV is OFF! ");
    remoteType.off();
  }
}

interface Remote {

  void on();

  void off();
}

class OldRemote implements Remote {

  @Override
  public void on() {
    System.out.println("On with OldRemote");
  }

  @Override
  public void off() {
    System.out.println("Off with OldRemote");
  }
}

class NewRemote implements Remote {

  @Override
  public void on() {
    System.out.println("On with NewRemote");
  }

  @Override
  public void off() {
    System.out.println("Off with NewRemote");
  }
}
