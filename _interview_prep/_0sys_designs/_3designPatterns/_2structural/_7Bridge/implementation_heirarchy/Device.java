package _interview_prep._0sys_designs._3designPatterns._2structural._7Bridge.implementation_heirarchy;

public interface Device {

  boolean isEnabled();

  void enable();

  void disable();

  int getVolume();

  void setVolume(int volume);

  int getChannel();

  void setChannel(int channel);

  void printStatus();
}
