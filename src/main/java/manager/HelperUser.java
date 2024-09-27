package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {

        super(wd);
    }

    public void openLoginForm(){
        WebElement el = wd.findElement(By.xpath("//a[text()=' Log in ']"));
        el.click();
        //click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {

        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void fillLoginForm(User user) {

        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void submit() {
        click(By.xpath("//*[@type='submit']"));
        //click(By.xpath("//button[text()='Y’alla!']"));
    }

    public boolean isLogget() {
        return  isElementPresent(By.xpath("//h2[text()='Logged in success']"));
    }

    public void clickOkButton() {
        click(By.xpath("//button[text()='Ok']"));
    }

    public String getMessage() {
       // WebElement el = wd.findElement(By.cssSelector(".dialog-container>h2"));
       // String text = el.getText();
       // return text;
        pause(3000);
        System.out.println(wd.findElement(By.cssSelector(".dialog-container>h2")).getText());
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }

    public void pause(int time){
        try {

            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getFirstName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void checkPolicy() {
        //click(By.id("terms-of-use"));
        //click(By.cssSelector("label[for='terms-of-use']"));
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click()");
    }


}
