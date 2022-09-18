package _interview_prep._0sys_designs._3designPatterns._2structural._1Proxy;

//  https://youtu.be/AB0gaAg9jwI?list=PLt4nG7RVVk1h9lxOYSOGI9pcP3I5oblbx
public class _0ProxyDesignPatternDemo {

  public interface DatabaseExecutor {

    public void executeQuery(String query) throws Exception;
  }

  private static class DatabaseExecutorImpl implements DatabaseExecutor {

    @Override
    public void executeQuery(String query) {
      System.out.println("yup: executing query: " + query);
    }
  }

  //  proxy
  private static class DatabaseExecutorProxy implements DatabaseExecutor {

    private boolean isAdmin;
    private final DatabaseExecutorImpl databaseExecutor;

    public DatabaseExecutorProxy(String role, String pwd) {
      databaseExecutor = new DatabaseExecutorImpl();
      if (role.equals("Admin") && pwd.equals("1234")) {
        isAdmin = true;
      }
    }

    @Override
    public void executeQuery(String query) throws Exception {
      if (isAdmin) {
        databaseExecutor.executeQuery(query);
      } else {
        if (query.equals("DELETE")) {
          throw new Exception("Delete is not allowed");
        } else {
          databaseExecutor.executeQuery(query);
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    DatabaseExecutorProxy nonAdmin = new DatabaseExecutorProxy("Audhil", "1234");
    nonAdmin.executeQuery("DELETE");  //  Exception in thread "main" java.lang.Exception: Delete is not allowed

    DatabaseExecutorProxy admin = new DatabaseExecutorProxy("Admin", "1234");
    admin.executeQuery("DELETE"); //  yup: executing query: DELETE
  }
}
