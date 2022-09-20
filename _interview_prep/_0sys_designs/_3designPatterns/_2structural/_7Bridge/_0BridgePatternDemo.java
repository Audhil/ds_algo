package _interview_prep._0sys_designs._3designPatterns._2structural._7Bridge;

import _interview_prep._0sys_designs._3designPatterns._2structural._7Bridge.abstruction_heirarchy.AdvanceRemote;
import _interview_prep._0sys_designs._3designPatterns._2structural._7Bridge.abstruction_heirarchy.BasicRemote;
import _interview_prep._0sys_designs._3designPatterns._2structural._7Bridge.abstruction_heirarchy.Remote;
import _interview_prep._0sys_designs._3designPatterns._2structural._7Bridge.implementation_heirarchy.Device;
import _interview_prep._0sys_designs._3designPatterns._2structural._7Bridge.implementation_heirarchy.Radio;
import _interview_prep._0sys_designs._3designPatterns._2structural._7Bridge.implementation_heirarchy.TV;

//  https://www.youtube.com/watch?v=HlAZfBXgZcE&ab_channel=SyedSajidHussain
public class _0BridgePatternDemo {

  //  abstraction & implementation

  public static void main(String[] args) {
    Device tv = new TV();
    Remote basicRemote = new BasicRemote(tv);
    basicRemote.togglePower();
    /*
    * ------------------------------------------------
      Yup: this is TV set
      Yup: it is : enabled
      Yup: current volume: 9
      Yup: current channel: 0
      ------------------------------------------------
      * */
    tv.printStatus();

    System.out.println("Yup: test with advance remote: ");
    AdvanceRemote advanceRemote = new AdvanceRemote(tv);
    advanceRemote.togglePower();
//    Yup: test with advance remote:
//    Yup: mute the volume
    advanceRemote.mute();
    //  ------------------------------------------------
    //  Yup: this is TV set
    //  Yup: it is : disabled
    //  Yup: current volume: 0
    //  Yup: current channel: 0
    //  ------------------------------------------------
    tv.printStatus();

    Device radio = new Radio();
    Remote bR = new BasicRemote(radio);
    bR.togglePower();
    bR.volumeUp();
//    Yup: this is Radio set
//    Yup: it is : enabled
//    Yup: current volume: 19
//    Yup: current channel: 0
    radio.printStatus();

    AdvanceRemote aR = new AdvanceRemote(radio);
    aR.mute();
    //  Yup: this is Radio set
    //  Yup: it is : enabled
    //  Yup: current volume: 0
    //  Yup: current channel: 0
    radio.printStatus();
  }
}
