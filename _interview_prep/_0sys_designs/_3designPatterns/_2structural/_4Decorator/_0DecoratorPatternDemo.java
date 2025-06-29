package _interview_prep._0sys_designs._3designPatterns._2structural._4Decorator;

//  https://youtu.be/ZdE9x-qE8_c?list=PLt4nG7RVVk1h9lxOYSOGI9pcP3I5oblbx
public class _0DecoratorPatternDemo {

  private interface Dress {

    public void assemble();
  }

  //  dress decorator
  private static class DressDecorator implements Dress {

    private final Dress dress;

    public DressDecorator(Dress dress) {
      this.dress = dress;
    }

    @Override
    public void assemble() {
      dress.assemble();
    }
  }

  //  basic dress
  private static class BasicDress implements Dress {

    @Override
    public void assemble() {
      System.out.println("Basic dress: assembled");
    }
  }

  //  fancy dress
  private static class FancyDress extends DressDecorator {

    public FancyDress(Dress dress) {
      super(dress);
    }

    @Override
    public void assemble() {
      super.assemble();
      System.out.println("added fancy components");
    }
  }

  //  casual dress
  private static class CasualDress extends DressDecorator {

    public CasualDress(Dress dress) {
      super(dress);
    }

    @Override
    public void assemble() {
      super.assemble();
      System.out.println("added casual components");
    }
  }

  //  sports dress
  private static class SportsDress extends DressDecorator {

    public SportsDress(Dress dress) {
      super(dress);
    }

    @Override
    public void assemble() {
      super.assemble();
      System.out.println("added Sports components");
    }
  }

  public static void main(String[] args) {
    /*
    * Basic dress: assembled
      added fancy components
      * */
    Dress fancyDress = new FancyDress(new BasicDress());
    fancyDress.assemble();
    System.out.println();

    //  Basic dress: assembled
    //  added Sports components
    Dress sportyDress = new SportsDress(new BasicDress());
    sportyDress.assemble();
    System.out.println();

    //  Basic dress: assembled
    //  added casual components
    Dress casualDress = new CasualDress(new BasicDress());
    casualDress.assemble();
    System.out.println();

    //  sporty fancy dress
    //  Basic dress: assembled
    //  added fancy components
    //  added Sports components
    Dress sportyFancyDress = new SportsDress(new FancyDress(new BasicDress()));
    sportyFancyDress.assemble();
    System.out.println();

    //  casual fancy dress
    //  Basic dress: assembled
    //  added fancy components
    //  added casual components
    Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
    casualFancyDress.assemble();
    System.out.println();

    //  Basic dress: assembled
    //  added Sports components
    //  added fancy components
    //  added casual components
    Dress casualFancySportyDress = new CasualDress(
        new FancyDress(new SportsDress(new BasicDress())));
    casualFancySportyDress.assemble();
    System.out.println();
  }
}
