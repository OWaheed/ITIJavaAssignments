import java.util.*;

public class main_class {
    public static void main(String[] args) {

    CityDao c =new CityDao();
    CountryDao CountDao= new CountryDao();


    //loading all cities from csv
    ArrayList<City> Cities = c.readAllCites("cities.csv");
    //loading all countries from  csv
    ArrayList<Country> Countries =CountDao.readAllCountries("cities.csv");
    for (Country country : Countries) {
        for (City city : Cities) {
            if (country.getCode() == city.getCode()) {
                country.setCity(city);
            }
        }

    }
    //create map with country code as a key and country cities as a value
    Map<Integer,ArrayList<City>> CountriesMAp =new HashMap<>();
    for (Country count: Countries){
         CountriesMAp.put(count.getCode(), count.getCities());

        }

    int code = 1;
        System.out.println("Print Country 1 Cities With Population sorted");
        ArrayList<City> citiess=CountriesMAp.get(1);
        Collections.sort(citiess,Comparator.comparing(City::getPopulation));
        for (City ccc : citiess){
            System.out.println(ccc.toString());
        }












    }
}

