package ru.stqa.new_project.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class testContactCreation {
  private WebDriver wb;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wb = new FirefoxDriver();
    wb.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testContactCreationTests() throws Exception {
    wb.get("http://localhost/addressbook/group.php");
    wb.findElement(By.xpath("//*/text()[normalize-space(.)='']/parent::*")).click();
    wb.findElement(By.name("user")).click();
    wb.findElement(By.name("user")).click();
    wb.findElement(By.name("user")).clear();
    wb.findElement(By.name("user")).sendKeys("admin");
    wb.findElement(By.name("pass")).clear();
    wb.findElement(By.name("pass")).sendKeys("secret");
    wb.findElement(By.xpath("//input[@value='Login']")).click();
    wb.findElement(By.linkText("add new")).click();
    wb.findElement(By.name("firstname")).click();
    wb.findElement(By.name("firstname")).click();
    wb.findElement(By.name("firstname")).clear();
    wb.findElement(By.name("firstname")).sendKeys("Petr");
    wb.findElement(By.name("middlename")).clear();
    wb.findElement(By.name("middlename")).sendKeys("Pavlovich");
    wb.findElement(By.name("lastname")).clear();
    wb.findElement(By.name("lastname")).sendKeys("Ledovskiy");
    wb.findElement(By.name("nickname")).clear();
    wb.findElement(By.name("nickname")).sendKeys("Petrucho");
    wb.findElement(By.name("company")).click();
    wb.findElement(By.name("company")).clear();
    wb.findElement(By.name("company")).sendKeys("Hot");
    wb.findElement(By.name("address")).click();
    wb.findElement(By.name("home")).click();
    wb.findElement(By.name("mobile")).click();
    wb.findElement(By.name("mobile")).clear();
    wb.findElement(By.name("mobile")).sendKeys("+79075642331");
    wb.findElement(By.name("email")).click();
    wb.findElement(By.name("email")).clear();
    wb.findElement(By.name("email")).sendKeys("petrucho@gmail.com");
    wb.findElement(By.name("new_group")).click();
    new Select(wb.findElement(By.name("new_group"))).selectByVisibleText("test1");
    wb.findElement(By.name("new_group")).click();
    wb.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    wb.findElement(By.linkText("home page")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wb.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wb.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wb.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
