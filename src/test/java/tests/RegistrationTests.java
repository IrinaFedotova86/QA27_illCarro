package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess() {
        int i = new Random().nextInt(1000) + 1000;
        //System.out.println(System.currentTimeMillis());
        int z = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User().setFirstName("Lisa").setLastName("Snow").setEmail("snow" + i + "@gmail.com").setPassword("Ssnow12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");

    }

    @Test
    public void registrationEmptyName() {
        int i = new Random().nextInt(1000) + 1000;
        //System.out.println(System.currentTimeMillis());
        int z = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User().setFirstName("").setLastName("Snow").setEmail("snow" + i + "@gmail.com").setPassword("Ssnow12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Name is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }

    @Test
    public void registrationEmptyName2() {
        int i = new Random().nextInt(1000) + 1000;
        //System.out.println(System.currentTimeMillis());
        int z = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User().setFirstName(" ").setLastName("Snow").setEmail("snow" + i + "@gmail.com").setPassword("Ssnow12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "{\"firstName\":\"не должно быть пустым\"}");


    }

    @Test
    public void registrationEmptyLastName() {
        int i = new Random().nextInt(1000) + 1000;
        //System.out.println(System.currentTimeMillis());
        int z = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User().setFirstName("Lisa").setLastName("").setEmail("snow" + i + "@gmail.com").setPassword("Ssnow12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Last name is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }

    @Test
    public void registrationWrongEmail() {
        int i = new Random().nextInt(1000) + 1000;
        //System.out.println(System.currentTimeMillis());
        int z = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User().setFirstName("Lisa").setLastName("Snow").setEmail("snow" + i + "gmail.com").setPassword("Ssnow12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Wrong email format\nWrong email format");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }

    @Test
    public void registrationWrongPassword() {
        int i = new Random().nextInt(1000) + 1000;
        //System.out.println(System.currentTimeMillis());
        int z = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User().setFirstName("Lisa").setLastName("Snow").setEmail("snow" + i + "@gmail.com").setPassword("Ssnow$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password must contain minimum 8 symbols\nPassword must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();

    }

}


