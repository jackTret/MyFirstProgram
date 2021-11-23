package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class RegistrationHelper extends HelperBase{

  public RegistrationHelper(ApplicationManager app) {

    super(app);
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl") + "signup_page.php");
    type(By.name("username"), username);
    type(By.name("email"), email);
    click(By.cssSelector("input[type='submit']"));
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    //click(By.cssSelector("input[value='Update User']"));
    click(By.cssSelector("button[type='submit']"));
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
  }


  public void login(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), username);
    click(By.cssSelector("input.width-40.pull-right.btn.btn-success.btn-inverse.bigger-110"));
    type(By.name("password"), password);
    click(By.cssSelector("input.width-40.pull-right.btn.btn-success.btn-inverse.bigger-110"));
  }
}
