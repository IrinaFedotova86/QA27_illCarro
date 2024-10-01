package manager;

import enums.Fuel;
import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperCar extends HelperBase{
    public HelperCar(WebDriver wd) {
        super(wd);
    }


    public void openCarForm() {
        WebElement el = wd.findElement(By.xpath("//a[text()=' Let the car work ']"));
        el.click();
    }

    public void fillCarForm(Car car) {
        type(By.id("pickUpPlace"), car.getLocation());
        type(By.id("make"), car.getManufacture());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        //type(By.id("fuel"), car.getFuel());
        type(By.id("seats"), car.getSeat());
        type(By.id("class"), car.getCarClass());
        type(By.id("serialNumber"), car.getCarRegNumber());
        type(By.id("price"), car.getPrice());

        clickFuel(car.getFuel());
    }

    private void clickFuel(Fuel fuel) {
        WebElement elementFuel = wd.findElement(By.xpath(fuel.getLocator()));
        elementFuel.click();
    }

    public void submitCarForm() {
        click(By.xpath("//*[@type='submit']"));
    }
}
