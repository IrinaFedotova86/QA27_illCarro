package tests;

import enums.Fuel;
import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase{

    @BeforeClass
    public void precondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("marga@gmail.com").setPassword("Mmar123456$"));
        }
    }

    @Test
    public void addNewCarSuccess(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("M3")
                .year("2022")
               // .fuel(Fuel.PETROL)
                .fuel("Petrol")
                .seat(4)
                .carClass("C")
                .carRegNumber("678-"+i)
                .price(50)
                .about("Nice car")
                .build();
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("C:\\QA_Auto\\StartNew\\QA27_illCarro1\\src\\main\\resources\\img\\65178948.jpg");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperUser().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperUser().getMessage(), car.getManufacture()+" "+car.getModel()+" "+"added successful");
    }

    @Test
    public void addNewCarRequiredFieldsSuccess(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazdaa")
                .model("M2")
                .year("2020")
                // .fuel(Fuel.PETROL)
                .fuel("Petrol")
                .seat(4)
                .carClass("C")
                .carRegNumber("678-"+i)
                .price(50)
                .build();
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperUser().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperUser().getMessage(), car.getManufacture()+" "+car.getModel()+" "+"added successful");
    }

    @AfterMethod
    public void postCondition(){
        app.getHelperCar().returnToHomePage();
    }
}
