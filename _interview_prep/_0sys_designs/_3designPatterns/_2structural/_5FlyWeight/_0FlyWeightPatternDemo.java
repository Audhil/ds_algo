package _interview_prep._0sys_designs._3designPatterns._2structural._5FlyWeight;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//  https://youtu.be/5yFLruVyOvg?list=PLt4nG7RVVk1h9lxOYSOGI9pcP3I5oblbx
public class _0FlyWeightPatternDemo {

  //  use this pattern when we are creating objects >= 10^5
  //  creates object once and modified and used many times

  //  intrinsic props: same for the object - Developer, Tester
  //  extrinsic props: different for object - Skills(C++ developer, Python developer, Selenium tester, espresso tester etc)


  private interface Employee {

    void assignSkill(String skill);

    void task();
  }

  //  Developer
  private static class Developer implements Employee {

    private final String JOB;
    private String skill;

    public Developer() {
      JOB = "fix the issue";
    }

    @Override
    public void assignSkill(String skill) {
      this.skill = skill;
    }

    @Override
    public void task() {
      System.out.println("Developer with skill: " + skill + ", with the job: " + JOB);
    }
  }

  //  Tester
  private static class Tester implements Employee {

    private final String JOB;
    private String skill;

    public Tester() {
      JOB = "test the issue";
    }

    @Override
    public void assignSkill(String skill) {
      this.skill = skill;
    }

    @Override
    public void task() {
      System.out.println("Tester with skill: " + skill + ", with the job: " + JOB);
    }
  }

  //  factory
  private static class EmployeeFactory {

    private static final Map<String, Employee> cMap = new HashMap<>();

    public static Employee getEmployee(String type) {
      Employee employee = null;
      if (cMap.get(type) != null) {
        employee = cMap.get(type);
      } else {
        switch (type) {
          case "Developer":
            System.out.println("yup: Developer created");
            employee = new Developer();
            break;

          case "Tester":
            System.out.println("yup: Tester created");
            employee = new Tester();
            break;
        }
        cMap.put(type, employee);
      }
      return employee;
    }
  }

  public static void main(String[] args) {
    String[] empList = {"Developer", "Tester"};
    String[] skills = {"Java", "Kotlin", "C#", "Selenium", "Espresso"};

    //  notice tester & developer created only once
    //  yup: Tester created
    //  Tester with skill: Java, with the job: test the issue
    //  yup: Developer created
    //  Developer with skill: C#, with the job: fix the issue
    //  Tester with skill: Kotlin, with the job: test the issue
    //  Tester with skill: C#, with the job: test the issue
    //  Tester with skill: Selenium, with the job: test the issue
    //  Developer with skill: Kotlin, with the job: fix the issue
    //  Developer with skill: Java, with the job: fix the issue
    //  Tester with skill: C#, with the job: test the issue
    //  Tester with skill: Java, with the job: test the issue
    //  Tester with skill: Kotlin, with the job: test the issue
    for (int i = 0; i < 10; i++) {
      Employee e = EmployeeFactory.getEmployee(empList[new Random().nextInt(empList.length)]);
      e.assignSkill(skills[new Random().nextInt(skills.length)]);
      e.task();
    }
  }
}
