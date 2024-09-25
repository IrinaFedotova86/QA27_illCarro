package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends  TestBase{

    @Test
    public void test(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("rnk86@mail.ru", "QweAsd12$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogget());
    }
}
