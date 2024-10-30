package tests;

import manager.DataProviderCalendar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase{

    @Test
    public void searchCurrentMonthSuccess(){
        app.getHelperCar().searchCurrentMonth("Haifa, Israel", "10/30/2024","10/31/2024");
        app.getHelperCar().submit();
        //app.getHelperCar().pause(10000);
        Assert.assertTrue(app.getHelperCar().isListCarsAppeared());
        //app.getHelperCar().pause(10000);
    }

    @Test
    public void searchCurrentYearSuccess(){
        app.getHelperCar().searchCurrentYear("Haifa, Israel", "11/21/2024","12/25/2024");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListCarsAppeared());
    }

    @Test(dataProvider = "SearchCarCalendarData", dataProviderClass = DataProviderCalendar.class)
    public void searchAnyPeriodSuccess(String city, String dataFrom, String dataTo){
        app.getHelperCar().searchAnyPeriod(city, dataFrom, dataTo);
        app.getHelperCar().submit();


        Assert.assertTrue(app.getHelperCar().isListCarsAppeared());
        app.getHelperCar().clickSearch();
    }

}
