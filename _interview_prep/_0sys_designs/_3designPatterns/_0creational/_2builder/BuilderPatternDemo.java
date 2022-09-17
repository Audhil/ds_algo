package _interview_prep._0sys_designs._3designPatterns._0creational._2builder;

import _interview_prep._0sys_designs._3designPatterns._0creational._2builder.Vehicle.VehicleBuilder;

//  https://www.youtube.com/watch?v=0Ptcaxyne3s&list=PLt4nG7RVVk1h9lxOYSOGI9pcP3I5oblbx&index=3&ab_channel=CodingSimplified
public class BuilderPatternDemo {

  public static void main(String[] args) {
    Vehicle car = new Vehicle.VehicleBuilder("Car", 4)
        .setAirBags(5)
        .build();

    System.out.println(car);  //  Vehicle{name='Car', wheel=4, airBags=5}

    Vehicle bike = new VehicleBuilder("Bike", 2).build();
    System.out.println(bike); //  Vehicle{name='Bike', wheel=2, airBags=0}
  }
}

class Vehicle {

  //  required
  private final String name;
  private final int wheel;

  //  optional
  private final int airBags;

  public Vehicle(VehicleBuilder builder) {
    this.name = builder.name;
    this.wheel = builder.wheel;
    this.airBags = builder.airBags;
  }

  public String getName() {
    return name;
  }

  public int getWheel() {
    return wheel;
  }

  public int getAirBags() {
    return airBags;
  }

  @Override
  public String toString() {
    return "Vehicle{" +
        "name='" + name + '\'' +
        ", wheel=" + wheel +
        ", airBags=" + airBags +
        '}';
  }

  static class VehicleBuilder {

    private final String name;
    private final int wheel;
    private int airBags;

    //  constructor with required fields
    public VehicleBuilder(String name, int wheel) {
      this.name = name;
      this.wheel = wheel;
    }

    public VehicleBuilder setAirBags(int airBags) {
      this.airBags = airBags;
      return this;
    }

    public VehicleBuilder getBuilder() {
      return this;
    }

    public Vehicle build() {
      return new Vehicle(this);
    }
  }
}