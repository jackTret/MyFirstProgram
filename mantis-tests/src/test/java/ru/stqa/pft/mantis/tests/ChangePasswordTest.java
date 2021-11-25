package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;


public class ChangePasswordTest extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testChangePassword () throws IOException, MessagingException {
    UserData userData = app.db().users()
            .stream().filter((u) -> (!u.getUserName().equals("administrator")))
            .collect(Collectors.toList()).iterator().next();
    String email = userData.getEmail();
    String user = userData.getUserName();
    String password = "root";
    String newPassword = "newPassword";
    String admin = "administrator";
    Integer userId = userData.getId();
    app.change().init(admin, password);
    app.newSession().login(password, admin);
    app.change().resetPassword(userId);
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.change().setNewPassword(confirmationLink, newPassword);
    app.newSession().login(newPassword, user);
  }

  public String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

 @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
