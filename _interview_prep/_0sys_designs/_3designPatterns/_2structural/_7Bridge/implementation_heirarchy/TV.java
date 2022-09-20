package _interview_prep._0sys_designs._3designPatterns._2structural._7Bridge.implementation_heirarchy;

public class TV implements Device {

  private boolean on;
  private int channel;
  private int volume = 9;

  @Override
  public boolean isEnabled() {
    return on;
  }

  @Override
  public void enable() {
    on = true;
  }

  @Override
  public void disable() {
    on = false;
  }

  @Override
  public int getVolume() {
    return volume;
  }

  @Override
  public void setVolume(int volume) {
    if (volume > 100) {
      this.volume = 100;
    } else if (volume < 0) {
      this.volume = 0;
    } else {
      this.volume = volume;
    }
  }

  @Override
  public int getChannel() {
    return channel;
  }

  @Override
  public void setChannel(int channel) {
    this.channel = channel;
  }

  @Override
  public void printStatus() {
    System.out.println("------------------------------------------------");
    System.out.println("Yup: this is TV set");
    System.out.println("Yup: it is : " + (on ? "enabled" : "disabled"));
    System.out.println("Yup: current volume: " + volume);
    System.out.println("Yup: current channel: " + channel);
    System.out.println("------------------------------------------------");
  }
}
