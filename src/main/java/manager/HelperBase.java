package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HelperBase {
    WebDriver wd;
    Logger logger = LoggerFactory.getLogger(HelperBase.class);

    public HelperBase(WebDriver wd) {

        this.wd = wd;
    }

    public  void type(By locator, String text){
        WebElement element =wd.findElement(locator);
        element.click();
        element.clear();
        clearNew(element);
        if(text!=null){

            element.sendKeys(text);
        }
    }

    public  void type(By locator, int text){
        WebElement element =wd.findElement(locator);
        element.click();
        element.clear();
        Integer i = text;
        clearNew(element);
        if(i>0){

            element.sendKeys(i.toString());
        }
    }

    public  void type(By locator, double text){
        WebElement element =wd.findElement(locator);
        element.click();
        element.clear();
        Double d= text;
        clearNew(element);
        if(d>0){

            element.sendKeys(d.toString());
        }
    }

    public void clearNew(WebElement element){
        element.sendKeys(" ");
        element.sendKeys(Keys.BACK_SPACE);
    }

    public  void click(By locator){
        WebElement element = wd.findElement(locator);
        element.click();
    }



    public  boolean isElementPresent(By locator){
        List<WebElement> list = wd.findElements(locator);
        return list.size()>0;
    }

    public void submit() {
        click(By.xpath("//*[@type='submit']"));
    }

    public void pause(int time){
        try {

            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
