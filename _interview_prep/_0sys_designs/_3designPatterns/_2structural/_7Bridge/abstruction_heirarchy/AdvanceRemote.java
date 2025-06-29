package _interview_prep._0sys_designs._3designPatterns._2structural._7Bridge.abstruction_heirarchy;

import _interview_prep._0sys_designs._3designPatterns._2structural._7Bridge.implementation_heirarchy.Device;

public class AdvanceRemote extends BasicRemote {

  public AdvanceRemote(Device device) {
    super(device);
  }

  public void mute() {
    System.out.println("Yup: mute the volume");
    device.setVolume(0);
  }
}
