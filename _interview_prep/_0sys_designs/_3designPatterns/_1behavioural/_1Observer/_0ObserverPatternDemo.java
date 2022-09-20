package _interview_prep._0sys_designs._3designPatterns._1behavioural._1Observer;

import java.util.ArrayList;
import java.util.List;

//  https://youtu.be/w79jycVKi_Q?list=PLt4nG7RVVk1h9lxOYSOGI9pcP3I5oblbx
public class _0ObserverPatternDemo {

  public static void main(String[] args) {
    DeliveryData topic = new DeliveryData();
    Observer customer = new Customer();
    Observer seller = new Seller();
    Observer warehouse = new DeliveryWareHouseCenter();
    topic.register(customer);
    topic.register(seller);
    topic.register(warehouse);

//    yup: Customer: location updated Dummy location
//    yup: Seller: location updated Dummy location
//    yup: DeliveryWareHouseCenter: location updated Dummy location
    topic.locationChanged();
  }
}

interface Subject {

  void register(Observer observer);

  void unregister(Observer observer);

  void notifyObservers();
}

//  notifier
class DeliveryData implements Subject {

  private final List<Observer> observerList;
  private String location;

  public DeliveryData() {
    observerList = new ArrayList<>();
  }

  @Override
  public void register(Observer observer) {
    observerList.add(observer);
  }

  @Override
  public void unregister(Observer observer) {
    observerList.remove(observer);
  }

  @Override
  public void notifyObservers() {
    for (Observer obs : observerList) {
      obs.update(location);
    }
  }

  public void locationChanged() {
    location = getLocation();
    notifyObservers();
  }

  private String getLocation() {
    return "Dummy location";
  }
}

interface Observer {

  void update(String location);
}

//  observers
class Seller implements Observer {

  @Override
  public void update(String location) {
    System.out.println("yup: Seller: location updated " + location);
  }
}

class Customer implements Observer {

  @Override
  public void update(String location) {
    System.out.println("yup: Customer: location updated " + location);
  }
}

class DeliveryWareHouseCenter implements Observer {

  @Override
  public void update(String location) {
    System.out.println("yup: DeliveryWareHouseCenter: location updated " + location);
  }
}


