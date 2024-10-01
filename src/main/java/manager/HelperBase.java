package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {

        this.wd = wd;
    }

    public  void type(By locator, String text){
        WebElement element =wd.findElement(locator);
        element.click();
        element.clear();
        if(text!=null){

            element.sendKeys(text);
        }
    }

    public  void type(By locator, int text){
        WebElement element =wd.findElement(locator);
        element.click();
        element.clear();
        Integer i = text;
        if(i>0){

            element.sendKeys(i.toString());
        }
    }

    public  void type(By locator, double text){
        WebElement element =wd.findElement(locator);
        element.click();
        element.clear();
        Double d= text;
        if(d>0){

            element.sendKeys(d.toString());
        }
    }

    public  void click(By locator){
        WebElement element = wd.findElement(locator);
        element.click();
    }



    public  boolean isElementPresent(By locator){
        List<WebElement> list = wd.findElements(locator);
        return list.size()>0;
    }
}
