import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryDao {



    public ArrayList<Country> readAllCountries(String fileName) {
        ArrayList<Country> countries = new ArrayList<>();
      try {
          Scanner sc = new Scanner(new File(fileName));
          String line=sc.nextLine();
          while (sc.hasNext())  //returns a boolean value
          {
              line = sc.nextLine();
              countries.add(createCountry(line));



          }

      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }

        return countries;

    }

    private Country createCountry(String line) {
        String[] fields = line.split(",");
        return new Country(Integer.parseInt(fields[0]), fields[1]);
    }
}
