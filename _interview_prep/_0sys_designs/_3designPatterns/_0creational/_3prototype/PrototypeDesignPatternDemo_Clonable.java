package _interview_prep._0sys_designs._3designPatterns._0creational._3prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeDesignPatternDemo_Clonable {

  private static class Vehicle implements Cloneable {

    private final List<String> vehicleList;

    public Vehicle() {
      vehicleList = new ArrayList<>();
    }

    public Vehicle(List<String> vehicleList) {
      this.vehicleList = vehicleList;
    }

    private void addDate() {
      vehicleList.add("Tata Altroz");
      vehicleList.add("Honda WRV");
      vehicleList.add("Audi A10");
      vehicleList.add("BMW");
    }

    public List<String> getVehicleList() {
      return vehicleList;
    }

    @Override
    public Vehicle clone() {
      List<String> tempList = new ArrayList<>();
      for (String vehicle : vehicleList) {
        tempList.add(vehicle);
      }
      return new Vehicle(tempList);
    }
  }

  public static void main(String[] args) {
    Vehicle origObj = new Vehicle();
    origObj.addDate();

    /*
    * yup: origObj.getVehicleList(): [Tata Altroz, Honda WRV, Audi A10, BMW]
      yup: clonedObj.getVehicleList(): [Tata Altroz, Honda WRV, Audi A10, BMW]
      yup: 2nd clonedObj.getVehicleList(): [Tata Altroz, Honda WRV, Audi A10, BMW, Jack and jill]
      yup: origObj.getVehicleList(): [Tata Altroz, Honda WRV, Audi A10, BMW]
      yup: 2nd clonedObj.getVehicleList(): [Tata Altroz, Honda WRV, Audi A10, Jack and jill]
      yup: origObj.getVehicleList(): [Tata Altroz, Honda WRV, Audi A10, BMW]
      * */
    System.out.println("yup: origObj.getVehicleList(): " + origObj.getVehicleList());
    Vehicle clonedObj = origObj.clone();
    System.out.println("yup: clonedObj.getVehicleList(): " + clonedObj.getVehicleList());
    clonedObj.vehicleList.add("Jack and jill");
    System.out.println("yup: 2nd clonedObj.getVehicleList(): " + clonedObj.getVehicleList());
    System.out.println("yup: origObj.getVehicleList(): " + origObj.getVehicleList());
    clonedObj.vehicleList.remove("BMW");
    System.out.println("yup: 2nd clonedObj.getVehicleList(): " + clonedObj.getVehicleList());
    System.out.println("yup: origObj.getVehicleList(): " + origObj.getVehicleList());
  }
}
