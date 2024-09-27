package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends  TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("rnk86@mail.ru", "QweAsd12$");
        app.getHelperUser().submit();

        Assert.assertTrue(app.getHelperUser().isLogget());
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
       // app.getHelperUser().clickOkButton();
    }

    @Test
    public void loginSuccessModel(){

        //User user = new User().setEmail("margo@gmail.com").setPassword("Mmar123456$");


        //user.setEmail("margo@gmail.com");
        //user.setPassword("Mmar123456$");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("rnk86@mail.ru", "QweAsd12$");
        app.getHelperUser().submit();

        Assert.assertTrue(app.getHelperUser().isLogget());
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOkButton();
    }

    @Test
    public void loginWrongEmail(){

        User user = new User().setEmail("rnk86@mailru").setPassword("QweAsd12$");


        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }

    @Test
    public void loginWrongPassword(){

        User user = new User().setEmail("rnk86@mail.ru").setPassword("QweAsd312$");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
    }

    @Test
    public void loginUnredisteredUser(){

        User user = new User().setEmail("marg@gmail.com").setPassword("Mmar12gtr$");

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
    }



    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOkButton();

    }
}
