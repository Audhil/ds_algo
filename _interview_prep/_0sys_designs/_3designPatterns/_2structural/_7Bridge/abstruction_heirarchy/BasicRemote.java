package _interview_prep._0sys_designs._3designPatterns._2structural._7Bridge.abstruction_heirarchy;

import _interview_prep._0sys_designs._3designPatterns._2structural._7Bridge.implementation_heirarchy.Device;

public class BasicRemote implements Remote {

  //  aggregation - bridge
  protected Device device;

  public BasicRemote(Device device) {
    super();
    this.device = device;
  }

  @Override
  public void togglePower() {
    if (device.isEnabled()) {
      device.disable();
    } else {
      device.enable();
    }
  }

  @Override
  public void volumeUp() {
    System.out.println("yup: volume up: ");
    device.setVolume(device.getVolume() + 10);
  }

  @Override
  public void volumeDown() {
    System.out.println("yup: volume down: ");
    device.setVolume(device.getVolume() - 10);
  }

  @Override
  public void channelUp() {
    System.out.println("yup: Channel up: ");
    device.setChannel(device.getChannel() + 1);
  }

  @Override
  public void channelDown() {
    System.out.println("yup: Channel down: ");
    device.setChannel(device.getChannel() - 1);
  }
}
