package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class ChangePassHelper extends HelperBase {

    public ChangePassHelper(ApplicationManager app) {
      super(app);
    }

  public void init(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "login_page.php");
    type(By.name("username"), username);
    click(By.cssSelector("input[type='submit']"));
    //Thread.sleep(1000);
    //wd.navigate().to(app.getProperty("web.baseUrl") + "login_password_page.php");
    //wd.get(app.getProperty("web.baseUrl") + "login_password_page.php");
    type(By.name("password"), password);
    //type(By.name("email"), email);
    click(By.cssSelector("input[type='submit']"));
  }

  public void resetPassword(Integer user) {
    wd.get(app.getProperty("web.baseUrl") + "manage_user_edit_page.php?user_id="+ user);
    click(By.cssSelector("input[value='—бросить пароль']"));
  }

  public void setNewPassword(String findConfirmarionLink, String password) {
    wd.get(findConfirmarionLink);
    //type(By.name("realname"), login);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("button[type='submit']"));
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
  }
}
