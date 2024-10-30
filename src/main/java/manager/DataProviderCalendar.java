package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderCalendar {

    @DataProvider
    public Iterator<Object[]> SearchCarCalendarData() throws IOException {
        List<Object[]> list = new ArrayList<>();
        //read from file & add to list
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/test.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[] all = line.split(":");//[mara@gmail.com],[Mmar123456$]
            list.add(new Object[]{all[0],all[1], all[2]});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
