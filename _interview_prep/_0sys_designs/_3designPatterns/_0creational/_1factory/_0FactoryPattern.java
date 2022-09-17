package _interview_prep._0sys_designs._3designPatterns._0creational._1factory;

//  https://youtu.be/jcGSowIzmzM?list=PLt4nG7RVVk1h9lxOYSOGI9pcP3I5oblbx

//  returns instance of subclass from super class
public class _0FactoryPattern {

  //  Vehicle can be abstruct, interface or a normal class
  private static abstract class Vehicle {

    public abstract int getWheel();

    @Override
    public String toString() {
      return "Vehicle: wheel count: " + getWheel();
    }
  }

  //  subclass 1
  private static class Car extends Vehicle {

    private final int wheelCount;

    public Car(int wheelCount) {
      this.wheelCount = wheelCount;
    }

    @Override
    public int getWheel() {
      return wheelCount;
    }
  }

  //  subclass 2
  private static class Bike extends Vehicle {

    private final int wheelCount;

    public Bike(int wheelCount) {
      this.wheelCount = wheelCount;
    }

    @Override
    public int getWheel() {
      return wheelCount;
    }
  }

  //  Vehicle factory
  private static class VehicleFactory {

    public static Vehicle getInstance(String type, int wheel) {
      if (type.equals("car")) {
        return new Car(wheel);
      } else if (type.equals("bike")) {
        return new Bike(wheel);
      }
      return null;
    }
  }

  public static void main(String[] args) {
    Vehicle car = VehicleFactory.getInstance("car", 4);
    System.out.println("yup: vehicle : " + car);  //  yup: vehicle : Vehicle: wheel count: 4
    Vehicle bike = VehicleFactory.getInstance("bike", 2);
    System.out.println("yup: vehicle : " + bike); //  yup: vehicle : Vehicle: wheel count: 2
  }
}
