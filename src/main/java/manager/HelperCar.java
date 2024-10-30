package manager;

import enums.Fuel;
import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.openqa.selenium.devtools.v118.debugger.Debugger.pause;

public class HelperCar extends HelperBase{
    public HelperCar(WebDriver wd) {
        super(wd);
    }


    public void openCarForm() {
        pause(500);
        WebElement el = wd.findElement(By.xpath("//a[text()=' Let the car work ']"));
        el.click();
    }

    public void fillCarForm(Car car) {
        typeLocation(car.getLocation()); //By.id("pickUpPlace"), car.getLocation());
        type(By.id("make"), car.getManufacture());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        //type(By.id("fuel"), car.getFuel());
        select(By.id("fuel"), car.getFuel());
        type(By.id("seats"), String.valueOf(car.getSeat()));
        type(By.id("class"), car.getCarClass());
        type(By.id("serialNumber"), car.getCarRegNumber());
        //type(By.id("price"), car.getPrice());
        type(By.id("price"), car.getPrice()+"");
        type(By.id("about"), car.getAbout());

        //clickFuel(car.getFuel());
    }

    private void select(By locator, String option) {
        Select select = new Select(wd.findElement(locator));
        //select.selectByIndex(5); //gas
        //select.selectByVisibleText(" Gas ");
        //select.selectByValue("Gas");
        select.selectByValue(option);
    }

    private void typeLocation(String location) {
        type(By.id("pickUpPlace"), location);
        click(By.cssSelector("div.pac-item"));
    }

    private void clickFuel(Fuel fuel) {
        WebElement elementFuel = wd.findElement(By.xpath(fuel.getLocator()));
        elementFuel.click();
    }

    public void returnToHomePage() {
        click(By.xpath("//button[text()='Search cars']"));
    }

    public void attachPhoto(String link) {
        wd.findElement(By.id("photos")).sendKeys(link);
    }

    public void searchCurrentMonth(String city, String dateFrom, String dateTo) {
        typeCity(city);
        click(By.id("dates"));

        //10/29/2024  -  10/31/2024
        String[] from = dateFrom.split("/");
        String locatorFrom = "//div[text()=' "+from[1]+" ']";
        click(By.xpath(locatorFrom));

        String[] to = dateTo.split("/");
        String locatorTo = "//div[text()=' "+to[1]+" ']";
        click(By.xpath(locatorTo));
        pause(10000);
    }

    private void typeCity(String city) {
        type(By.id("city"), city);
        click(By.cssSelector("div.pac-item"));
    }

    public boolean isListCarsAppeared() {
        return isElementPresent(By.cssSelector("a.car-container"));
    }

    public void searchCurrentYear(String city, String dataFrom, String dataTo) {
        typeCity(city);
        click(By.id("dates"));

        //11/21/2024  -  12/25/2024

        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();

        LocalDate from = LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));

        int diffMonth = from.getMonthValue() - month;

        if(diffMonth>0){
            clickNextMonthBtn(diffMonth);
        }
        click(By.xpath("//div[text()=' "+from.getDayOfMonth()+" ']"));

        LocalDate to = LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("M/d/yyyy"));

        diffMonth = to.getMonthValue() - from.getMonthValue();
        if(diffMonth>0){
            clickNextMonthBtn(diffMonth);
        }
        click(By.xpath("//div[text()=' "+to.getDayOfMonth()+" ']"));
        pause(10000);
    }

    private void clickNextMonthBtn(int diffMonth) {
        for(int i= 0;i<diffMonth;i++){
            click(By.cssSelector("button[aria-label='Next month']"));
        }
    }

    public void searchAnyPeriod(String city, String dataFrom, String dataTo) {

        typeCity(city);
        click(By.id("dates"));

        //11/21/2024  -  9/25/2025

        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();

        LocalDate from = LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("M/d/yyyy"));

        int diffYear = from.getYear() - year;


        if(diffYear>0){
            int diffMonth = 12-month + from.getMonthValue();
            clickNextMonthBtn(diffMonth);
            click(By.xpath("//div[text()=' "+from.getDayOfMonth()+" ']"));

            diffMonth = to.getMonthValue() - from.getMonthValue();
            if(diffMonth>0){
                clickNextMonthBtn(diffMonth);
            }
            click(By.xpath("//div[text()=' "+to.getDayOfMonth()+" ']"));
        }
        else {
            int diffMonth = from.getMonthValue() - month;
            if (diffMonth > 0) {
                clickNextMonthBtn(diffMonth);
            }
            click(By.xpath("//div[text()=' " + from.getDayOfMonth() + " ']"));
        }

        diffYear = to.getYear()-year;
        if(diffYear>0) {
            int diffMonth = 12 - from.getMonthValue() + to.getMonthValue();
            clickNextMonthBtn(diffMonth);
            click(By.xpath("//div[text()=' " + to.getDayOfMonth() + " ']"));
        }
        else {

            int diffMonth = to.getMonthValue() - from.getMonthValue();
            if (diffMonth > 0) {
                clickNextMonthBtn(diffMonth);
            }
            click(By.xpath("//div[text()=' " + to.getDayOfMonth() + " ']"));
        }
   // pause(10000);
    }

    public void clickSearch() {
        click(By.xpath("//a[text()=' Search ']"));
    }

    //  public void submitCarForm() {
  //      click(By.xpath("//*[@type='submit']"));
  //  }
}
