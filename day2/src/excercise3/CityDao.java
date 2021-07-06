package excercise3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityDao {

    public ArrayList<City> readAllCites(String fileName) {
        ArrayList<City> cities =new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(fileName));
            String line=sc.nextLine();
            while (sc.hasNext())  //returns a boolean value
            {
                line = sc.nextLine();
                cities.add(createCity(line));



            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    return cities;
    }

    private City createCity(String line) {
        String[] fields = line.split(",");
        return new City(Integer.parseInt(fields[0]), fields[1], fields[2], Double.parseDouble(fields[3]), Double.parseDouble(fields[4]));
    }

}