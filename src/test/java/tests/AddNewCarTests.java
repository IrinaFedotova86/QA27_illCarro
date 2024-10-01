package tests;

import models.Car;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase{


    @Test
    public void addNewCarSuccess(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("M3")
                .year("2022")
                .fuel("Petrol")
                .seat(4)
                .carClass("C")
                .carRegNumber("678-900"+i)
                .price(50)
                .about("Nice car")
                .build();
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submitCarForm();
    }
}
