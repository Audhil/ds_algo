package _interview_prep._0sys_designs._3designPatterns._2structural._6Adapter;

//  https://youtu.be/FsS-jWCPtQI?list=PLt4nG7RVVk1h9lxOYSOGI9pcP3I5oblbx
public class _0AdapterPatternDemo {

  private interface WebDriver {

    void getElement();

    void selectElement();
  }

  //  chrome driver
  private static class ChromeDriver implements WebDriver {

    @Override
    public void getElement() {
      System.out.println("ChromeDriver: getElement()");
    }

    @Override
    public void selectElement() {
      System.out.println("ChromeDriver: selectElement()");
    }
  }

  //  ie driver
  private static class IEDriver {

    public void findElement() {
      System.out.println("IEDriver: findElement()");
    }

    public void clickElement() {
      System.out.println("IEDriver: clickElement()");
    }
  }

  //  adapter
  private static class WebDriverAdapter implements WebDriver {

    private final IEDriver ieDriver;

    public WebDriverAdapter(IEDriver ieDriver) {
      this.ieDriver = ieDriver;
    }

    @Override
    public void getElement() {
      ieDriver.findElement();
    }

    @Override
    public void selectElement() {
      ieDriver.clickElement();
    }
  }

  public static void main(String[] args) {
    //  Chrome driver
    //  ChromeDriver: getElement()
    //  ChromeDriver: selectElement()
    ChromeDriver chromeDriver = new ChromeDriver();
    chromeDriver.getElement();
    chromeDriver.selectElement();

    //  IE driver
    //  IEDriver: clickElement()
    //  IEDriver: findElement()
    IEDriver ieDriver = new IEDriver();
    ieDriver.clickElement();
    ieDriver.findElement();

    //  WebDriver adapter
    //  yup: here's the adapter!
    //  IEDriver: findElement()
    //  IEDriver: clickElement()
    System.out.println("yup: here's the adapter!");
    WebDriver webDriverAdapter = new WebDriverAdapter(ieDriver);
    webDriverAdapter.getElement();
    webDriverAdapter.selectElement();
  }
}
