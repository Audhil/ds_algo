package _Z_Oops_Sys_Design;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

//  https://neetcode.io/courses/ood-interview/2
public class _2DesignParkingLot {

  //  vehicle
  private interface Vehicle {

    int getNoOfRequiredSpots();
  }

  //  car
  private static class Car implements Vehicle {

    @Override
    public int getNoOfRequiredSpots() {
      return 1;
    }
  }

  //  limo
  private static class Limo implements Vehicle {

    @Override
    public int getNoOfRequiredSpots() {
      return 2;
    }
  }

  //  semi-truck
  private static class SemiTruck implements Vehicle {

    @Override
    public int getNoOfRequiredSpots() {
      return 3;
    }
  }

  //  Driver
  private static class Driver {

    int id;
    Vehicle vehicle;
    int amountDue;

    public Driver(int id, Vehicle vehicle, int amountDue) {
      this.id = id;
      this.vehicle = vehicle;
      this.amountDue = amountDue;
    }

    private void charge(int amount) {
      amountDue += amount;
      System.out.println("yup: got charged: " + amountDue);
    }
  }

  //  Parking floor
  private static class ParkingFloor {

    int[] noOfSpots;
    Map<Vehicle, int[]> occupiedSpotsMap;

    public ParkingFloor(int[] noOfSpots) {
      this.noOfSpots = noOfSpots;
      this.occupiedSpotsMap = new HashMap<>();
    }

    private boolean parkVehicle(Vehicle vehicle) {
      //  find available spots with sliding window technique
      int l = 0, r = 0;
      while (r < noOfSpots.length) {
        if (noOfSpots[r] != 0) {
          l = r + 1;
        }
        //  we found the required spots available - park the vehicle
        if (r - l + 1 == vehicle.getNoOfRequiredSpots()) {
          for (int k = l; k <= r; k++) {
            noOfSpots[k] = 1;
          }
          occupiedSpotsMap.put(vehicle, new int[]{l, r});
          return true;
        }
        r++;
      }
      return false;
    }

    private boolean removeVehicle(Vehicle vehicle) {
      if (!occupiedSpotsMap.containsKey(vehicle)) {
        return false;
      }
      int[] occupiedSpots = occupiedSpotsMap.get(vehicle);
      for (int i = occupiedSpots[0]; i < occupiedSpots[1]; i++) {
        noOfSpots[i] = 0;
      }
      occupiedSpotsMap.remove(vehicle);
      return true;
    }
  }

  //  Parking Garage
  private static class ParkingGarage {

    private final ParkingFloor[] noOfFloors;

    public ParkingGarage(int floorCount, int spotsCount) {
      this.noOfFloors = new ParkingFloor[floorCount];
      for (int i = 0; i < floorCount; i++) {
        noOfFloors[i] = new ParkingFloor(new int[spotsCount]);
      }
    }

    private boolean parkVehicle(Vehicle vehicle) {
      for (ParkingFloor floor : noOfFloors) {
        if (floor.parkVehicle(vehicle)) {
          return true;
        }
      }
      return false;
    }

    private boolean removeVehicle(Vehicle vehicle) {
      for (ParkingFloor floor : noOfFloors) {
        if (floor.removeVehicle(vehicle)) {
          return true;
        }
      }
      return false;
    }
  }

  //  Parking System
  private static class ParkingSystem {

    private final ParkingGarage parkingGarage;
    private final int hourlyCharges;
    private final Map<Driver, Integer> timeParkedMap;

    public ParkingSystem(ParkingGarage parkingGarage, int hourlyCharges) {
      this.parkingGarage = parkingGarage;
      this.hourlyCharges = hourlyCharges;
      timeParkedMap = new HashMap<>();
    }

    private boolean parkVehicle(Driver driver) {
      int currHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
      boolean isParked = parkingGarage.parkVehicle(driver.vehicle);
      if (isParked) {
        timeParkedMap.put(driver, currHour);
      }
      return isParked;
    }

    private boolean removeVehicle(Driver driver) {
      if (!timeParkedMap.containsKey(driver)) {
        return false;
      }
      int entryTime = timeParkedMap.get(driver);
      int totalTimeParked = (int) Math.ceil(
          Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + 2 - entryTime);
      //  charge the driver
      driver.charge(totalTimeParked * hourlyCharges);
      timeParkedMap.remove(driver);
      return parkingGarage.removeVehicle(driver.vehicle);
    }
  }

  public static void main(String[] args) {
    ParkingSystem parkingSystem = new ParkingSystem(new ParkingGarage(3, 2), 5);

    Driver driver1 = new Driver(1, new Car(), 0);
    Driver driver2 = new Driver(2, new Limo(), 0);
    Driver driver3 = new Driver(3, new SemiTruck(), 0);

    /*
    sample output
    * driver1: parked: true
      driver2: parked: true
      driver3: parked: false
      yup: got charged: 10
      driver1: removed: true
      yup: got charged: 10
      driver2: removed: true
      driver3: removed: false
      * */
    System.out.println("driver1: parked: "+parkingSystem.parkVehicle(driver1));    // true
    System.out.println("driver2: parked: "+parkingSystem.parkVehicle(driver2));    // true
    System.out.println("driver3: parked: "+parkingSystem.parkVehicle(driver3));    // false
    System.out.println("driver1: removed: "+parkingSystem.removeVehicle(driver1));  // true
    System.out.println("driver2: removed: "+parkingSystem.removeVehicle(driver2));  // true
    System.out.println("driver3: removed: "+parkingSystem.removeVehicle(driver3));  // false
  }
}
