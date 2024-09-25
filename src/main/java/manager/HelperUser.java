package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {

        super(wd);
    }

    public void openLoginForm(){
        WebElement el = wd.findElement(By.xpath("//a[text()='Log in']"));
        el.click();
        //click(By.xpath("//a[text()='Log in']"));
    }

    public void fillLoginForm(String email, String password) {

        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void submitLogin() {
        click(By.xpath("//button[text()='Y’alla!']"));
    }

    public boolean isLogget() {
        return  isElementPresent(By.xpath("//h2[text()='Logged in success']"));
    }
}
